package fil.rouge;
import java.util.HashMap;

public abstract class Personnage {
  protected int id_personnage;
  protected String name;
  protected boolean sexe = true; // true pour masculin false pour féminin ou inversement si vous préférer
  protected HashMap<Objet, Integer> inventory;
  protected Outils outils; 

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
  }

  public Personnage(String name, boolean sexe){
    this.name = name;
    this.sexe = sexe;
    inventory = new HashMap<Objet, Integer >();
  }
//#endregion

//#region METHOD

public void Creer_item(Recettes recette){
    
}

//#endregion
}
