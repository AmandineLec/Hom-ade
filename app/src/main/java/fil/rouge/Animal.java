package fil.rouge;

public class Animal extends Ressource{

    public Animal(String nom) {
        super(nom);
    }

    @Override
    public void ramasser(Joueur j, int quantite) {
        super.ramasser(j, quantite);
        
    }
    
}
