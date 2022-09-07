package fil.rouge;
import java.util.HashMap;

import jakarta.persistence.*;

@Entity
@Table(name = "personnage")
public abstract class Personnage {
  @Id
  @Column(name = "id_personnage")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id_personnage;

  @Column(name = "nom")
  protected String name;

  @Column(name = "sexe")
  protected int sexe = 1; // 1 pour masculin 2 pour féminin ou inversement si vous préférer

  @ManyToOne
  @JoinColumn(name = "id_maison")
  protected Maison maison;

  protected HashMap<Integer, Integer> inventoryressource; //Permet de remonter uniquement les ressources pour la méthode recette
  protected HashMap<Integer, Integer> inventoryobjet;
  protected Outils outils;
  

//#region getter and setter and one construtor

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

  public HashMap<Integer, Integer> getInventoryressource() {
    return inventoryressource;
  }

  public void setInventoryressource(HashMap<Integer, Integer> inventoryessource) {
    this.inventoryressource = inventoryessource;
  }

  public HashMap<Integer, Integer> getInventoryobjet() {
    return inventoryobjet;
  }

  public void setInventoryobjet(HashMap<Integer, Integer> inventoryobjet) {
    this.inventoryobjet = inventoryobjet;
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

  public Personnage(String name, int sexe){
    this.name = name;
    this.sexe = sexe;
    inventoryressource = new HashMap<Integer, Integer>();
    inventoryobjet = new HashMap<Integer, Integer>();
    maison = new Maison(1);
    }
//#endregion

}
