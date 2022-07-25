package fil.rouge;

public abstract class Ressource extends Objet implements IRamassable{    

    public Ressource(int id, String nom) {
        super(nom, id);
    }

}
