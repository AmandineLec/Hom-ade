package fil.rouge;
// import java.sql.*;
// import java.util.HashSet;
// import java.util.Set;

// import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "1")

public class Outils extends Objet implements IEquipable {


        @Column(name = "capacite")
        protected Integer capacite;


         //#endregion

        //#region Constructeur
        // public Outils(String nom) {
        //     super(nom);
        // }

        // public Outils(int id){
            
        //     super("");
        //     try {
        //         ResultSet resultat = DBManager.query("SELECT * FROM objet WHERE id_objet = "+id);
        //         if(resultat.next()){
        //             this.nom = resultat.getString("nom");
        //             this.types = resultat.getInt("type");
        //             // this.resistance = resultat.getInt("resistance");
        //             // this.capacite = resultat.getInt("capacite");
        //             this.id = id;
        //             }
        //         }
        //         catch (SQLException ex) {
        //             // handle any errors
        //             System.out.println("SQLException: " + ex.getMessage());
        //             System.out.println("SQLState: " + ex.getSQLState());
        //             System.out.println("VendorError: " + ex.getErrorCode());
        //         }
        // }
        public Outils(){
            super();
        }
        //#endregion

        //#region GETTER & SETTER


        public Integer getCapacite() {
            return capacite;
        }

        public void setCapacite(Integer capacite) {
            this.capacite = capacite;
        }
        //#endregion


        //#region METHOD

        public boolean equiper(Personnage target){
            // if(target.getOutils()!=null){
            //     target.ajouterObjet(target.getOutils(), 1);
            //     return true;
            // }
            // if(target.retirerObjet(this, 1)){
            //     target.setOutils(this);
            //     return true;
            // }
            return false;
        }

        public boolean desequipper(Personnage target){
            // if(target.getOutils()==this){
            //     target.ajouterObjet(this, 1);
            //     target.setOutils(null);
            //     return true;
            // }
            return false;
        }
        //#endregion

}
