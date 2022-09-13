package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fil.rouge.utils.DBManager;

public class Joueur extends Personnage {
  // protected int id_maison;

//#region  constructor
  public Joueur(){}

  public Joueur(String name, int sexe){
    super(name, sexe);
  }
//#endregion

//#region method

public boolean ajouterObjet(Objet objet, int quantite) {
  if (inventoryObjet.containsKey(objet.getId())) { // si l'inventaire contient déja l'objet en question
    quantite += inventoryObjet.get((objet.getId())); // nouvelle quantité de l'objet + ancienne quantité de l'objet
  }
  inventoryObjet.put(objet.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
  return true; 
}

public boolean retirerObjet(Objet objet, int quantite) {
  try {
    if (inventoryObjet.get(objet.getId()) > quantite) {
      quantite = inventoryObjet.get((objet.getId())) - quantite;
      inventoryObjet.put(objet.getId(), quantite);
      return true;
    } else if (inventoryObjet.get(objet.getId()) == quantite) {
      inventoryObjet.remove(objet.getId());
      return true; // ou inventoryObjet.get(objet); qui devrait donnner 0
    }
  } catch (Exception e) {
    System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
  }
  return false;
}

public boolean ajouterRessource(Ressource ressource, int quantite) {
  if (inventoryRessource.containsKey(ressource.getId())) { // si l'inventaire contient déja la ressource en question
    quantite += inventoryRessource.get((ressource.getId())); // nouvelle quantité de ressource + ancienne quantité de ressource
  }
  inventoryRessource.put(ressource.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
  return true;
}

public boolean retirerRessource(Ressource ressource, int quantite) {
  try {
    if (inventoryRessource.get(ressource.getId()) > quantite) {
      quantite = inventoryRessource.get((ressource.getId())) - quantite;
      inventoryRessource.put(ressource.getId(), quantite);
      return true;
    } else if (inventoryRessource.get(ressource.getId()) == quantite) {
      inventoryRessource.remove(ressource.getId());
      return true;
    }
  } catch (Exception e) {
    System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
  }
  return false;
}



  public boolean sauvegarderJoueur(){
    try{
      int idMaison = this.maison.getIdMaison();
      String query = "INSERT INTO personnage (nom,sexe,id_maison) VALUES (?,?,?)";
      PreparedStatement Stmt = DBManager.preparedStatement(query);
      Stmt.setString(1, this.getName());
      //https: // stackoverflow.com/questions/45458881/setboolean-method-of-java-sql-preparedstatement
      Stmt.setInt(2, this.getSexe());
      Stmt.setInt(3, idMaison);
      Stmt.executeUpdate(); // execute la mise à jour dans la bdd
      ResultSet res = Stmt.getGeneratedKeys();
      res.next(); 
      this.idPersonnage = res.getInt(1);
      this.maison.sauvegarderMaison();
      return true; // de type boolean et renvoit true si il y'a un prochain element à traiter

    }catch(SQLException ex){
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
    return false;
  }

//#endregion

}
