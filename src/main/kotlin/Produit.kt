abstract class Produit (
    val code: String,
    var nom: String,
    var prixHT: Double,
    var stock: Int
) {
    abstract fun prixTTC(): Double

    fun retirerStock(quantite : Int): Boolean {
        if (this.stock >= quantite) {
            stock -= quantite
            return true
        } else {
            return false
        }
    }
}