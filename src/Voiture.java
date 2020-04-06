import java.util.Objects;

public class Voiture {
    private String immat, modele;

    /**
     * contructeur de la voiture
     * @param immat
     * @param modele
     */
    public Voiture(String immat, String modele) {
        this.immat = immat.toUpperCase(); // les immat sont passées en majuscules pour les comparer
        this.modele = modele;
    }

    public String getModele() {
        return modele;
    }

    public String getImmat() {
        return immat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return Objects.equals(immat, voiture.immat);
    }

}
