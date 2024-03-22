import model.BinaryVector
import model.SyndromeTable
import model.code.Code

class Decoder(private val code: Code) {
    private val syndromeTable = SyndromeTable(code)
    fun decode(vector: BinaryVector): BinaryVector {
        println(vector)
        //TODO(check codeword in code)
        val syndrome = code.parityCheckMatrix * vector
        println("Syndrome: $syndrome;")
        val errorVector = syndromeTable.getLeader(syndrome)
        println("Error: $errorVector;")
        return vector + errorVector
    }
}