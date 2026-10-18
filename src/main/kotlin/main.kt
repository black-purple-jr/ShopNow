fun main() {
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")
    println(laptop.prixTTC())
    println(riz.prixTTC())

    val catalogue: List<Produit> = listOf(laptop, riz)
    for (p in catalogue) {
        println("${p.nom} : ${p.prixTTC()}")
    }

}