// 1. Classe de base CompteBancaire
// Implementation du concept d'encapsulation avec des attributs privés
public class CompteBancaire {
    // Attributs privés pour l'encapsulation
    private String numeroCompte;
    private double solde;
    
    // Constructeur pour initialiser les attributs
    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
    }
    
    // Getter pour accéder à l'attribut privé numeroCompte
    public String getNumeroCompte() {
        return numeroCompte;
    }
    
    // Getter pour accéder à l'attribut privé solde
    public double getSolde() {
        return solde;
    }
    
    // Setter pour modifier l'attribut privé numeroCompte
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    
    // Méthode pour déposer de l'argent sur le compte
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + "€ effectué. Nouveau solde: " + solde + "€");
        } else {
            System.out.println("Erreur: Le montant à déposer doit être positif.");
        }
    }
    
    // Méthode pour retirer de l'argent du compte avec vérification du solde
    public void retirer(double montant) {
        if (montant > 0) {
            if (solde >= montant) {
                solde -= montant;
                System.out.println("Retrait de " + montant + "€ effectué. Nouveau solde: " + solde + "€");
            } else {
                System.out.println("Erreur: Solde insuffisant pour retirer " + montant + "€. Solde actuel: " + solde + "€");
            }
        } else {
            System.out.println("Erreur: Le montant à retirer doit être positif.");
        }
    }
}
