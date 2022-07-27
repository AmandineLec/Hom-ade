package fil.rouge;

public class Eau extends Ressource{

    public Eau(int id, String nom) {
        super(nom, id);
    }

    @Override
    public void ramasser(Joueur j, int quantite) {
        super.ramasser(j, quantite);
        
    }
    
}
