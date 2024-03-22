import model.BinaryVector
import model.Channel
import model.SyndromeTable
import model.code.HammingCode


fun main() {
////    println(converter.toParityCheck("[[0,0,1],[0,1,0],[0,1,1],[1,0,0],[1,0,1],[1,1,0],[1,1,1]]"))
    val hammingCode = HammingCode(3)
    println(hammingCode.parityCheckMatrix)
    val chan = Channel(0.2, hammingCode.length)

    val info = BinaryVector(5, 10)
    val syndromeTable = SyndromeTable(hammingCode)
    val decoder = Decoder(hammingCode)
    for (vector in hammingCode.getAllCodewords()) {
        chan.sendInfo(vector)
        val receivedVector = chan.receiveInfo()
        val decodedVector = decoder.decode(receivedVector)
        println("Real vector: $vector; " +
                "Received vector: $receivedVector; " +
                "Decoded vector: $decodedVector")

    }
}