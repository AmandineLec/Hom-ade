package fil.rouge;

<<<<<<< HEAD
public abstract class Ressource extends Objet implements IRamassable{    

    public Ressource(int id, String nom) {
        super(nom, id);
=======
public abstract class Ressource implements IRamassable{
    private int id = 0;
    private String nom;

    

    public Ressource(String nom) {
        this.nom = nom;
    }

    //#region getset
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
>>>>>>> Yannick
    }
    //#endregion

}
