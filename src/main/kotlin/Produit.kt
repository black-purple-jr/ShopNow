abstract class Produit (
    val code: String,
    var nom: String,
    var prixHT: Double,
    stock: Int
) {
    var stock = stock
        private set

    abstract fun prixTTC(): Double

    fun retirerStock(quantite : Int): Boolean {
        if (stock < quantite) {
            return false
        } else {
            stock -= quantite
            return true
        }
    }

    fun ajouterStock(quantite : Int) {
        if (quantite >= 0) {
            stock += quantite
        }
    }
}