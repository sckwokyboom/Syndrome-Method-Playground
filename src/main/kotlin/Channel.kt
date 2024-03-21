package ru.nsu.fit.sckwo

import Codeword
import java.util.*

// TODO: add tests
class Channel(private val probabilityOfError: Double, private val lengthOfCodewords: Int) {
    // TODO: add check invariants
    private val random = Random()
    private var info: Codeword = Codeword(lengthOfCodewords)

    fun sendInfo(info: Codeword) {
        for (i in 0 until info.size()) {
            if (random.nextDouble() < probabilityOfError) {
                info.flip(i)
            }
        }
        this.info = info
    }

    fun receiveInfo(): Codeword {
        return info
    }
}