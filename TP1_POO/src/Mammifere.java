// 2. Classe Mammifere héritant d'Animal
// Implementation du concept d'héritage avec le mot-clé extends
class Mammifere extends Animal {
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public Mammifere(String nom) {
        super(nom);
    }
    
    // Redéfinition de la méthode abstraite faireDuBruit()
    // Utilisation de l'annotation @Override pour indiquer la redéfinition
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " grogne.");
    }
}
