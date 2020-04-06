public class Launch {

    public static void main(String[] args) {

        //création d'un grarage à 3 places
        Garage garage = new Garage(3);

        //création de 4 voitures
        Voiture voiture1 = new Voiture("aa-111-aa", "Citroën");
        Voiture voiture2 = new Voiture("bb-222-bb", "Renault");
        Voiture voiture3 = new Voiture("cc-333-cc", "Ford");
        Voiture voiture4 = new Voiture("dd-444-dd","BMW");

        garage.toString();

        garage.garer(voiture1,0);
        garage.garer(voiture2,1);
        garage.garer(voiture3,2);

        garage.toString();

        garage.place("aa-111-aa");
        garage.garer(voiture4,3);
        garage.recuperer(2);
        garage.garer(voiture4,2);
        garage.recuperer("bb-222bbb");

        garage.toString();


    }
}
