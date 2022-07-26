package fil.rouge;

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
    }
    //#endregion

}
