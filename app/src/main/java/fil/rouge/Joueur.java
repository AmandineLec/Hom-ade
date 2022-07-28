package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fil.rouge.utils.DBManager;

public class Joueur extends Personnage {
  protected int id_maison;

//#region  constructor

  public Joueur(String name, boolean sexe){
    super(name, sexe);
  }
//#endregion


//#region method

public boolean ajouterObjet(Objet objet, int quantite){
  if(inventory.containsKey(objet)){ // si l'inventaire contient déja l'objet en question
    quantite += inventory.get((objet)); // nouvelle quantité de l'objet + ancienne quantité de l'objet
  }
  inventory.put(objet, quantite); // on ajoute la ressource et sa nouvelle quantité
  return true;
}

public boolean retirerObjet(Objet objet, int quantite) throws JoueurException{
    if(inventory.get(objet) > quantite){
      quantite = inventory.get((objet)) - quantite;
      inventory.put(objet, quantite);
      return true;
    }
    else if(inventory.get(objet) == quantite){
      inventory.remove(objet);
      return true;
    }
    if(inventory.get(objet) < quantite){
      throw new JoueurException("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
    }
    return false;
  }



  public static int sauvegarderJoueur(Joueur joueur){
    try{
      int idMaison = Maison.sauvegarderMaison();
      String query = "INSERT INTO personnage (nom,sexe,id_maison) VALUES (?,?,?)";
      PreparedStatement Stmt = DBManager.preparedStatement(query);
      Stmt.setString(1, joueur.getName());
      //https: // stackoverflow.com/questions/45458881/setboolean-method-of-java-sql-preparedstatement
      Stmt.setString(2, joueur.sexe ? "true": "false");
      Stmt.setInt(3, idMaison);
      Stmt.executeUpdate(); // execute la mise à jour dans la bdd
      ResultSet res = Stmt.getGeneratedKeys();
      res.next(); // de type boolean et renvoit true si il y'a un prochain element à traiter
      int clePrimaireJoueur = res.getInt(1);
      return clePrimaireJoueur;
    }catch(SQLException ex){
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
    return -1;
  }

//#endregion

}
