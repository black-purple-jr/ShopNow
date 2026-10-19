fun main() {
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")

    println(laptop.prixTTC()) // attendu : 6000.0
    println(riz.prixTTC()) // attendu : 22.0

    // Polymorphisme : une liste de Produit contenant des types différents
    val catalogue: List<Produit> = listOf(laptop, riz)
    for (p in catalogue) {
        println("${p.nom} : ${p.prixTTC()}")
    }

    // attendu :
    // Laptop : 6000.0
    // Riz : 22.0

    laptop.appliquerRemise(10.0)
    println(laptop.prixHT)
    println(laptop.prixTTC())

    println(laptop.retirerStock(3))
    println(laptop.stock)
    laptop.ajouterStock(3)
    println(laptop.stock)
    println(laptop.retirerStock(50))


    val sara = Client(2, "Sara", "Marrakech")
    println(sara)

    val c1 = Commande(101, "2026-10-10", sara, laptop, 2)

    println(c1.statut)
    println(c1.montantTotal())
    println(c1.payer())
    println(c1.statut)
    println(laptop.stock)
    println(c1.payer())
    println(c1.expedier())
    println(c1.statut)
    println(c1.annuler())
    println(c1.statut)

    val c3 = Commande(103, "2026-10-12", sara, laptop, 3)
    println(c3.payer())
    println(laptop.stock)
    println(c3.annuler())
    println(laptop.stock)
    println(c3.statut)

    val c4 = Commande(104, "2026-10-13", sara, laptop, 1)
    println(c4.annuler())
    println(laptop.stock)

    // jalon 4 sans aide

    val cl1 = Client(2, "Hassan", "Rabat")

}