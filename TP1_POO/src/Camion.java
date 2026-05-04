// 3. Classe Camion qui hérite de Véhicule
// Implementation du concept d'héritage avec le mot-clé extends
class Camion extends Vehicule {
    // Attribut privé pour l'encapsulation
    private double capaciteDeCharge;
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public Camion(String marque, String modele, int annee, double capaciteDeCharge) {
        super(marque, modele, annee);
        this.capaciteDeCharge = capaciteDeCharge;
    }
    
    // Getter pour accéder à l'attribut privé
    public double getCapaciteDeCharge() {
        return capaciteDeCharge;
    }
    
    // Setter pour modifier l'attribut privé
    public void setCapaciteDeCharge(double capaciteDeCharge) {
        this.capaciteDeCharge = capaciteDeCharge;
    }
    
    // Redéfinition de la méthode abstraite afficherDetails()
    // Utilisation de l'annotation @Override pour indiquer la redéfinition
    @Override
    public void afficherDetails() {
        // Appel de la méthode concrète demarrer() comme demandé dans l'exercice
        demarrer();
        System.out.println("Camion: " + getMarque() + " " + getModele() + " (" + getAnnee() + "), Capacité: " + capaciteDeCharge + " tonnes");
    }
}
