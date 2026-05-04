// 1. Classe abstraite Véhicule
// Implementation du concept d'encapsulation avec des attributs privés
abstract class Vehicule {
    // Attributs privés pour l'encapsulation
    private String marque;
    private String modele;
    private int annee;
    
    // Constructeur pour initialiser les attributs
    public Vehicule(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }
    
    // Getters pour accéder aux attributs privés
    public String getMarque() {
        return marque;
    }
    
    public String getModele() {
        return modele;
    }
    
    public int getAnnee() {
        return annee;
    }
    
    // Setters pour modifier les attributs privés
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public void setModele(String modele) {
        this.modele = modele;
    }
    
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    // Méthode concrète ajoutée dans l'exercice
    public void demarrer() {
        System.out.println("Le véhicule démarre.");
    }
    
    // Méthode abstraite à implémenter dans les sous-classes
    // Demonstration du concept d'abstraction
    public abstract void afficherDetails();
}
