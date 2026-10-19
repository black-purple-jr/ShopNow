class Commande (
    val numero: Int,
    var date: String,
    var client: Client,
    var produit: Produit,
    var quantiteComander: Int,
    statut: StatutDeCommande = StatutDeCommande.CREATED
) {
    var statut: StatutDeCommande = statut
        private set

    fun montantTotal (): Double {
        var total = 0.0
        total = produit.prixTTC() * quantiteComander

        return total
    }

    fun payer (): Boolean {
        if (produit.retirerStock(quantiteComander) && statut == StatutDeCommande.CREATED) {
            statut = StatutDeCommande.PAID
            return true
        }
        return false
    }

    fun expedier(): Boolean {
        if (statut == StatutDeCommande.PAID) {
            statut = StatutDeCommande.SHIPPED
            return true
        }
        return false
    }

    fun annuler (): Boolean {
        if (statut != StatutDeCommande.SHIPPED) {
            statut = StatutDeCommande.CANCELLED
            produit.ajouterStock(quantiteComander)
            return true
        }
        return false
    }
}