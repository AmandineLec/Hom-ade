package fil.rouge;

public class Vegetal extends Ressource{

    public Vegetal(String nom) {
        super(nom);
    }

    @Override
    public void ramasser(Joueur j, int quantite) {
        super.ramasser(j, quantite);
        
    }
    
}
