import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GarageTest {
    Garage gTest;
    Voiture v0, v1, v2;

    @BeforeEach
    void setUp() throws GarageException {
        gTest = new Garage(1);
        v1 = new Voiture("aa-111-aa", "Ford");
        v2 = new Voiture("bb-222-bb", "Ford");
    }

    ///////////////// TESTS DES EXCEPTIONS ////////////////////

    @Test
    void test_Erreur_Quand_Se_Gare_Sur_Place_Occupee() {
        try {
            gTest.garer(v1, 0);
            gTest.garer(v2, 0);
        } catch (GarageException e) {
            assert (e.getMessage().contains("ERREUR: la place 0 est déjà occupée !"));
        }
    }

    @Test
    void test_Erreur_Quand_Recuperation_Voiture_Sur_Place_Vide() {
        try {
            gTest.recuperer(0);
        } catch (GarageException e) {
            assert (e.getMessage().contains("ERREUR: la place 0 est inocupée !"));
        }
    }

    @Test
    void test_Erreur_Quand_Recuperation_Voiture_Inexistante_Au_Garage() {
        try {
            gTest.recuperer("aa-111-aa");
        } catch (GarageException e) {
            assert (e.getMessage().contains("ERREUR: immatriculation AA-111-AA absente du garage !"));
        }
    }


    ////////////// TESTS DES METHODES ///////////////////////////

    @Test
    void test_place_Libre() {
        // test si la place numPlce est libre
        assertTrue(gTest.isLibre(0));
    }

    @Test
    void test_Place() {
        //test pour connaitre l'immat de la voiture garée à la place 0
        assertEquals(-1,gTest.place("aa-111-aa")); //place libre
    }

    @Test
    void test_Garer() throws GarageException {
        // test de parking
        assertTrue (gTest.isLibre(0));
        gTest.garer (v1,0);
        assertFalse (gTest.isLibre(0));
        gTest.garer(v2,2); //se gare sur une place inexistante
    }

    @Test
    void test_Recuperer_Par_Le_Numero_De_Place() throws GarageException {
        // test pour vérifier qu'on récupère la même voiture que celle qu'on a garé à la place 0
        gTest.garer(v1,0);
        v0=gTest.recuperer(0);
        assertTrue(v0.equals(v1));
        assertNull(gTest.recuperer(2)); //récupère une voiture d'une place inexistante
    }

    @Test
    void test_Recuperer_Par_L_Immatriculation() throws GarageException {
        // test pour vérifier qu'on récupère la même voiture que celle qu'on a garé à la place 0
        gTest.garer(v1,0);
        v0=gTest.recuperer(v1.getImmat());
        assertTrue(v0.equals(v1));
    }

    @Test
    void testToString() throws GarageException {
        // test pour vérifier la sortie texte de l'état du garage
        assert (gTest.toString().contains("Le garage a 1 places disponibles sur 1 places."));
        gTest.garer(v1,0);
        assert (gTest.toString().contains("Le garage a 0 places disponibles sur 1 places."));
        assert (gTest.toString().contains("Place 0: voiture Ford immatriculée: AA-111-AA"));
    }
}
