class ProduitAlimentaire(
    code: String,
    nom: String,
    prixHt: Double,
    stock: Int,
    var dateLimiteDeConsomation: String

) : Produit(code, nom, prixHt, stock) {

    override fun prixTTC(): Double {
        val tva: Double = 10.0
        val ttc: Double = prixHT * (1 + tva / 100)

        return ttc
    }

    override fun toString(): String {
        return nom
    }
}