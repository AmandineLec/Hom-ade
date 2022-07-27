package fil.rouge;

public abstract class Objet {

    //#region Variables

    protected int id;
    protected String nom;
    protected String types;
    
    //#endregion

    //#region Constructeur

    public Objet(String nom){
        this.nom = nom;
    }
    public Objet(int id){
        this.id = id;
    }

    public Objet(String nom, int id){
        this.nom = nom; 
        this.id = id; 
    }
    //#endregion

    //#region GETTER & SETTER
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getTypes() {
        return types;
    }
    public void setTypes(String types) {
        this.types = types;
    }
    
    //#endregion 

    

}
