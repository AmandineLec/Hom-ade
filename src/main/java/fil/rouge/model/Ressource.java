package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fil.rouge.inter.IRamassable;

@Entity
@Table(name = "ressource")
public class Ressource implements IRamassable {
    @Id
    @Column(name = "id_ressource")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "categorie")
    private String type = "";

    
    @OneToMany(mappedBy = "ressource")
    protected Set<RessourcesRecoltees> ressourcesRecoltees = new HashSet<RessourcesRecoltees>();

    @OneToMany(mappedBy = "ressource")
    protected Set<InventaireRessource> inventaireRessources = new HashSet<InventaireRessource>();

    //#region constructeurs
    public Ressource() {}

    public Ressource(String nom, int id, String type) {
        this.nom = nom;
        this.id = id;
        this.type = type;
    }

    public Ressource(String nom) {
        this.nom = nom;
    }
    //#endregion
    
    // #region getset

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<RessourcesRecoltees> getRessourcesRecoltees() {
        return ressourcesRecoltees;
    }

    public void addRessourcesRecoltees(RessourcesRecoltees ressourcesRecoltees) {
        this.ressourcesRecoltees.add(ressourcesRecoltees);
    }

    public Set<InventaireRessource> getInventaireRessources() {
        return inventaireRessources;
    }

    public void addInventaireRessources(InventaireRessource inventaireRessource) {
        inventaireRessources.add(inventaireRessource);
    }

    // #endregion

       

    public void ramasser(Personnage j, int quantite) {
        // j.ajouterRessource(this, quantite);
    }

}
