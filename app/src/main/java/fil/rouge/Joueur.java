package fil.rouge;

public class Joueur extends Personnage {
  protected int id_maison;

//#region  constructor

  public Joueur(String name, boolean sexe){
    super(name, sexe);
  }
//#endregion


//#region method

public int ajouterObjet(Objet objet, int quantite){
  if(inventory.containsKey(objet)){ // si l'inventaire contient déja l'objet en question
    quantite += inventory.get((objet)); // nouvelle quantité de l'objet + ancienne quantité de l'objet
  }
  inventory.put(objet, quantite); // on ajoute la ressource et sa nouvelle quantité
  return quantite; // ou inventory.get(objet); qui devrait donner la quantité de l'objet
}

public int retirerObjet(Objet objet, int quantite) {
  try{
    if(inventory.get(objet) > quantite){
      quantite = inventory.get((objet)) - quantite;
      inventory.put(objet, quantite);
      return quantite;
    }
    else if(inventory.get(objet) == quantite){
      inventory.remove(objet);
      return 0; // ou inventory.get(objet); qui devrait donnner 0
    }
  } catch (Exception e) {
      System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
    }
    return -1;
  }

//#endregion

}
