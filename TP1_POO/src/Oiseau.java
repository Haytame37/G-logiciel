// 3. Classe Oiseau héritant d'Animal
// Implementation du concept d'héritage avec le mot-clé extends
class Oiseau extends Animal {
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public Oiseau(String nom) {
        super(nom);
    }
    
    // Redéfinition de la méthode abstraite faireDuBruit()
    // Utilisation de l'annotation @Override pour indiquer la redéfinition
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " chante.");
    }
    
    // Méthode spécifique aux oiseaux pour démontrer un comportement unique
    // Complétion de la méthode demandée dans l'exercice
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}
