// 2. Classe Voiture qui hérite de Véhicule
// Implementation du concept d'héritage avec le mot-clé extends
class Voiture extends Vehicule {
    // Attribut privé pour l'encapsulation
    private int nombreDePortes;
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public Voiture(String marque, String modele, int annee, int nombreDePortes) {
        super(marque, modele, annee);
        this.nombreDePortes = nombreDePortes;
    }
    
    // Getter pour accéder à l'attribut privé
    public int getNombreDePortes() {
        return nombreDePortes;
    }
    
    // Setter pour modifier l'attribut privé
    public void setNombreDePortes(int nombreDePortes) {
        this.nombreDePortes = nombreDePortes;
    }
    
    // Redéfinition de la méthode abstraite afficherDetails()
    // Utilisation de l'annotation @Override pour indiquer la redéfinition
    @Override
    public void afficherDetails() {
        // Appel de la méthode concrète demarrer() comme demandé dans l'exercice
        demarrer();
        System.out.println("Voiture: " + getMarque() + " " + getModele() + " (" + getAnnee() + "), Portes: " + nombreDePortes);
    }
}
