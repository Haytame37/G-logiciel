// 1. Classe abstraite Animal
// Implementation du concept d'encapsulation avec des attributs privés
abstract class Animal {
    // Attribut privé pour l'encapsulation
    private String nom;
    
    // Constructeur pour initialiser l'attribut nom
    public Animal(String nom) {
        this.nom = nom;
    }
    
    // Getter pour accéder à l'attribut privé nom
    public String getNom() {
        return nom;
    }
    
    // Setter pour modifier l'attribut privé nom
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // Méthode abstraite à implémenter dans les sous-classes
    // Demonstration du concept d'abstraction
    public abstract void faireDuBruit();
}
