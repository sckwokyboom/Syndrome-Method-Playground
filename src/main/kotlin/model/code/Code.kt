package model.code

import canonicalconverter.Matrix
import model.BinaryVector
import java.util.stream.Stream

abstract class Code {
    abstract val parityCheckLength: Int
    abstract val length: Int
    abstract val generatorMatrix: Matrix
    abstract val parityCheckMatrix: Matrix
    abstract fun getAllCodewords(): Stream<BinaryVector>
}