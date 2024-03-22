package model

import allBinaryVectorPermutations
import canonicalconverter.Matrix
import model.code.Code
import kotlin.math.pow

class SyndromeTable(private val code: Code) {
    private var table: HashMap<BinaryVector, BinaryVector>? = null
    private var syndromeSet: HashSet<BinaryVector>? = null
    fun getTable(): HashMap<BinaryVector, BinaryVector> {
        if (table == null) {
            fillTable(code.parityCheckMatrix)
        }
        return table!!
    }

    fun getLeader(syndrome: BinaryVector): BinaryVector {
        if (table == null) {
            fillTable(code.parityCheckMatrix)
        }
        val leader = table!![syndrome]
            ?: throw IllegalArgumentException("Декодирование невозможно. Такого синдрома нет в таблице.")
        return leader
    }

    private fun fillTable(parityCheckMatrix: Matrix) {
        table = HashMap()
        syndromeSet = HashSet()
        val syndromeSetLimit = 2.0.pow(code.parityCheckLength).toInt()
        table!![BinaryVector(0, code.parityCheckLength)] = BinaryVector(0, code.length)
        syndromeSet!!.add(BinaryVector(0, code.parityCheckLength))

        outerLoop@ for (i in 1 until code.length) {
            for (permutation in allBinaryVectorPermutations(i, code.length)) {
                if (syndromeSet!!.size == syndromeSetLimit) {
                    break@outerLoop
                }
                val basicVectorsPositions = BinaryVector(permutation, code.length)
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