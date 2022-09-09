package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fil.rouge.utils.DBManager;

public class Joueur extends Personnage {
  protected int idMaison;

//#region  constructor

  public Joueur(String name, int sexe){
    super(name, sexe);
  }
//#endregion


//#region method

public boolean ajouterObjet(Objet objet, Integer quantite) {
  if (inventaireObjets.containsKey(objet.getId())) { // si l'inventaire contient déja l'objet en question
    quantite += inventaireObjets.get((objet.getId())); // nouvelle quantité de l'objet + ancienne quantité de l'objet
  }
  inventaireObjets.put(objet.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
  return true; // ou inventoryobjet.get(objet); qui devrait donner la quantité de l'objet
}

public boolean retirerObjet(Objet objet, int quantite) {
  try {
    if (inventaireObjets.get(objet.getId()) > quantite) {
      quantite = inventaireObjets.get((objet.getId())) - quantite;
      inventaireObjets.put(objet.getId(), quantite);
      return true;
    } else if (inventaireObjets.get(objet.getId()) == quantite) {
      inventaireObjets.remove(objet.getId());
      return true; // ou inventoryobjet.get(objet); qui devrait donnner 0
    }
  } catch (Exception e) {
    System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
  }
  return false;
}

public boolean ajouterRessource(Ressource ressource, int quantite) {
  if (inventaireObjets.containsKey(ressource.getId())) { // si l'inventaire contient déja la ressource en question
    quantite += inventaireObjets.get((ressource.getId())); // nouvelle quantité de l'ressource + ancienne quantité de l'ressource
  }
  inventaireObjets.put(ressource.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
  return true; // ou inventoryressource.get(objet); qui devrait donner la quantité de ressource
}

public boolean retirerRessource(Ressource ressource, int quantite) {
  try {
    if (inventaireObjets.get(ressource.getId()) > quantite) {
      quantite = inventaireObjets.get((ressource.getId())) - quantite;
      inventaireObjets.put(ressource.getId(), quantite);
      return true;
    } else if (inventaireObjets.get(ressource.getId()) == quantite) {
      inventaireObjets.remove(ressource.getId());
      return true; // ou inventoryressource.get(objet); qui devrait donnner 0
    }
  } catch (Exception e) {
    System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
  }
  return false;
}



  // public int sauvegarderJoueur(){
  //   try{
  //     int idMaison = this.maison.getId_maison();
  //     String query = "INSERT INTO personnage (nom,sexe,id_maison) VALUES (?,?,?)";
  //     PreparedStatement Stmt = DBManager.preparedStatement(query);
  //     Stmt.setString(1, this.getName());
  //     //https: // stackoverflow.com/questions/45458881/setboolean-method-of-java-sql-preparedstatement
  //     Stmt.setInt(2, this.getSexe());
  //     Stmt.setInt(3, idMaison);
  //     Stmt.executeUpdate(); // execute la mise à jour dans la bdd
  //     ResultSet res = Stmt.getGeneratedKeys();
  //     res.next(); // de type boolean et renvoit true si il y'a un prochain element à traiter
  //     int clePrimaireJoueur = res.getInt(1);
  //     return clePrimaireJoueur;

  //   }catch(SQLException ex){
  //     // handle any errors
  //     System.out.println("SQLException: " + ex.getMessage());
  //     System.out.println("SQLState: " + ex.getSQLState());
  //     System.out.println("VendorError: " + ex.getErrorCode());
  //   }
  //   return -1;
  // }

//#endregion

}
