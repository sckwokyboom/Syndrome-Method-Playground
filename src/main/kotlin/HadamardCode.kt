import canonicalconverter.CanonicalConverter
import java.util.*
import java.util.stream.Stream
import kotlin.math.pow

class HadamardCode(private val codeDimension: Int) : Code {
    companion object {
        private fun generateHammingParityCheckMatrix(codeDimension: Int): Matrix {
            val codeLength = (2.0.pow(codeDimension) - 1).toInt()
            val parityCheckMatrix = Matrix(codeDimension, codeLength)
            for (i in 0 until codeLength) {
                val binaryString = Integer.toBinaryString(i + 1).padStart(codeDimension, '0')
                for (j in 0 until codeDimension) {
                    parityCheckMatrix[j, i] = binaryString[j].code.toByte() - '0'.code.toByte()
                }
            }
            return parityCheckMatrix
        }
    }

    private val codeLength: Int = (2.0.pow(codeDimension) - 1).toInt()
    val generatorMatrix: Matrix = generateHammingParityCheckMatrix(codeDimension)
    val parityCheckMatrix: Matrix
    private val parityCheckLength: Int = codeLength - codeDimension

    init {
        val convertor = CanonicalConverter()
        parityCheckMatrix = convertor.toParityCheck(generatorMatrix)
    }

    override fun getAllCodewords(): Stream<Codeword> {
        val countOfCodewords = (2.0.pow(codeDimension) - 1).toInt()
        val codeWords = HashSet<Codeword>()
        for (i in 0 until countOfCodewords + 1) {
            val basicVectors = BitSet(codeLength)
            for (j in 0 until codeLength) {
                if ((i and (1 shl j)) != 0) {
                    basicVectors.set(j)
                }
            }
            var codeWord = Codeword(codeLength)
            basicVectors.stream().forEach { ind ->
                run {
                    codeWord += Codeword(generatorMatrix.row(ind))
                }
            }
            codeWords.add(codeWord)
        }
        return codeWords.stream()
    }
}