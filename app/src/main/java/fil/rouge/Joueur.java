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
  if(inventory.containsKey(objet)){ // si l'inventaire contient déja l'objet en question
    quantite += inventory.get((objet)); // nouvelle quantité de l'objet + ancienne quantité de l'objet
  }
  inventory.put(objet, quantite); // on ajoute la ressource et sa nouvelle quantité
  return true;
}

public boolean retirerObjet(Objet objet, int quantite) throws JoueurException {
  // try{
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
  // } catch (ArithmeticException e) {
  //     System.out.println("Vous ne pouvez pas supprimer plus d'objets que vous n'en disposez!");
  //   }
    return false;
  }

//#endregion

}
