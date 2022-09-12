package fil.rouge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Transaction;

import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

@Entity
@Table(name = "personnage")
public class Personnage {
  // #region variables
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

  @OneToMany(mappedBy = "personnage")
  protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

  @OneToMany(mappedBy = "personnage")
  protected Set<InventaireRessource> inventaireRessources = new HashSet<InventaireRessource>();

  @ManyToOne
  @JoinColumn(name = "outil")
  protected Outils outil;
  // #endregion

  // #region getter and setter and one construtor

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

  public int getId_personnage() {
    return id_personnage;
  }

  public void setId_personnage(int id_personnage) {
    this.id_personnage = id_personnage;
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

  public Outils getOutil() {
    return outil;
  }

  public void setOutil(Outils outil) {
    this.outil = outil;
  }

  public Maison getMaison() {
    return maison;
  }

  public void setMaison(Maison maison) {
    this.maison = maison;
  }

  public Personnage(String name, int sexe) {
    this.name = name;
    this.sexe = sexe;

    maison = new Maison(1);
  }
  // #endregion

  public boolean ajouterObjet(Objet objet, int quantite) {

    Iterator<InventaireObjet> it = inventaireObjets.iterator();
    while (it.hasNext()) {
      InventaireObjet invObjet = it.next();
      if (invObjet.getId().getIdObjet() == objet.getId()) {
        invObjet.ajouterObjet(quantite);
        return true;
      }
    }
    InventaireObjet invObj = new InventaireObjet(this, objet, quantite);
    return addInventaireObjet(invObj);

  }

  public boolean retirerObjet(Objet objet, int quantite) {
    Iterator<InventaireObjet> it = inventaireObjets.iterator();
    while (it.hasNext()) {
      InventaireObjet invObjet = it.next();
      if (invObjet.getId().getIdObjet() == objet.getId()) {
        return invObjet.retirerObjet(quantite);

      }
    }
    return false;
  }

  public boolean ajouterRessource(Ressource ressource, int quantite) {

    Iterator<InventaireRessource> it = inventaireRessources.iterator();
    while (it.hasNext()) {
      InventaireRessource invRes = it.next();
      if (invRes.getId().getIdRessource() == ressource.getIdRessource()) {
        invRes.ajouterRessource(quantite);
        return true;
      }
    }
    InventaireRessource invRes = new InventaireRessource(this, ressource, quantite);
    return addInventaireRessource(invRes);

  }

  public boolean retirerRessource(Ressource ressource, int quantite) {
    Iterator<InventaireRessource> it = inventaireRessources.iterator();
    while (it.hasNext()) {
      InventaireRessource invRes = it.next();
      if (invRes.getId().getIdRessource() == ressource.getIdRessource()) {
        return invRes.retirerRessource(quantite);

      }
    }
    return false;
  }

  public boolean sauvegarderJoueur() {
    DBManager.open();
    Transaction tx = DBManager.session.beginTransaction();
    DBManager.session.persist(this);
    tx.commit();
    DBManager.close();
    return true;
  }
}
