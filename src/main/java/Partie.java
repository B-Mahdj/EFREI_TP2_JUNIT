import java.util.List;

public class Partie {
    private List<Tour> tours;

    public Partie(List<Tour> tours) {
        this.tours = tours;
    }

    public int getNumberOfTours() {
        return tours.size();
    }

    public int calculScore(){
        int score = 0;
        for(int i = 0; i< this.tours.size(); i++){
            if(i == 10){
                //Tour Bonus
            }
            else {
                score += this.tours.get(i).calculScore();
            }
        }
        return score;
    }
}
