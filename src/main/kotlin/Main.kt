import model.BinaryVector
import model.Channel
import model.SyndromeTable
import model.code.HammingCode


fun main() {
    val chan = Channel(0.0, 5)
    chan.sendInfo(BinaryVector(6))
////    println(converter.toParityCheck("[[0,0,1],[0,1,0],[0,1,1],[1,0,0],[1,0,1],[1,1,0],[1,1,1]]"))
    val hammingCode = HammingCode(6)
    println(hammingCode.parityCheckMatrix)

    val syndromeTable = SyndromeTable(hammingCode.codeLength, hammingCode.parityLength)
    println(syndromeTable.getTable(hammingCode.parityCheckMatrix))
}