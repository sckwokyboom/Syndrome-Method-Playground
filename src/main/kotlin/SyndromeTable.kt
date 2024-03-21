import kotlin.math.pow

class SyndromeTable(private val codeLength: Int, private val parityCheckLength: Int) {
    private var table: HashMap<Codeword, Codeword>? = null
    private var syndromeSet: HashSet<Codeword>? = null
    public fun getTable(parityCheckMatrix: Matrix): HashMap<Codeword, Codeword> {
        if (table == null) {
            fillTable(parityCheckMatrix)
        }
        return table!!
    }

    private fun fillTable(parityCheckMatrix: Matrix) {
        table = HashMap()
        syndromeSet = HashSet()
        table!![Codeword(0, parityCheckLength)] = Codeword(0, codeLength)
        syndromeSet!!.add(Codeword(0, parityCheckLength))
        val binaryViewLimit = 2.0.pow(codeLength)
        val stream = generateSequence(1) { it * 2 + 1 }
        for (i in stream) {
            println("i = $i")
            if (i > codeLength) {
                break
            }
            var v = i
            println("v = $v")
            val basicVectors = Codeword(codeLength)
            for (j in 0 until codeLength) {
                if ((v and (1 shl j)) != 0) {
                    basicVectors.set(j)
                }
            }
            val transposeVector = Matrix(basicVectors.toArray()).transpose()
            val syndrome = Codeword((parityCheckMatrix * transposeVector).column(0))
            if (!syndromeSet!!.contains(syndrome)) {
                syndromeSet!!.add(syndrome)
                table!![syndrome] = basicVectors
            }
//            println(v)
            while (v < binaryViewLimit) {
                val t = (v or (v - 1)) + 1
                val w = t or ((((t and -t) / (v and -v)) shr 1) - 1)
                if (w < binaryViewLimit) {
                    v = w
                    val basicVectors = Codeword(codeLength)
                    for (j in 0 until codeLength) {
                        if ((v and (1 shl j)) != 0) {
                            basicVectors.set(j)
                        }
                    }
                    val transposeVector = Matrix(basicVectors.toArray()).transpose()
                    val syndrome = Codeword((parityCheckMatrix * transposeVector).column(0))
                    println("v = $v; y = $basicVectors; H * y^T = $syndrome")
                    if (!syndromeSet!!.contains(syndrome)) {
                        syndromeSet!!.add(syndrome)
                        table!![syndrome] = basicVectors
                    }
                } else {
                    break
                }
            }
        }
        println(syndromeSet)
    }
}