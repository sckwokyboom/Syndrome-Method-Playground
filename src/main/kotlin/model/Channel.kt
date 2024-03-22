package model

import java.util.*

// TODO: add tests
class Channel(private val probabilityOfError: Double, private val lengthOfCodewords: Int) {
    // TODO: add check invariants
    private val random = Random()
    private var info: BinaryVector = BinaryVector(lengthOfCodewords)

    fun sendInfo(info: BinaryVector) {
        this.info = info.clone() as BinaryVector
        for (i in 0 until info.size()) {
            if (random.nextDouble() < probabilityOfError) {
                this.info.flip(i)
            }
        }
    }

    fun receiveInfo(): BinaryVector {
        return info
    }
}