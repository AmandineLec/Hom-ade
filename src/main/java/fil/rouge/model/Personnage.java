package fil.rouge.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "personnage")
public class Personnage {
  // #region variables
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer idPersonnage;

  @Column(name = "nom")
  protected String name;

  @Column(name = "sexe")
  protected int sexe = 1; // 1 pour masculin 2 pour féminin ou inversement si vous préférez

  @ManyToOne
  @JoinColumn(name = "id_maison")
  protected Maison maison;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "personnage") 
  protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "personnage")
  protected Set<InventaireRessource> inventaireRessources = new HashSet<InventaireRessource>();

  @ManyToOne
  @JoinColumn(name = "outil")
  protected Outil outil;

  @Column(name = "mail", unique=true, nullable=false) // Pas forcément utile si déja setté en BDD, mais double vérification pour sécurité
  protected String mail;

  @Column(name = "password")
  protected String password;

  private boolean enabled;

  @ManyToMany(fetch = FetchType.EAGER) // LAZY = chargé quand appelé (getter, constructeur), EAGER = automatiquement chargé même sans appel
  @JoinTable(
    name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
  private Collection<Roles> roles;

  // #endregion


  public Personnage(){

  }

  public Personnage(String name, int sexe) {
    this.name = name;
    this.sexe = sexe;
  }

  public Personnage(String name, int sexe, String mail, String password){
    this.name = name; 
    this.sexe = sexe; 
    this.mail = mail; 
    this.password = password; 
  }

  public Personnage(String name, int sexe, String mail, String password, boolean enabled){
    this.name = name; 
    this.sexe = sexe; 
    this.mail = mail; 
    this.password = password; 
    this.enabled = enabled; 
  }

  public Personnage(String name, int sexe, String mail, String password, Integer id){
    this.name = name; 
    this.sexe = sexe; 
    this.mail = mail; 
    this.password = password; 
    this.idPersonnage = id; 
  }

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

  public Integer getIdPersonnage() {
    return idPersonnage;
  }

  public void setIdPersonnage(Integer idPersonnage) {
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

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Collection<Roles> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Roles> roles) {
    this.roles = roles;
  }
  // #endregion

  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idPersonnage == null) ? 0 : idPersonnage.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
      
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    Personnage other = (Personnage) obj;
    if (idPersonnage == null) {
      if (other.idPersonnage != null)
        return false;
    } else if (!idPersonnage.equals(other.idPersonnage))
      return false;
    
    return true;
  }

}
