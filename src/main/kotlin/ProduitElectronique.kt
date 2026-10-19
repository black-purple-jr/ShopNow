class ProduitElectronique(
    code: String,
    nom: String,
    prixHt: Double,
    stock: Int,
    var dureeDeGaranti: Int

) : Produit(code, nom, prixHt, stock) {


    override fun prixTTC(): Double {
        val tva: Double = 20.0
        return prixHT * (1 + tva / 100)
    }

    fun appliquerRemise(pourcentage: Double) {
        if (pourcentage > 100.0 || pourcentage < 0.0) {
            prixHT -= prixHT * pourcentage / 100.0
        }
    }
}
