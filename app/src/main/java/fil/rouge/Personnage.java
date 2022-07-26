package fil.rouge;
import java.util.HashMap;

public abstract class Personnage {
  protected int id_personnage;
  protected String name;
  protected boolean sexe = true; // true pour masculin false pour féminin ou inversement si vous préférer
<<<<<<< HEAD
<<<<<<< HEAD
  protected HashMap<Objet, Integer> inventory = new HashMap<Objet, Integer >();
  protected Outils outils; 
=======
  protected HashMap<Ressource, Integer> inventaire = new HashMap<Ressource, Integer >();
  protected HashMap<Objet, Integer> inventaireObjet = new HashMap<Objet, Integer>();
>>>>>>> Yannick
=======
  protected HashMap<Objet, Integer> inventory;
  protected Outils outils;

>>>>>>> Selom

//#region getter and setter and one construtor

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public boolean getSexe() {
    return sexe;
  }

  public void setSexe(boolean newSexe) {
    this.sexe = newSexe;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Selom
  public HashMap<Objet, Integer> getInventory() {
    return inventory;
  }

  public void setInventory(HashMap<Objet, Integer> newInventory) {
    this.inventory = newInventory;
  }

  public Outils getOutils() {
    return outils;
  }

  public void setOutils(Outils outils) {
    this.outils = outils;
<<<<<<< HEAD
=======
  public HashMap<Ressource, Integer> getInventaire() {
    return inventaire;
  }

  public void setInventaire(HashMap<Ressource, Integer> newInventaire) {
    this.inventaire = newInventaire;
  }

  public HashMap<Objet, Integer> getInventaireObjet() {
    return inventaireObjet;
  }

  public void setInventaireObjet(HashMap<Objet, Integer> newInventaireObjet) {
    this.inventaireObjet = newInventaireObjet;
>>>>>>> Yannick
=======
>>>>>>> Selom
  }

  public Personnage(String name, boolean sexe){
    this.name = name;
    this.sexe = sexe;
    inventory = new HashMap<Objet,Integer>(); // pas besoin de faire de set
  }
//#endregion

//#region METHOD

public void Creer_item(Recettes recette){

}

//#endregion
}
