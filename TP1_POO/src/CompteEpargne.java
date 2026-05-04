// 2. Classe dérivée CompteEpargne qui hérite de CompteBancaire
// Implementation du concept d'héritage avec le mot-clé extends
public class CompteEpargne extends CompteBancaire {
    
    // Constructeur utilisant super() pour appeler le constructeur de la classe parent
    public CompteEpargne(String numeroCompte, double soldeInitial) {
        super(numeroCompte, soldeInitial);
    }
    
    // Méthode pour calculer et ajouter des intérêts au solde selon un taux donné
    public void calculerInterets(double taux) {
        if (taux > 0) {
            double interets = getSolde() * (taux / 100);
            deposer(interets); // Utilise la méthode deposer() de la classe parent
            System.out.println("Intérêts de " + interets + "€ calculés et ajoutés au compte " + getNumeroCompte());
        } else {
            System.out.println("Erreur: Le taux d'intérêt doit être positif.");
        }
    }
}
