public class Garage {

    private int nbPlace; // nb place du garage
    private Voiture[] place; //la place est soit libre (null), soit occupée par une voiture;

    /**
     * constructeur du garage
     * @param nbPlace
     * @throws GarageException
     */
    public Garage(int nbPlace) throws GarageException {
        if (nbPlace < 1) {throw new GarageException("ERREUR: le garage doit contenir au moins une place !");}
        this.nbPlace = nbPlace;
        this.place = new Voiture[nbPlace];
    }

    /**
     * Gare une voiture au numéro de place indiqué
     * @param voiture
     * @param numPlace
     * @throws GarageException
     */
    public void garer (Voiture voiture, int numPlace) throws GarageException {
        if (place[numPlace] != null) {throw new GarageException("ERREUR: cette place est déjà occupée !") ;}
        place[numPlace] = voiture;
    }

    /**
     * Récupère la voiture garée au numéro de place indiqué
     * @param numPlace
     * @return
     * @throws GarageException
     */
    public Voiture recuperer (int numPlace) throws GarageException {
        if (place[numPlace] == null) {throw new GarageException("ERREUR: cette place est inocupée !");}
        Voiture voiture = place[numPlace];
        place[numPlace] = null;
        return voiture;

    }

    /**
     * Récupère la voiture avec l'immatriculation indiquée
     * @param immat
     * @return
     * @throws GarageException
     */
    public Voiture recuperer (String immat) throws GarageException {
        immat = immat.toUpperCase();
        int i = 0;
        while (i < nbPlace) {
            if (place[i].getImmat().equals(immat)) {
                Voiture voiture = place[i];
                place[i] = null;
                return voiture;
            }
            i++;
        }
        throw new GarageException("ERREUR: cette immatriculation n'est pas dans le garage !");
    }

    /**
     * Retourne le numéro de place de la voiture
     * @param immat
     * @return
     */
    public int place (String immat) {
        immat= immat.toUpperCase();
        int i = 0;
        while (i < place.length) {
            if (place[i].getImmat().equals(immat)) {return i;}
            i++;
        }
        return -1;
    }

    /**
     * Affichage de l'état du garage
     * @return
     */
    @Override
    public String toString() {
        String str = "Le garage a " + nbPlace + " places.\nLes voitures garées sont:\n";
        int i = 0;
        while (i < nbPlace) {
            if (place[i] != null) {
                Voiture voiture = place[i];
                str += "Place " + i + ": voiture " + voiture.getModele() + " immatriculée: " + voiture.getImmat() + "\n";
            }
            i++;
        }
        return str;
    }

    /**
     * retourne vrai si la place numPlace est libre
     * @param numPlace
     * @return
     */
    public boolean isLibre(int numPlace) {
        return place[numPlace] == null;
    }
}
