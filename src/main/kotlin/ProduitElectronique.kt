class ProduitElectronique(
    code: String,
    nom: String,
    prixHt: Double,
    stock: Int,
    var dureeDeGaranti: Int

) : Produit(code, nom, prixHt, stock) {

    override fun prixTTC(): Double {
        val tva: Double = 20.0
        val ttc: Double = this.prixHT * (1 + tva / 100)

        return ttc
    }

    fun appliquerRemise(pourcentage: Double) {
        var prix: Double = 1.0
        var remise: Double = prix * pourcentage / 100
        this.prixHT = prix - remise
    }
}
