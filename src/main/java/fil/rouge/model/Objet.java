package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "objet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Objet {

    // #region Variables
    @Id
    @Column(name = "id_objet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected int categorie;

    @OneToMany(mappedBy = "objet")
    protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();

    // #endregion

    // #region Constructeur

    public Objet(String nom) {
        this.nom = nom;
    }

    public Objet(int id) {
        this.id = id;
    }

    public Objet(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }
    // #endregion

    // #region GETTER & SETTER
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCategorie() {
        return categorie;
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
        if (obj == null || !(obj instanceof Objet))
            return false;
        Objet objet = (Objet)obj;
        return objet.getId() == id;
    }

    // #endregion

}
