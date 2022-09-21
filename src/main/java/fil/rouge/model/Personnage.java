package fil.rouge.model;

import java.util.HashSet;
import java.util.Iterator;
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
  // https://www.baeldung.com/hibernate-identifiers  
  @Id
  @Column(name = "id_personnage")
  @GeneratedValue(strategy = GenerationType.IDENTITY) // la clé primaire est auto-incrémentée par la bdd
  protected int idPersonnage;

  @Column(name = "nom")
  protected String name;

  @Column(name = "sexe")
  protected int sexe = 1; // 1 pour masculin 2 pour féminin ou inversement si vous préférez

  // https://koor.fr/Java/TutorialJEE/jee_jpa_many_to_one.wp
  // mapping sans table d'association
  @ManyToOne
  @JoinColumn(name = "id_maison") // Plusieurs joueurs(un joueur et un png) peuvent accéder à une maison. Retrouver la maison associée aux joueurs.
  protected Maison maison; 

  // https://koor.fr/Java/TutorialJEE/jee_jpa_one_to_many.wp
  // mapping avec table d'association qui stocke les foreign keys
  @OneToMany(mappedBy = "personnage") // Un joueur peut avoir un inventaire de plusieurs objets. Retrouver tous les objets de son inventaire.
  // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Set.html
  protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

  @OneToMany(mappedBy = "personnage")
  protected Set<InventaireRessource> inventaireRessources = new HashSet<InventaireRessource>();

  @ManyToOne // car l'outil est déja créee en bdd
  @JoinColumn(name = "outil")
  protected Outil outil;
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

  public int getIdPersonnage() {
    return idPersonnage;
  }

  public void setIdPersonnage(int idPersonnage) {
    this.idPersonnage = idPersonnage;
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

  public Personnage(String name, int sexe, Maison maison) {
    this.name = name;
    this.sexe = sexe;
    this.maison = maison; //pour attribuer d'emblée une maison à chaque joueur créee Voir avec Loic
  }
  // #endregion

  public boolean ajouterObjet(Objet objet, int quantite) {
    // https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Iterator.html
    Iterator<InventaireObjet> it = inventaireObjets.iterator();
    while (it.hasNext()) { // Returns true if the iteration has more elements
      InventaireObjet invObjet = it.next(); // Returns the next element in the iteration.

      if (invObjet.getId().getIdObjet() == objet.getId()) { // si l'inventaire contient déjà l'objet à ajouter on augmente sa quantité pour garder le même emplacement.
        invObjet.ajouterObjet(quantite);
        return true;
      }
    }
    InventaireObjet invObj = new InventaireObjet(this, objet, quantite); // dans le cas où l'objet n'est pas déja présent on créer un nouvel inventaire auxquel on ajoute l'objet et sa quantité
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
      if (invRes.getId().getIdRessource() == ressource.getId()) {
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
      if (invRes.getId().getIdRessource() == ressource.getId()) {
        return invRes.retirerRessource(quantite);

      }
    }
    return false;
  }

  public boolean sauvegarderJoueur() {
    
    return true;
  }
}
