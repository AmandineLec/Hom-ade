package fil.rouge;


public class Joueur extends Personnage {
  protected int id_maison;

//#region  constructor

  public Joueur(String name, boolean sexe){
    super(name, sexe);
  }
//#endregion


//#region method

public boolean ajouterObjet(Objet objet, int quantite){
  if(inventoryobjet.containsKey(objet.getId())){ // si l'inventaire contient déja l'objet en question
    quantite += inventoryobjet.get((objet.getId())); // nouvelle quantité de l'objet + ancienne quantité de l'objet
  }
  inventoryobjet.put(objet.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
  return true; // ou inventoryobjet.get(objet); qui devrait donner la quantité de l'objet
}

public boolean retirerObjet(Objet objet, int quantite) {
  try{
    if(inventoryobjet.get(objet.getId()) > quantite){
      quantite = inventoryobjet.get((objet.getId())) - quantite;
      inventoryobjet.put(objet.getId(), quantite);
      return true;
    }
    else if(inventoryobjet.get(objet.getId()) == quantite){
      inventoryobjet.remove(objet.getId());
      return true; // ou inventoryobjet.get(objet); qui devrait donnner 0
    }
  } catch (Exception e) {
      System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
    }
    return false;
  }

  public boolean ajouterRessource(Objet objet, int quantite){
    if(inventoryressource.containsKey(objet.getId())){ // si l'inventaire contient déja l'objet en question
      quantite += inventoryressource.get((objet.getId())); // nouvelle quantité de l'objet + ancienne quantité de l'objet
    }
    inventoryressource.put(objet.getId(), quantite); // on ajoute la ressource et sa nouvelle quantité
    return true; // ou inventoryressource.get(objet); qui devrait donner la quantité de l'objet
  }
  
  public boolean retirerRessource(Objet objet, int quantite) {
    try{
      if(inventoryressource.get(objet.getId()) > quantite){
        quantite = inventoryressource.get((objet.getId())) - quantite;
        inventoryressource.put(objet.getId(), quantite);
        return true;
      }
      else if(inventoryressource.get(objet.getId()) == quantite){
        inventoryressource.remove(objet.getId());
        return true; // ou inventoryressource.get(objet); qui devrait donnner 0
      }
    } catch (Exception e) {
        System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
      }
      return false;
    }
  
//#endregion

}
