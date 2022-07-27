package fil.rouge;

public class Mineral extends Ressource{

    public Mineral(String nom) {
        super(nom);
    }

    @Override
<<<<<<< HEAD
    public void ramasser(Personnage p) {
=======
    public void ramasser(Joueur j, int quantite) {
        super.ramasser(j, quantite);
        
>>>>>>> Yannick
    }
    
}
