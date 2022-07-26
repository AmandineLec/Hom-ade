package fil.rouge;

import java.sql.ResultSet;
import java.sql.SQLException;

import fil.rouge.utils.DBManager;

public abstract class Ressource extends Objet implements IRamassable{
    private int id = 0;
    private String nom;

    

    public Ressource(String nom) {
        super(nom);
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

    public boolean get(int id) {
        try {
            ResultSet resultat = DBManager.query("SELECT * FROM ressource WHERE id_ressource = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.id = id;
                return true;
            }    

        }catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
            
        }
        return false;
    }

    
}
