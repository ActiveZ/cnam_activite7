public class Launch {

    public static void main(String[] args) {

        try {
            //création d'un garage à 3 places
            Garage garage = new Garage(3);

            //création de 4 voitures
            Voiture voiture1 = new Voiture("aa-111-aa", "Citroën");
            Voiture voiture2 = new Voiture("bb-222-bb", "Renault");
            Voiture voiture3 = new Voiture("cc-333-cc", "Ford");
            Voiture voiture4 = new Voiture("dd-444-dd", "BMW");

            // affichage de l'état du garage vide
            System.out.println(garage.toString());

            garage.garer(voiture1, 0);
            garage.garer(voiture2, 1);
            garage.garer(voiture3, 2);

            //affichage de l'état du garage plein
            System.out.println(garage.toString());

            System.out.println("La voiture immatriculée AA-111-AA est garée à la place " + garage.place("aa-111-aa"));

            //conflit: garer une voiture à un emplacement occupé
            garage.garer(voiture4, 2); // mettre en commentaire pour poursuivre programme

            //libération place 2
            garage.recuperer(2);
            //garer voiture4 place 2
            garage.garer(voiture4, 2);
            //Récupération voiture1 (place 1)
            garage.recuperer("bb-222-bb");

            //affichage état garage final
            System.out.println(garage.toString());

        } catch (GarageException e) {
            System.out.println("\nPANIQUE DANS LE GARAGE !!!");
            e.printStackTrace();
        }
    }
}
