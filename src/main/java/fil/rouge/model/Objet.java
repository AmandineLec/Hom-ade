package fil.rouge.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "objet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Objet {

    //#region Variables
    @Id
    @Column(name = "id_objet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected int categorie;

    @OneToMany(mappedBy = "objet")
    protected Set<Recette> recette = new HashSet<Recette>();

    @OneToMany(mappedBy = "objet")
    protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

    // #endregion

    //#region Constructeur

    public Objet(String nom){
        this.nom = nom;
    }
    public Objet(int id){
        this.id = id;
    }

    public Objet(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }
    public Objet(){
        
    }
    //#endregion

    //#region GETTER & SETTER
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCategorie() {
        return categorie;
    }
    public Set<Recette> getRecette() {
        return recette;
    }
    public void setRecette(Set<Recette> recette) {
        this.recette = recette;
    }
    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public Set<InventaireObjet> getInventaireObjets() {
        return inventaireObjets;
    }

    public void addInventaireObjets(InventaireObjet inventaireObjet) {
        inventaireObjets.add(inventaireObjet);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Objet objet = (Objet)obj;
        return objet.getId() == id;
    }

    @Override
    public String toString() {
        return "Objet [id=" + id + ", nom=" + nom + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    

    // #endregion

    
}
