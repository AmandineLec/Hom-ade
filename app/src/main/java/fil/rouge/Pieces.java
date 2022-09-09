package fil.rouge;



public class Pieces {
    
    protected int id_piece;
    protected String nom;
    protected Maison maison;
    protected int id_decoration; // pour récupérer la déco placée dans la maison
    protected int id_meuble; // pour récupérer le meuble placé dans la maison
    protected int nbMeubles;

    //#region Constructeurs

    public Pieces(String nom){
        this.nom = nom;
    }

    //#endregion

    //#region GETSET
    public int getNbMeubles() {
        return nbMeubles;
    }

    public void setNbMeubles(int nbMeubles) {
        this.nbMeubles = nbMeubles;
    }

    public int getId_decoration() {
        return id_decoration;
    }

    public void setId_decoration(int id_decoration) {
        this.id_decoration = id_decoration;
    }

    public int getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }

    public int getId_piece() {
        return id_piece;
    }

    public void setId_piece(int id_piece) {
        this.id_piece = id_piece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    //#endregion

    //#region Méthodes

    //#endregion
}
