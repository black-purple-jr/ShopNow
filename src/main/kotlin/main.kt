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

}