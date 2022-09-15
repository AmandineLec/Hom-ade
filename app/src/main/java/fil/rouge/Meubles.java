package fil.rouge;
// import java.sql.*;
// import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "2")
public class Meubles extends Objet implements Deplacable{

    //#region Variables
    @Column(name = "taille")
    Integer taille;
    //#endregion

    //#region Constructeur
    // public Meubles(String nom){
    //     super(nom);
    // }

    // public Meubles(int id){
    //     super("");
    //         try {
    //             ResultSet resultat = DBManager.query("SELECT * FROM objet WHERE id_objet = "+id);
    //             if(resultat.next()){
    //                 this.nom = resultat.getString("nom");
    //                 this.types = resultat.getInt("type");
    //                 this.id = id;
    //                 }
    //             }
    //             catch (SQLException ex) {
    //                 // handle any errors
    //                 System.out.println("SQLException: " + ex.getMessage());
    //                 System.out.println("SQLState: " + ex.getSQLState());
    //                 System.out.println("VendorError: " + ex.getErrorCode());
    //             }
    // }
    //#endregion

    //#region GETTER & SETTER

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
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
