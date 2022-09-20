package fil.rouge.model;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "maison")
public class Maison {
    @Id
    @Column(name = "id_maison")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idMaison;

    @Column(name = "niveau")
    protected int niveau; // début à 1

    @Column(name = "nb_pieces")
    protected int nbPieces; // début à 1

    @OneToMany(mappedBy = "maison")
    protected Set<Personnage> personnages = new HashSet<Personnage>();

    @Transient // non sauvegardé dans la bdd. Pour accéder à la pièce
    protected ArrayList<Piece> pieces = new ArrayList<Piece>();

    // protected String idRessource; // pour récupérer les ressources nécessaires à l'augmentation du niveau
    // protected int nbRessources; // pour définir le nombre de ressources nécéssaires pour ajouter une pièce
    // protected String etabli; // pour accéder à l'établi lors de la création d'objets
    // protected Piece piece; 

    //#region Constructeurs
    public Maison(){
        this.niveau = 1;
    }
    //#endregion

    //#region GETSET
    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNb_pieces() {
        return nbPieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nbPieces = nb_pieces;
    }

    // public String getId_ressource() {
    //     return id_ressource;
    // }

    // public void setId_ressource(String id_ressource) {
    //     this.id_ressource = id_ressource;
    // }

    // public int getNb_ressources() {
    //     return nb_ressources;
    // }

    // public void setNb_ressources(int nb_ressources) {
    //     this.nb_ressources = nb_ressources;
    // }

    // public String getEtabli() {
    //     return etabli;
    // }

    // public void setEtabli(String etabli) {
    //     this.etabli =
    //     etabli;
    // }

    public int getId_maison() {
        return idMaison;
    }

    public void setId_maison(int idMaison) {
        this.idMaison = idMaison;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }


    
    //#endregion

    //#region Méthodes
    // public void levelUp(Piece piece){
    //     this.setNiveau(this.getNiveau()+1);
    //     if (this.getNiveau()>=1 && this.getNiveau()<=3){
    //         this.pieceAccessible(piece);
    //     }
    //     else if(this.getNiveau()>3 && this.getNiveau()%2==0){ // si le niveau est pair on ajoute une pièce
    //         this.pieceAccessible(piece);
    //     }
    //     else{
    //         piece.agrandir(1);
    //     }
    // }

    // public void pieceAccessible(Piece piece){
    //     this.setNb_pieces(this.getNb_pieces()+1);
    //     this.piece = piece;
    // }

//       public static int sauvegarderMaison(){
//         try{
//           Maison maisonJoueur = new Maison(1);
//           int niveauMaison = maisonJoueur.getNiveau();
//           int nbPiecesMaison = maisonJoueur.getNb_pieces();
//           String query = "INSERT INTO maison (niveau,nb_pieces) VALUES (?,?)";
//           PreparedStatement myStmt = DBManager.preparedStatement(query);
//           myStmt.setInt(1, niveauMaison);
//           myStmt.setInt(2, nbPiecesMaison);
//           myStmt.executeUpdate();
//           ResultSet res = myStmt.getGeneratedKeys();
//           res.next();
//           int clePrimaireMaison = res.getInt(1);
//           return clePrimaireMaison;

//           } catch (SQLException ex) {
//           // handle any errors
//           System.out.println("SQLException: " + ex.getMessage());
//           System.out.println("SQLState: " + ex.getSQLState());
//           System.out.println("VendorError: " + ex.getErrorCode());
//         }
//       return -1;
//   }

    //#endregion
}
