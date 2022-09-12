package fil.rouge;



public class Joueur extends Personnage {
  protected int id_maison;

//#region  constructor

  public Joueur(String name, int sexe){
    super(name, sexe);
  }
//#endregion


//#region method

// public boolean ajouterObjet(Objet objet, int quantite) {
//   if (inventoryobjet.containsKey(objet.getId())) { // si l'inventaire contient déja l'objet en question
//     quantite += inventoryobjet.get((objet.getId())); // nouvelle quantité de l'objet + ancienne quantité de l'objet
//   }
//   inventoryobjet.put(objet.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
//   return true; // ou inventoryobjet.get(objet); qui devrait donner la quantité de l'objet
// }

// public boolean retirerObjet(Objet objet, int quantite) {
//   try {
//     if (inventoryobjet.get(objet.getId()) > quantite) {
//       quantite = inventoryobjet.get((objet.getId())) - quantite;
//       inventoryobjet.put(objet.getId(), quantite);
//       return true;
//     } else if (inventoryobjet.get(objet.getId()) == quantite) {
//       inventoryobjet.remove(objet.getId());
//       return true; // ou inventoryobjet.get(objet); qui devrait donnner 0
//     }
//   } catch (Exception e) {
//     System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
//   }
//   return false;
// }

// public boolean ajouterRessource(Ressource ressource, int quantite) {
//   if (inventoryressource.containsKey(ressource.getId())) { // si l'inventaire contient déja l'ressource en question
//     quantite += inventoryressource.get((ressource.getId())); // nouvelle quantité de l'ressource + ancienne quantité de l'ressource
//   }
//   inventoryressource.put(ressource.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
//   return true; // ou inventoryressource.get(objet); qui devrait donner la quantité de ressource
// }

// public boolean retirerRessource(Ressource ressource, int quantite) {
//   try {
//     if (inventoryressource.get(ressource.getId()) > quantite) {
//       quantite = inventoryressource.get((ressource.getId())) - quantite;
//       inventoryressource.put(ressource.getId(), quantite);
//       return true;
//     } else if (inventoryressource.get(ressource.getId()) == quantite) {
//       inventoryressource.remove(ressource.getId());
//       return true; // ou inventoryressource.get(objet); qui devrait donnner 0
//     }
//   } catch (Exception e) {
//     System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
//   }
//   return false;
// }



//   public static int sauvegarderJoueur(Joueur joueur){
//     try{
//       int idMaison = Maison.sauvegarderMaison();
//       String query = "INSERT INTO personnage (nom,sexe,id_maison) VALUES (?,?,?)";
//       PreparedStatement Stmt = DBManager.preparedStatement(query);
//       Stmt.setString(1, joueur.getName());
//       //https: // stackoverflow.com/questions/45458881/setboolean-method-of-java-sql-preparedstatement
//       Stmt.setInt(2, joueur.getSexe());
//       Stmt.setInt(3, idMaison);
//       Stmt.executeUpdate(); // execute la mise à jour dans la bdd
//       ResultSet res = Stmt.getGeneratedKeys();
//       res.next(); // de type boolean et renvoit true si il y'a un prochain element à traiter
//       int clePrimaireJoueur = res.getInt(1);
//       return clePrimaireJoueur;

//     }catch(SQLException ex){
//       // handle any errors
//       System.out.println("SQLException: " + ex.getMessage());
//       System.out.println("SQLState: " + ex.getSQLState());
//       System.out.println("VendorError: " + ex.getErrorCode());
//     }
//     return -1;
//   }

//#endregion

}
