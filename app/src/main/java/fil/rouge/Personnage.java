package fil.rouge;
import java.util.HashMap;

public abstract class Personnage {
  protected String name;
  protected boolean sexe = true; // true pour masculin false pour féminin ou inversement si vous préférer
  protected HashMap<String, Integer> inventory = new HashMap<String, Integer >();

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

  public HashMap<String, Integer> getInventory() {
    return inventory;
  }

  public void setInventory(HashMap<String, Integer> newInventory) {
    this.inventory = newInventory;
  }

  public Personnage(String name, boolean sexe){
    this.name = name;
    this.sexe = sexe;
  }
//#endregion
}
