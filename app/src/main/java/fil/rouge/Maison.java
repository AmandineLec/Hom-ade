package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

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

    @Transient
    protected ArrayList<Pieces> pieces = new ArrayList<Pieces>();

    protected String idRessource; // pour récupérer les ressources nécessaires à l'agrandissement
    protected int nbRessources; // pour définir le nombre de ressources nécéssaires pour agrandir
    protected String etabli; // pour accéder à l'établi lors de la création d'objets
    protected Pieces piece; // pour accéder à la pièce

    //#region Constructeurs
    public Maison(){
        this.niveau = 1;
        this.nbPieces = 1;
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

    public String getId_ressource() {
        return idRessource;
    }

    public void setId_ressource(String id_ressource) {
        this.idRessource = id_ressource;
    }

    public int getNb_ressources() {
        return nbRessources;
    }

    public void setNb_ressources(int nb_ressources) {
        this.nbRessources = nb_ressources;
    }

    public String getEtabli() {
        return etabli;
    }

    public void setEtabli(String etabli) {
        this.etabli =
        etabli;
    }

    public int getId_maison() {
        return idMaison;
    }

    public void setId_maison(int id_maison) {
        this.idMaison = id_maison;
    }

    public Pieces getPiece() {
        return piece;
    }

    public void setPiece(Pieces piece) {
        this.piece = piece;
    }

    //#endregion

    //#region Méthodes
    public void levelUp(Pieces piece){
        this.niveau += 1;
        ajouterDesPieces();   
    }

    public void ajouterDesPieces(){
        pieces.add(piece);
        this.nbPieces += 1;
    }
}

    // public int sauvegarderMaison(){
    // try{
    //     Maison maisonJoueur = new Maison();
    //     int niveauMaison = maisonJoueur.getNiveau();
    //     int nbPiecesMaison = maisonJoueur.getNb_pieces();
    //     String query = "INSERT INTO maison (niveau,nb_pieces) VALUES (?,?)";
    //     PreparedStatement myStmt = DBManager.preparedStatement(query);
    //     myStmt.setInt(1, niveauMaison);
    //     myStmt.setInt(2, nbPiecesMaison);
    //     myStmt.executeUpdate();
    //     ResultSet res = myStmt.getGeneratedKeys();
    //     res.next();
    //     int clePrimaireMaison = res.getInt(1);
    //     return clePrimaireMaison;

    //     } catch (SQLException ex) {
    //     // handle any errors
    //     System.out.println("SQLException: " + ex.getMessage());
    //     System.out.println("SQLState: " + ex.getSQLState());
    //     System.out.println("VendorError: " + ex.getErrorCode());
    //     }
    // return -1;
    // }


    //#endregion

