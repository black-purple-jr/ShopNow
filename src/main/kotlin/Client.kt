data class Client (
    val id: Int,
    var nom: String,
    var ville: String
) {
    override fun toString(): String {
        return nom
    }
}