import java.math.BigInteger
import kotlin.math.pow

fun allBinaryVectorPermutations(weight: Int, vectorLength: Int): Sequence<BigInteger> {
    if (weight > vectorLength) {
        throw IllegalArgumentException("Вес не может быть больше длины вектора.")
    }
    val permutations = ArrayList<BigInteger>()
    val binaryLimit = BigInteger.valueOf(2.0.pow(vectorLength).toLong())
    val initVector = BigInteger.valueOf((2.0.pow(weight) - 1).toLong())
    var vectorPerm = initVector
    while (vectorPerm < binaryLimit) {
        permutations.add(vectorPerm)
        val t = (vectorPerm or (vectorPerm - BigInteger.ONE)) + BigInteger.ONE
        val nextVectorPerm = t or ((((t and -t) / (vectorPerm and -vectorPerm)) shr 1) - BigInteger.ONE)
        if (nextVectorPerm < binaryLimit) {
            vectorPerm = nextVectorPerm
        } else {
            break
        }
    }
    return permutations.asSequence()
}