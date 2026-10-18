class Commande (
    val numero: Int,
    var date: String,
    var client: Client,
    var produit: Produit,
    var quantiteComander: Int,
    var statut: StatutDeCommande
) {
}