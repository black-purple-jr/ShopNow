import java.io.File

fun main() {
    var laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
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
    val cl2 = Client(3, "Abdellah", "Casablanca")
    val cl3 = Client(4, "Safaa", "Tanger")


    val prod1 = ProduitElectronique("E2", "IPad", 7000.0, 12, 12)
    val prod2 = ProduitElectronique("E3", "IMac", 15000.0, 6, 12)
    val prod3 = ProduitAlimentaire("A2", "The", 20.0, 16, "2027-01-01")


    val cmd1 = Commande(1, "2026-10-01", sara, prod1, 2)
    val cmd2 = Commande(2, "2026-10-02", cl2, prod2, 50)
    val cmd3 = Commande(3, "2026-10-03", cl3, prod3, 10)
    val cmd4 = Commande(4, "2026-10-04", sara, prod2, 4)
    val cmd5 = Commande(5, "2026-10-05", cl2, prod1, 3)
    val cmd6 = Commande(6, "2026-10-06", cl3, prod3, 5)

    val c = Commande(101, "2026-10-10", sara, laptop, 2)

    println(c.statut)
    c.payer()
    println(c.statut)
    println(c.statut == StatutDeCommande.PAID)
    println(StatutDeCommande.values().size)

    fun ecrireHistorique(client: Client, commandes: Collection<Commande>) {
        File("src/main/data/Client${client.id}.txt").writeText(commandes.joinToString("\n"))
    }

    ecrireHistorique(sara, listOf(cmd1, cmd4))

    laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val r: Remisable = laptop
    r.appliquerRemise(20.0)
    println(laptop.prixHT)

    val phone = ProduitElectronique("E2", "Phone", 2000.0, 20, 12)

    val boutique = Boutique()
    println(boutique.ajouter(laptop))
    println(boutique.ajouter(laptop))
    println(boutique.ajouter(riz))
    println(boutique.ajouter(phone))
    println(boutique.indiceProduit("A1"))
    println(boutique.indiceProduit("ZZ"))
    println(boutique.nombreProduitsElectroniques())
    println(boutique.supprimer("A1"))
    println(boutique.supprimer("A1"))
    println(boutique.supprimer(laptop))
    println(boutique.nombreProduitsElectroniques())
    println(boutique.indiceProduit("E2"))

    fun jeuDeDonnee(): List<Commande> {
        val amine = Client(1, "Amine", "Safi")
        val sara = Client(2, "Sara", "Marrakech")
        val hicham = Client(3, "Hicham", "Rabat")
        val rania = Client(4, "Rania", "Agadir")

        val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 100, 24)
        val phone = ProduitElectronique("E2", "Phone", 2000.0, 100, 12)
        val riz = ProduitAlimentaire("A1", "Riz", 20.0, 1000, "2027-01-01")
        val lait = ProduitAlimentaire("A2", "Lait", 10.0, 500, "2026-12-01")

        val c1 = Commande(1, "2026-10-01", amine, laptop, 1);  c1.payer()
        val c2 = Commande(2, "2026-10-02", sara, phone, 1);    c2.payer()
        val c3 = Commande(3, "2026-10-03", amine, riz, 10);    c3.payer()
        val c4 = Commande(4, "2026-10-04", hicham, laptop, 2); c4.payer(); c4.annuler()
        val c5 = Commande(5, "2026-10-05", sara, lait, 20)
        val c6 = Commande(6, "2026-10-06", rania, phone, 3);   c6.payer()
        val c7 = Commande(7, "2026-10-07", amine, lait, 10);   c7.annuler()
        val c8 = Commande(8, "2026-10-08", hicham, riz, 100);  c8.payer()

        return listOf(c1, c2, c3, c4, c5, c6, c7, c8)
    }

    println(jeuDeDonnee())


}