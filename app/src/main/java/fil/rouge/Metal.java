package fil.rouge;

public class Metal extends Ressource{

    public Metal(String nom) {
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
