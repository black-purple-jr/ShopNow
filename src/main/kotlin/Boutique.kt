class Boutique {

    private val produits: MutableList<Produit> = mutableListOf()

    fun indiceProduit(code: String): Int {
        for ((index, p) in produits.withIndex()) {
            if (p.code == code) {
                return index
            }
        }
        return 0
    }

    fun ajouter(p: Produit): Boolean {
        if (p !in produits) {
            produits.add(p)
            return true
        } else {
            return false
        }
    }

    fun supprimer(code : String): Boolean {
        for (p in produits) {
            if (p.code == code) {
                produits.remove(p)
                return true
            }
        }
        return false
    }

    fun supprimer(p : Produit): Boolean{
        if (p in produits) {
            produits.remove(p)
            return true
        } else {
            return false
        }
    }

    fun nombreProduitsElectroniques(): Int{
        var total = 0
        for (p in produits) {
            if (p is ProduitElectronique) {
                total++
            }
        }

        return total
    }



}