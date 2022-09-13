package fil.rouge;
import fil.rouge.utils.DBManager;
import java.sql.*;

// pas de sauvegarde en BDD, id créée en dur, lié a la maison grace au niveau

public class Pieces {
    protected int idPiece;
    // protected int id_decoration; // pour récupérer la déco placée dans la piece
    // protected int id_meuble; // pour récupérer le meuble placé dans la piece
    protected int nbMeubles;

    //#region Constructeurs
    public Pieces(){
    }

    // public Pieces(String nom){
    //     this.nom = nom;
    //     this.taille = 9;
    // }

    // public Pieces(String nom, int taille){
    //     this.nom = nom;
    //     this.taille = taille;
    // }

    public Pieces(int id){
        try {
            ResultSet resultat = DBManager.query("SELECT * FROM piece JOIN piece_maison on piece.id_piece = piece_maison.id_piece WHERE id_piece = "+id);
            if(resultat.next()){
                this.idPiece = id;
                }
            }
        catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
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
