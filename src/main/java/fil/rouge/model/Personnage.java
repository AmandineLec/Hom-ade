package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "personnage")
public class Personnage {
  // #region variables
  @Id
  @Column(name = "id_personnage")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int idPersonnage;

  @Column(name = "nom")
  protected String name;

  @Column(name = "sexe")
  protected int sexe = 1; // 1 pour masculin 2 pour féminin ou inversement si vous préférer

  @ManyToOne
  @JoinColumn(name = "id_maison")
  protected Maison maison;

  @OneToMany(mappedBy = "personnage") 
  protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

  @OneToMany(mappedBy = "personnage")
  protected Set<InventaireRessource> inventaireRessources = new HashSet<InventaireRessource>();

  @ManyToOne
  @JoinColumn(name = "outil")
  protected Outil outil;

  @Column(name = "mail")
  protected String mail;

  @Column(name = "password")
  protected String password;
  // #endregion

  public Personnage(String name, int sexe) {
    this.name = name;
    this.sexe = sexe;
  }

  public Personnage(String name, int sexe, String mail, String password) {
    this.name = name;
    this.sexe = sexe;
    this.name = name;
    this.password = password;
  }

  public Personnage(){}

  // #region GET/SET

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

  public int getIdPersonnage() {
    return idPersonnage;
  }

  public void setIdPersonnage(int id_personnage) {
    this.idPersonnage = id_personnage;
  }

  public Set<InventaireObjet> getInventaireObjet() {
    return inventaireObjets;
  }

  public boolean addInventaireObjet(InventaireObjet inventaireObjet) {
    return inventaireObjets.add(inventaireObjet);
  }

  public Set<InventaireRessource> getInventaireRessource() {
    return inventaireRessources;
  }

  public boolean addInventaireRessource(InventaireRessource inventaireRessource) {
    return inventaireRessources.add(inventaireRessource);
  }

  public Outil getOutil() {
    return outil;
  }

  public void setOutil(Outil outil) {
    this.outil = outil;
  }

  public Maison getMaison() {
    return maison;
  }

  public void setMaison(Maison maison) {
    this.maison = maison;
  }

  public Set<InventaireObjet> getInventaireObjets() {
    return inventaireObjets;
  }

  public void setInventaireObjets(Set<InventaireObjet> inventaireObjets) {
    this.inventaireObjets = inventaireObjets;
  }

  public Set<InventaireRessource> getInventaireRessources() {
    return inventaireRessources;
  }

  public void setInventaireRessources(Set<InventaireRessource> inventaireRessources) {
    this.inventaireRessources = inventaireRessources;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // #endregion

}
