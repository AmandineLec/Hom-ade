package fil.rouge.dto;

public class RessourceDTO {
    private int idRessource;
    private String nom;


    //#region getset
    public int getIdRessource() {
        return idRessource;
    }
    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    //#endregion
}
