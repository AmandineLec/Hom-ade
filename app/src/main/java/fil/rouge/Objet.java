package fil.rouge;

public abstract class Objet {

    //#region Variables

    protected int id;
    protected String nom;
    protected EnumTypeObjet type_objet;
    protected int types;
    
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
    public int getTypes() {
        return types;
    }
    public void setTypes(int types) {
        this.types = types;
    }
    public EnumTypeObjet getType_objet() {
        return type_objet;
    }
    public void setType_objet(EnumTypeObjet type_objet) {
        this.type_objet = type_objet;
    }
    
    
    //#endregion 

    

}
