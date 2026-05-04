// 6. Classe Moto qui hérite de Véhicule
// Nouvelle classe créée selon les instructions de l'exercice
class Moto extends Vehicule {
    // Attribut privé pour l'encapsulation
    private String typeDeGuidon;
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public Moto(String marque, String modele, int annee, String typeDeGuidon) {
        super(marque, modele, annee);
        this.typeDeGuidon = typeDeGuidon;
    }
    
    // Getter pour accéder à l'attribut privé
    public String getTypeDeGuidon() {
        return typeDeGuidon;
    }
    
    // Setter pour modifier l'attribut privé
    public void setTypeDeGuidon(String typeDeGuidon) {
        this.typeDeGuidon = typeDeGuidon;
    }
    
    // Redéfinition de la méthode abstraite afficherDetails()
    // Utilisation de l'annotation @Override pour indiquer la redéfinition
    @Override
    public void afficherDetails() {
        // Appel de la méthode concrète demarrer() comme demandé dans l'exercice
        demarrer();
        System.out.println("Moto: " + getMarque() + " " + getModele() + " (" + getAnnee() + "), Guidon: " + typeDeGuidon);
    }
}
