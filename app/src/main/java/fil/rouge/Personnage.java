package fil.rouge;
import java.util.HashMap;

public abstract class Personnage {
  protected int id_personnage;
  protected String name;
  protected boolean sexe = true; // true pour masculin false pour féminin ou inversement si vous préférer
  protected HashMap<Ressource, Integer> inventaire = new HashMap<Ressource, Integer >();
  protected HashMap<Objet, Integer> inventaireObjet = new HashMap<Objet, Integer>();

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
  }

  public Personnage(String name, boolean sexe){
    this.name = name;
    this.sexe = sexe;
  }
//#endregion
}
