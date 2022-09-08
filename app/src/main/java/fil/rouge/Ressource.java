package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

@Entity
@Table(name = "ressource")
public class Ressource implements IRamassable{
    @Id
    @Column(name = "id_ressource")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRessource;

    @Column(name = "nom")
    private String nom;

    @Column(name = "categorie")
    private String type = "";

    public Ressource(String nom, int id, String type){
        this.nom = nom;
        this.idRessource = id;
        this.type = type;
    }

    public Ressource(String nom){
        this.nom = nom;
    }

    public Ressource(int id){
        
    }



    public boolean get(int id) {
        try {
            ResultSet resultat = DBManager.query("SELECT * FROM ressource WHERE id_ressource = "+id);
            if(resultat.next()){
                this.nom = resultat.getString("nom");
                this.type = resultat.getString("type");
                this.idRessource = id;
                return true;
            }    

        }catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
            
        }
        return false;
    }

    public boolean save() {
        String sql = "";
        if (this.idRessource != 0)
            sql = "UPDATE ressource " +
                    "SET nom = ?, type = ? " +
                    "WHERE id_ressource = ?";        
        else
            sql = "INSERT INTO ressource(nom, type) " +
                    "VALUES(?, ?)";
        try {
            PreparedStatement stmt = DBManager.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, this.nom);
            stmt.setString(2, this.type);
            if (this.idRessource != 0)
                stmt.setInt(3, this.idRessource);
            
            stmt.execute();
            ResultSet resultat = stmt.getGeneratedKeys();
            if (resultat.next())
                this.idRessource = resultat.getInt(1);
            return true;
        
        }catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }
        

    public void ramasser(Joueur j, int quantite) {
        j.ajouterRessource(this, quantite);
    }

    
    
}
