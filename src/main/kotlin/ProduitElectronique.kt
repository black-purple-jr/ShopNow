class ProduitElectronique(
    code: String,
    nom: String,
    prixHt: Double,
    stock: Int,
    var dureeDeGaranti: Int

) : Produit(code, nom, prixHt, stock) {

    override fun prixTTC(): Double {
        val tva: Double = 20.0
        val ttc: Double = this.prixHT * (1 + tva)

        return ttc
    }
}
