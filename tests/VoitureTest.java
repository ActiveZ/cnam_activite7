import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoitureTest {
    private Voiture v1, v2, v3;

    @BeforeEach
    void setUp() {
        v1 = new Voiture("aa-111-AA", "Ford");
        v2 = new Voiture("aA-111-aA", "FORD");
        v3 = new Voiture("bb-111-aa","Ford");
    }

    @Test
    void testEquals() {
        // test égalité sur immat identique, insensible à la casse
        assertEquals(true, v1.equals(v2));
        //test égalité sur modèle avec immat différente
        assertEquals(false, v1.equals(v3));
    }
}