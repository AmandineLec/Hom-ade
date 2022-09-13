package fil.rouge;
import java.util.HashMap;

public abstract class Personnage {
  protected int idPersonnage;
  protected String name;
  protected int sexe = 1; // 1 pour masculin 2 pour féminin ou inversement si vous préférer
  protected HashMap<Integer, Integer> inventoryRessource = new HashMap<Integer, Integer>(); //Permet de remonter uniquement les ressources pour la méthode recette
  protected HashMap<Integer, Integer> inventoryObjet = new HashMap<Integer, Integer>();
  protected Outils outils;
  protected Maison maison = new Maison();

//#region getter and setter and one construtor
  public int getIdPersonnage() {
    return idPersonnage;
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public int getSexe() {
    return sexe;
  }

  public void setSexe(int newSexe) {
    this.sexe = newSexe;
  }

  public HashMap<Integer, Integer> getInventoryRessource() {
    return inventoryRessource;
  }

  public void setInventoryressource(HashMap<Integer, Integer> inventoryRessource) {
    this.inventoryRessource = inventoryRessource;
  }

  public HashMap<Integer, Integer> getInventoryObjet() {
    return inventoryObjet;
  }

  public void setInventoryObjet(HashMap<Integer, Integer> inventoryObjet) {
    this.inventoryObjet = inventoryObjet;
  }

  public Outils getOutils() {
    return outils;
  }

  public void setOutils(Outils outils) {
    this.outils = outils;
  }

  public Maison getMaison() {
    return maison;
  }

  public void setMaison(Maison maison) {
    this.maison = maison;
  }

  public Personnage(){}

  public Personnage(String name, int sexe){
      this.name = name;
      this.sexe = sexe;
    }
//#endregion


}
