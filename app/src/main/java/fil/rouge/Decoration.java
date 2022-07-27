package fil.rouge;
import java.sql.*;
import fil.rouge.utils.DBManager;


public class Decoration extends Objet implements Deplacable {
     //#region Variables
    int taille;
     //#endregion

     //#region Constructeur
    public Decoration(String nom){
        super(nom);
    }

    public Decoration(int id){
        super("");
            try {
                ResultSet resultat = DBManager.query("SELECT * FROM objet WHERE id_objet = "+id);
                if(resultat.next()){
                    this.nom = resultat.getString("nom");
                    this.type = resultat.getString("type");
                    this.id = id;
                    }
                }
                catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }
    }
     //#endregion

     //#region GETTER & SETTER
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
     //#endregion

     //#region METHOD
    public void deplacer(){

    }

    public void tourner(){

    }

    //#endregion
}
