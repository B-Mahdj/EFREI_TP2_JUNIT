import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartieTest {

    @Test
    public void testCreatePartie(){
        Partie partie = new Partie(10);
        Assertions.assertTrue(partie.getClass().equals(Partie.class));
    }

    @Test
    public void testCreatePartie_when_givenNumberOfTurns(){
        Partie partie = new Partie(10);
        Assertions.assertEquals(10, partie.getNumberOfTurns());
    }
}
