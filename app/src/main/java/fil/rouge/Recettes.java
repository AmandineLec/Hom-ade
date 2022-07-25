package fil.rouge;

public class Recettes {
    //#region Variables
    int id;
    String nom;
    int quantite;
    Ressource ressource; 

    //#endregion

    //#region Constructeur
    public Recettes(String nom){
        this.nom = nom;
    }

    public Recettes(int id){
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

    public int getQuantite() {
        return quantite;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }    
    //#endregion
    
}
