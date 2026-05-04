// 4. Classe principale avec polymorphisme
// Démonstration du polymorphisme dans la méthode main()
public class Zoo {
    public static void main(String[] args) {
        // Création d'objets avec polymorphisme
        // Variable de type Animal référençant des objets de sous-classes
        Animal tigre = new Mammifere("Tigre");
        Animal perroquet = new Oiseau("Perroquet");
        
        // Appel polymorphique des méthodes
        tigre.faireDuBruit();     // Sortie attendue : "Tigre grogne."
        perroquet.faireDuBruit(); // Sortie attendue : "Perroquet chante."
        
        // Polymorphisme : la méthode faireDuBruit() se comporte différemment
        // selon l'instance d'Animal (tigre ou perroquet)
        
        // Modification demandée dans l'exercice : utiliser perroquet comme Oiseau
        // pour accéder à la méthode voler()
        Oiseau perroquetOiseau = new Oiseau("Perroquet");
        perroquetOiseau.faireDuBruit(); // "Perroquet chante."
        perroquetOiseau.voler();        // "L'oiseau vole."
    }
}
