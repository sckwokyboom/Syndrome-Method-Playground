import java.util.*

class Codeword(private val size: Int) : BitSet() {
    // TODO: create constructor from String
//    constructor(codeword: String) {
//        return this;
//    }
    constructor(codeword: Array<Int>) : this(codeword.size) {
        for (i in codeword.indices) {
            this.set(i, codeword[i] == 1)
        }
    }

    constructor(value: Int, codeLength: Int) : this(codeLength) {
        for (j in 0 until codeLength + 1) {
            if ((value and (1 shl j)) != 0) {
                this.set(j)
            }
        }
    }

    override fun toString(): String {
        val binaryString = StringBuilder()
        for (i in 0 until size) {
            binaryString.append(if (this.get(i)) '1' else '0')
        }
        return binaryString.toString()
    }

    fun toArray(): Array<Int> {
        val arr = ArrayList<Int>(size)
        for (i in 0 until size + 1) {
            arr.add(i, this[i].compareTo(false))
        }
        return arr.toTypedArray()
    }


    override fun length(): Int {
        return size
    }

    override fun size(): Int {
        return size
    }

    operator fun plus(other: Codeword): Codeword {
        val tmp = this
        tmp.or(other)
        return tmp
    }

}