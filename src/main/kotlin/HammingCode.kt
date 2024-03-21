import canonicalconverter.CanonicalConverter
import java.util.*
import java.util.stream.Stream
import kotlin.math.pow

class HammingCode(val parityLength: Int) : Code {
    companion object {
        private fun generateHammingParityCheckMatrix(parityLength: Int): Matrix {
            val codeLength = (2.0.pow(parityLength) - 1).toInt()
            val parityCheckMatrix = Matrix(parityLength, codeLength)
            for (i in 0 until codeLength) {
                val binaryString = Integer.toBinaryString(i + 1).padStart(parityLength, '0')
                for (j in 0 until parityLength) {
                    parityCheckMatrix[j, i] = binaryString[j].code.toByte() - '0'.code.toByte()
                }
            }
            return parityCheckMatrix
        }
    }

    val codeLength: Int = (2.0.pow(parityLength) - 1).toInt()
    val parityCheckMatrix: Matrix = generateHammingParityCheckMatrix(parityLength)
    val generatorMatrix: Matrix
    private val codeDimension: Int = codeLength - parityLength

    init {
        val convertor = CanonicalConverter()
        generatorMatrix = convertor.toGenerative(parityCheckMatrix)

    }

    override fun getAllCodewords(): Stream<Codeword> {
        val countOfCodewords = (2.0.pow(codeDimension) - 1).toInt()
        val codeWords = HashSet<Codeword>()
        for (i in 0 until countOfCodewords) {
            val basicVectors = BitSet(codeLength)
            for (j in 0 until codeLength + 1) {
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