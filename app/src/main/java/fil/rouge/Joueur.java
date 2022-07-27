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
  return true; // ou inventory.get(objet); qui devrait donner la quantité de l'objet
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
      return true; // ou inventory.get(objet); qui devrait donnner 0
    }
  } catch (Exception e) {
      System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
    }
    return false;
  }

//#endregion

}
