package fil.rouge.model;



public class Pieces {
    protected int idPiece;
    // protected int id_decoration; // pour récupérer la déco placée dans la piece
    // protected int id_meuble; // pour récupérer le meuble placé dans la piece
    protected int nbMeubles;

    //#region Constructeurs
    public Pieces(){
    }

    public Piece(String nom){
        this.nom = nom;
        this.taille = 9;
    }

    //ajouter un constructeur qui permet d'aller chercher une piece grace à son nom et sa taille

    //#endregion

    //#region GETSET

    // public int getId_decoration() {
    //     return id_decoration;
    // }

    // public void setId_decoration(int id_decoration) {
    //     this.id_decoration = id_decoration;
    // }

    // public int getId_meuble() {
    //     return id_meuble;
    // }

    // public void setId_meuble(int id_meuble) {
    //     this.id_meuble = id_meuble;
    // }

    public int getId_piece() {
        return idPiece;
    }

    //#endregion

    //#region Méthodes
    public void agrandir(int agrandissement){
    }

    //#endregion
}
