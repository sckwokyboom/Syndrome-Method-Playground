package model

import allBinaryVectorPermutations
import canonicalconverter.Matrix
import kotlin.math.pow

class SyndromeTable(private val codeLength: Int, private val parityCheckLength: Int) {
    private var table: HashMap<BinaryVector, BinaryVector>? = null
    private var syndromeSet: HashSet<BinaryVector>? = null
    public fun getTable(parityCheckMatrix: Matrix): HashMap<BinaryVector, BinaryVector> {
        if (table == null) {
            fillTable(parityCheckMatrix)
        }
        return table!!
    }

    private fun fillTable(parityCheckMatrix: Matrix) {
        table = HashMap()
        syndromeSet = HashSet()
        val syndromeSetLimit = 2.0.pow(parityCheckLength).toInt()
        table!![BinaryVector(0, parityCheckLength)] = BinaryVector(0, codeLength)
        syndromeSet!!.add(BinaryVector(0, parityCheckLength))

        outerLoop@ for (i in 1 until codeLength) {
            for (permutation in allBinaryVectorPermutations(i, codeLength)) {
                if (syndromeSet!!.size == syndromeSetLimit) {
                    break@outerLoop
                }
                val basicVectorsPositions = BinaryVector(permutation, codeLength)
                val transposeVector = Matrix(basicVectorsPositions.toArray()).transpose()
                val syndrome = BinaryVector((parityCheckMatrix * transposeVector).column(0))
                if (!syndromeSet!!.contains(syndrome)) {
                    syndromeSet!!.add(syndrome)
                    table!![syndrome] = basicVectorsPositions
                }
            }
        }
    }
}