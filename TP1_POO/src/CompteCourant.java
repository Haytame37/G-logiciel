// Classe CompteCourant qui hérite de CompteBancaire
// Complément pour l'exercice 1.3
public class CompteCourant extends CompteBancaire {
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public CompteCourant(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }
    
    // Méthode spécifique aux comptes courants
    public void afficherTypeCompte() {
        System.out.println("Compte courant n°" + getNumeroCompte() + " avec solde: " + getSolde() + "€");
    }
}
