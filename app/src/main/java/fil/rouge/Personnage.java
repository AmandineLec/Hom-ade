package fil.rouge;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "personnage")
public abstract class Personnage {
  @Id
  @Column(name = "id_personnage")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id_personnage;

  @Column(name = "nom")
  protected String name;

  @Column(name = "sexe")
  protected Integer sexe = 1; // 1 pour masculin 2 pour féminin ou inversement si vous préférer

  @ManyToOne
  @JoinColumn(name = "id_maison")
  protected Maison maison;

  @OneToMany(mappedBy = "personnage")
  protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

  @OneToMany(mappedBy = "personnage")
  protected Set<InventaireRessources> inventaireRessources = new HashSet<InventaireRessources>();

  
  // protected Outils outils;
  

//#region getter and setter and one construtor

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public Integer getSexe() {
    return sexe;
  }

  public void setSexe(Integer newSexe) {
    this.sexe = newSexe;
  }

  

  public Integer getId_personnage() {
    return id_personnage;
  }

  public void setId_personnage(int id_personnage) {
    this.id_personnage = id_personnage;
  }

  public Set<InventaireObjet> getInventaireObjet() {
    return inventaireObjets;
  }

  public void addInventaireObjet(InventaireObjet inventaireObjet) {
    inventaireObjets.add(inventaireObjet);
  }

  public Set<InventaireRessources> getInventaireRessource() {
    return inventaireRessources;
  }

  public void addInventaireRessource(InventaireRessources inventaireRessource) {
    inventaireRessources.add(inventaireRessource);
  }

  // public Outils getOutils() {
  //   return outils;
  // }

  // public void setOutils(Outils outils) {
  //   this.outils = outils;
  // }


  public Maison getMaison() {
    return maison;
  }

  public void setMaison(Maison maison) {
    this.maison = maison;
  }

  public Personnage(String name, Integer sexe){
    this.name = name;
    this.sexe = sexe;
    
    maison = new Maison(1);
    }
//#endregion

}
