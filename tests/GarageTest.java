import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GarageTest {
    Garage gTest;
    Voiture v0, v1, v2, v3;

    @BeforeEach
    void setUp() throws GarageException {
        gTest = new Garage(1);
        v1 = new Voiture("aa-111-aa", "Ford");
        v2 = new Voiture("bb-222-bb", "Ford");
        //v3 = new Voiture("cc-333-cc", "Ford");
    }

    ///////////////// TESTS DES EXCEPTIONS ////////////////////

    @Test
    void testErreurQuandSeGareSurPlaceOccupee() {
        try {
            gTest.garer(v1, 0);
            gTest.garer(v2, 0);
        } catch (GarageException e) {
            assert(e.getMessage().contains("ERREUR: cette place est déjà occupée !"));
        }
    }


    ////////////// TESTS DES METHODES ///////////////////////////
    @Test
    void placeLibre() {
        // test si la place numPlce est libre
        assertTrue(gTest.isLibre(0));
    }

    @Test
    void testPlace() {
        //test pour connaitre l'immat de la voiture garée à la place 0
        assertEquals(-1,gTest.place("aa-111-aa")); //place libre
    }

    @Test
    void testGarer() throws GarageException {
        // test de parking
        assertTrue (gTest.isLibre(0));
        gTest.garer (v1,0);
        assertFalse (gTest.isLibre(0));
    }

    @Test
    void testRecupererParLeNuméroDePlace() throws GarageException {
        // test pour vérifier qu'on récupère la même voiture que celle qu'on a garé à la place 0
        gTest.garer(v1,0);
        v0=gTest.recuperer(0);
        assertTrue(v0.equals(v1));
    }

    @Test
    void testRecupererParLImmatriculation() throws GarageException {
        // test pour vérifier qu'on récupère la même voiture que celle qu'on a garé à la place 0
        gTest.garer(v1,0);
        v0=gTest.recuperer(v1.getImmat());
        assertTrue(v0.equals(v1));
    }

}
