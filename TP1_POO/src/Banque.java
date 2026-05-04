// 3. Classe principale Banque
// Test des fonctionnalités des comptes bancaires
public class Banque {
    public static void main(String[] args) {
        // Création d'objets de type CompteCourant et CompteEpargne
        CompteCourant compteCourant1 = new CompteCourant("CC001", 1000.0);
        CompteEpargne compteEpargne1 = new CompteEpargne("CE001", 5000.0);
        
        // Test des fonctionnalités du compte courant
        System.out.println("=== Test Compte Courant ===");
        compteCourant1.afficherTypeCompte();
        compteCourant1.deposer(500.0);
        compteCourant1.retirer(200.0);
        compteCourant1.retirer(2000.0); // Test de retrait avec solde insuffisant
        
        // Test des fonctionnalités du compte épargne
        System.out.println("\n=== Test Compte Épargne ===");
        System.out.println("Compte épargne n°" + compteEpargne1.getNumeroCompte() + " avec solde: " + compteEpargne1.getSolde() + "€");
        compteEpargne1.deposer(1000.0);
        compteEpargne1.calculerInterets(2.5); // Calcul des intérêts à 2.5%
        compteEpargne1.retirer(500.0);
        
        // Test de validation des montants
        System.out.println("\n=== Test Validation ===");
        compteCourant1.deposer(-100.0); // Test dépôt négatif
        compteEpargne1.retirer(-50.0);  // Test retrait négatif
        compteEpargne1.calculerInterets(-1.0); // Test taux négatif
    }
}
