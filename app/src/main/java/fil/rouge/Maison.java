package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fil.rouge.utils.DBManager;

public class Maison {
    protected int idMaison;
    protected int niveau; // début à 1
    protected int nbPieces; // début à 1
    protected int nbRessources; // pour définir le nombre de ressources nécéssaires pour agrandir
    protected String etabli; // pour accéder à l'établi lors de la création d'objets
    // Array list transiant de pieces

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

    public int getNbPieces() {
        return nbPieces;
    }

    public void setNbPieces(int nbPieces) {
        this.nbPieces = nbPieces;
    }

    public int getNbRessources() {
        return nbRessources;
    }

    public void setNbRessources(int nbRessources) {
        this.nbRessources = nbRessources;
    }

    public String getEtabli() {
        return etabli;
    }

    public void setEtabli(String etabli) {
        this.etabli =
        etabli;
    }

    public int getIdMaison() {
        return idMaison;
    }
    
    //#endregion

    public void levelUp(Pieces piece){
        //ajouter une piece dans l'array list
        //this.niveau += 1;
    }


    public boolean sauvegarderMaison(){
        try{
            int niveauMaison = this.getNiveau();
            int nbPiecesMaison = this.getNbPieces();
            String query = "INSERT INTO maison (niveau,nb_pieces) VALUES (?,?)";
            PreparedStatement myStmt = DBManager.preparedStatement(query);
            myStmt.setInt(1, niveauMaison);
            myStmt.setInt(2, nbPiecesMaison);
            myStmt.executeUpdate();
            ResultSet res = myStmt.getGeneratedKeys();
            res.next();
            this.idMaison = res.getInt(1);
            return true;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return false;
    }

    //#endregion
}
