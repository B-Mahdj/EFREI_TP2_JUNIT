import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EssaiTest {

    @Test
    public void testCreateEssai(){
        Essai essai = new Essai();
    }

    @Test
    public void testSetQuillesRenversees(){
        Essai essai = new Essai();
        essai.setQuillesRenversees(10);
        Assertions.assertEquals(10, essai.getQuillesRenversees());
    }

    @Test
    public void testCalculScoreEssai(){
        Essai essai = new Essai();
        essai.setQuillesRenversees(8);
        Assertions.assertEquals(8, essai.calculScore());
    }
}
