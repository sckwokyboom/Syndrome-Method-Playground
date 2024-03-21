package model.code

import model.BinaryVector
import java.util.stream.Stream

interface Code {
    fun getAllCodewords(): Stream<BinaryVector>
}