class ProduitElectronique(
    code: String,
    nom: String,
    prixHt: Double,
    stock: Int,
    var dureeDeGaranti: Int

) : Produit(code, nom, prixHt, stock), Remisable {


    override fun prixTTC(): Double {
        val tva: Double = 20.0
        return prixHT * (1 + tva / 100)
    }

    override fun appliquerRemise(pourcentage: Double) {
        if (pourcentage in 0.0..100.0){
            prixHT -= prixHT * pourcentage / 100.0
        }
    }

    override fun toString(): String {
        return nom
    }
}
