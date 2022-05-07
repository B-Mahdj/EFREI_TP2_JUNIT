import java.util.List;

public class Tour {
    private List<Essai> essais;
    private Tour tourSuivant;

    public Tour(){
        this.tourSuivant = null;
        this.essais = null;
    }
    public List<Essai> getEssais() {
        return essais;
    }

    public void setEssais(List<Essai> essais) {
        this.essais = essais;
    }

    public Tour getTourSuivant() {
        return tourSuivant;
    }

    public void setTourSuivant(Tour tourSuivant) {
        this.tourSuivant = tourSuivant;
    }

    public int getQuillesRenversees(){
        int nb = 0;
        for(Essai e : essais){
            nb+= e.getQuillesRenversees();
        }
        return nb;
    }

    public int getQuillesRenverseesPremierEssai(){
        return essais.get(0).getQuillesRenversees();
    }

    public int calculScore(){
        int score = 0;
        for(int i = 0; i<essais.size(); ++i){
            score += essais.get(i).calculScore();
            if(score == 10 && this.tourSuivant != null){
                //Strike
                if(i==0 && this.tourSuivant.getTourSuivant() != null){
                    if(this.tourSuivant.getQuillesRenverseesPremierEssai() == 10){
                        score += this.tourSuivant.getQuillesRenverseesPremierEssai();
                        if(this.tourSuivant.getTourSuivant() != null){
                            score += this.tourSuivant.getTourSuivant().getQuillesRenverseesPremierEssai();
                        }
                    }
                    else {
                        score += this.tourSuivant.getQuillesRenversees();
                    }
                }
                else if(i>0 && this.tourSuivant!= null){
                    //Reserve
                    score += this.tourSuivant.getQuillesRenverseesPremierEssai();
                }
            }
        }
        return score;
    }

}
