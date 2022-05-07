import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TourTest {

    @Test
    public void testCreateTour(){
        Tour tour = new Tour();
    }

    @Test
    public void testSetEssaisGetEssais(){
        Tour tour = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai e = new Essai();
        Essai e2 = new Essai();
        essais.add(e);
        essais.add(e2);
        tour.setEssais(essais);
        Assertions.assertEquals(2, tour.getEssais().size());
    }

    @Test
    public void testCalculScoreTour_when_score_not_equals_10(){
        Tour tour = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai e1= new Essai(); Essai e2 = new Essai();
        e1.setQuillesRenversees(8); e2.setQuillesRenversees(1);
        essais.add(e1); essais.add(e2);
        tour.setEssais(essais);
        Assertions.assertEquals(9, tour.calculScore());
    }

    @Test
    public void testCalculScoreTour_when_reserve(){
        Tour tour = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai e1= new Essai(); Essai e2 = new Essai();
        e1.setQuillesRenversees(8); e2.setQuillesRenversees(2);
        essais.add(e1); essais.add(e2);
        tour.setEssais(essais);

        Tour tourSuivant = new Tour();
        Essai e3= new Essai(); Essai e4 = new Essai();
        e3.setQuillesRenversees(8); e4.setQuillesRenversees(1);
        List<Essai> essais2 = new ArrayList<Essai>();
        essais2.add(e3); essais2.add(e4);
        tourSuivant.setEssais(essais2);
        tour.setTourSuivant(tourSuivant);
        Assertions.assertEquals(18, tour.calculScore());
    }

    @Test
    public void testCalculScoreTour_when_strike(){
        Tour tour = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai e1= new Essai(); Essai e2 = new Essai();
        e1.setQuillesRenversees(10); e2.setQuillesRenversees(0);
        essais.add(e1); essais.add(e2);
        tour.setEssais(essais);

        Tour tourSuivant = new Tour();
        Essai e3= new Essai(); Essai e4 = new Essai();
        e3.setQuillesRenversees(8); e4.setQuillesRenversees(0);
        List<Essai> essais2 = new ArrayList<Essai>();
        essais2.add(e3); essais2.add(e4);
        tourSuivant.setEssais(essais2);
        tour.setTourSuivant(tourSuivant);

        Assertions.assertEquals(18, tour.calculScore());
    }

}
