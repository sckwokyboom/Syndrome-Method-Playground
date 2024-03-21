import java.util.stream.Stream

interface Code {
    fun getAllCodewords(): Stream<Codeword>
}