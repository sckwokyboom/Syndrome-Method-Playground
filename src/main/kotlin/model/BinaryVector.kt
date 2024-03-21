package model

import java.math.BigInteger
import java.util.*

class BinaryVector(private val size: Int) : BitSet() {
    // TODO: create constructor from String
//    constructor(codeword: String) {
//        return this;
//    }
    constructor(codeword: Array<Int>) : this(codeword.size) {
        for (i in codeword.indices) {
            this.set(i, codeword[i] == 1)
        }
    }

    constructor(value: Int, codeLength: Int) : this(BigInteger.valueOf(value.toLong()), codeLength)
    constructor(value: Long, codeLength: Int) : this(BigInteger.valueOf(value), codeLength)

    constructor(value: BigInteger, codeLength: Int) : this(codeLength) {
        for (j in 0 until codeLength + 1) {
            if ((value and (BigInteger.valueOf(1).shl(j))) != BigInteger.ZERO) {
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

    operator fun plus(other: BinaryVector): BinaryVector {
        val tmp = this
        tmp.or(other)
        return tmp
    }

}