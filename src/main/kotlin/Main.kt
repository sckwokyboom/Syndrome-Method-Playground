import ru.nsu.fit.sckwo.Channel


fun main() {
    val chan = Channel(0.0, 5)
    chan.sendInfo(Codeword(5))
////    println(converter.toParityCheck("[[0,0,1],[0,1,0],[0,1,1],[1,0,0],[1,0,1],[1,1,0],[1,1,1]]"))
    val hammingCode = HammingCode(3)
    println(hammingCode.parityCheckMatrix)

    val syndromeTable = SyndromeTable(hammingCode.codeLength, hammingCode.parityLength)
    print(syndromeTable.getTable(hammingCode.parityCheckMatrix))
}