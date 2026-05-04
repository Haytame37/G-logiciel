// 4. Classe principale
// Démonstration du polymorphisme dans la méthode main()
public class GestionTransport {
    public static void main(String[] args) {
        // Création d'objets avec polymorphisme
        // Variable de type Vehicule référençant des objets de sous-classes
        Vehicule maVoiture = new Voiture("Toyota", "Corolla", 2021, 4);
        Vehicule monCamion = new Camion("Volvo", "FMX", 2019, 12.5);
        Vehicule maMoto = new Moto("Yamaha", "MT-07", 2022, "Sport");
        
        // Appel polymorphique des méthodes
        maVoiture.afficherDetails(); // Affiche "Le véhicule démarre." puis "Voiture: Toyota Corolla (2021), Portes: 4"
        monCamion.afficherDetails(); // Affiche "Le véhicule démarre." puis "Camion: Volvo FMX (2019), Capacité: 12.5 tonnes"
        maMoto.afficherDetails();    // Affiche "Le véhicule démarre." puis "Moto: Yamaha MT-07 (2022), Guidon: Sport"
        
        // Polymorphisme : la méthode afficherDetails() se comporte différemment
        // selon l'instance de Vehicule (Voiture, Camion ou Moto)
    }
}
