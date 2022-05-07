import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PartieTest {

    @Test
    public void testCreatePartie(){
        List<Tour> tours = new ArrayList<Tour>();
        Partie partie = new Partie(tours);
        Assertions.assertTrue(partie.getClass().equals(Partie.class));
    }

    @Test
    public void testCreatePartie_when_givenNumberOfTurns(){
        List<Tour> tours = new ArrayList<Tour>();
        Tour test = new Tour();
        for(int i = 0; i < 10; i++){
            tours.add(test);
        }
        Partie partie = new Partie(tours);
        Assertions.assertEquals(10, partie.getNumberOfTours());
    }

    @Test
    public void testCalculScorePartie_when_10_Tours(){
        //10 Tours avec 8 quilles touchees à chaque tour
        List<Tour> tours = new ArrayList<Tour>();
        Tour test = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai essai = new Essai();
        essai.setQuillesRenversees(4);
        essais.add(essai);
        essais.add(essai);
        test.setEssais(essais);
        for(int i = 0; i < 10; i++){
            tours.add(test);
        }
        Partie partie = new Partie(tours);
        Assertions.assertEquals(80, partie.calculScore());
    }

    @Test
    public void testCalculScorePartie_when_Only_Reserve(){
        //11 Tours avec que des reserve a chaque tour
        List<Tour> tours = new ArrayList<Tour>();
        Tour tourTest = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai essai = new Essai();
        essai.setQuillesRenversees(5);
        essais.add(essai);
        essais.add(essai);
        tourTest.setEssais(essais);
        tourTest.setTourSuivant(tourTest);
        for(int i = 0; i < 10; i++){
            tours.add(tourTest);
        }

        //Dernier tour
        Tour dernierTour = new Tour();
        List<Essai> essaisDernierTour = new ArrayList<Essai>();
        Essai essai2 = new Essai();
        essai2.setQuillesRenversees(5);
        essaisDernierTour.add(essai2);
        dernierTour.setEssais(essaisDernierTour);
        tours.add(dernierTour);

        Partie partie = new Partie(tours);
        Assertions.assertEquals(150, partie.calculScore());
    }

    @Test
    public void testCalculScorePartie_when_Only_Strike(){
        //11 Tours avec que des strike a chaque tour
        List<Tour> tours = new ArrayList<Tour>();
        Tour tourTest = new Tour();
        List<Essai> essais = new ArrayList<Essai>();
        Essai essai = new Essai();
        essai.setQuillesRenversees(10);
        essais.add(essai);
        tourTest.setEssais(essais);
        tourTest.setTourSuivant(tourTest);
        for(int i = 0; i < 10; i++){
            tours.add(tourTest);
        }
        Tour avantDernierTour = new Tour();
        avantDernierTour.setEssais(essais);
        Tour dernierTour = new Tour();
        dernierTour.setEssais(essais);
        avantDernierTour.setTourSuivant(dernierTour);
        tours.add(avantDernierTour);
        Partie partie = new Partie(tours);
        Assertions.assertEquals(300, partie.calculScore());
    }

}
