import java.util.Arrays;

public class Garage {

    private int nbPlace; // nb place du garage
    private Voiture[] place; //la place est soit libre (null), soit occupée par une voiture

    public Garage(int nbPlace) {
        this.nbPlace = nbPlace;
        this.place = new Voiture[nbPlace];
    }

    public void garer (Voiture voiture, int numPlace) {
        if (place[numPlace]==null) {place[numPlace] = voiture;}
        else // erreur
    }

    public Voiture recuperer (int numPlace) {
        Voiture voiture = place[numPlace];
        place[numPlace] = null;
        return voiture;
    }

    public Voiture recuperer (String immat) {
        immat = immat.toUpperCase();
        int i = 0;
        while (i < nbPlace) {
            if (place[i].getImmat() == immat) {
                Voiture voiture = place[i];
                place[i] = null;
                return voiture;
            }
        }
        // erreur
        return null;
    }

    public int place (String immat) {
        int i = 0;
        while (i < place.length) {
            if (place[i].getImmat() == immat) {return i;}
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "nbPlace=" + nbPlace +
                ", place=" + Arrays.toString(place) +
                '}';
    }
}
