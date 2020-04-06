import java.util.Objects;

public class Voiture {
    private String immat, modele;

    public Voiture(String immat, String modele) {
        this.immat = immat.toUpperCase();
        this.modele = modele;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return Objects.equals(immat, voiture.immat);
    }

}
