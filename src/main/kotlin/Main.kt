import model.BinaryVector
import model.Channel
import model.SyndromeTable
import model.code.HammingCode
import model.code.RandomCode


fun main() {
////    println(converter.toParityCheck("[[0,0,1],[0,1,0],[0,1,1],[1,0,0],[1,0,1],[1,1,0],[1,1,1]]"))
    val randomCode = RandomCode(500)
    println(randomCode.parityCheckMatrix)
//    val hammingCode = HammingCode(4)
//    println(hammingCode.parityCheckMatrix)
//    val chan = Channel(0.01, hammingCode.length)
//
//    val info = BinaryVector(5, 10)
//    val syndromeTable = SyndromeTable(hammingCode)
//    val decoder = Decoder(hammingCode)
//    var countOfCorrectlyDecodedVectors = 0
//    var countOfIncorrectlyDecodedVectors = 0
//    for (vector in hammingCode.getAllCodewords()) {
//        chan.sendInfo(vector)
//        val receivedVector = chan.receiveInfo()
//        val decodedVector = decoder.decode(receivedVector)
//        if (decodedVector == vector) {
//            countOfCorrectlyDecodedVectors++
//        } else {
//            countOfIncorrectlyDecodedVectors++
//        }
//        println(
//            "Real vector: $vector; " +
//                    "Received vector: $receivedVector; " +
//                    "Decoded vector: $decodedVector"
//        )
//    }
//    println("Correct: $countOfCorrectlyDecodedVectors; Incorrect: $countOfIncorrectlyDecodedVectors;")
//    println("Probability of correct decoding: ${countOfIncorrectlyDecodedVectors.toDouble() / (countOfIncorrectlyDecodedVectors + countOfCorrectlyDecodedVectors)}")
}