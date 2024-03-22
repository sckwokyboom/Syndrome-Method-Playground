package model.code

import canonicalconverter.CanonicalConverter
import canonicalconverter.Matrix
import model.BinaryVector
import java.util.*
import java.util.stream.Stream
import kotlin.math.pow

class HammingCode(parityLength: Int) : Code() {
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

    override val length: Int = (2.0.pow(parityLength) - 1).toInt()
    override val parityCheckMatrix: Matrix = generateHammingParityCheckMatrix(parityLength)
    override val generatorMatrix: Matrix
    private val codeDimension: Int = length - parityLength
    override val parityCheckLength = parityLength

    init {
        val convertor = CanonicalConverter()
        generatorMatrix = convertor.toGenerative(parityCheckMatrix)

    }

    override fun getAllCodewords(): Stream<BinaryVector> {
        val countOfCodewords = (2.0.pow(codeDimension) - 1).toInt()
        val codeWords = HashSet<BinaryVector>()
        for (i in 0 until countOfCodewords) {
            val basicVectors = BitSet(length)
            for (j in 0 until length + 1) {
                if ((i and (1 shl j)) != 0) {
                    basicVectors.set(j)
                }
            }
            var codeWord = BinaryVector(length)
            basicVectors.stream().forEach { ind ->
                run {
                    codeWord += BinaryVector(generatorMatrix.row(ind))
                }
            }
            codeWords.add(codeWord)
        }
        return codeWords.stream()
    }
}