package fil.rouge;

public abstract class Ressource extends Objet implements IRamassable{
    

    public Ressource(String nom, int id){
        super(nom, id);
    }

    public Ressource(String nom){
        super(nom);
    }

    public Ressource(int id){
        super(id);
    }



}
