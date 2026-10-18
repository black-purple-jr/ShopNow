abstract class Produit (
    val code: String,
    var nom: String,
    var prixHT: Double,
    var stock: Int
) {
    abstract fun prixTTC(): Double
}