class ProduitElectronique(
    var dureeDeGaranti: String,
    code: Int,
    nom: String,
    prixHt: Double,
    stock: Int
): Produit(code, nom, prixHt, stock) {}


class ProduitAlimentaire(
    var dateLimiteDeConsomation: String,
    code: Int,
    nom: String,
    prixHt: Double,
    stock: Int
): Produit(code, nom, prixHt, stock) {}
