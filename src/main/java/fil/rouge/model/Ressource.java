package fil.rouge.model;

<<<<<<< HEAD:app/src/main/java/fil/rouge/Ressource.java
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
=======
>>>>>>> Yannick:src/main/java/fil/rouge/model/Ressource.java
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fil.rouge.IRamassable;

@Entity
@Table(name = "ressource")
public class Ressource implements IRamassable {
    @Id
    @Column(name = "id_ressource")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD:app/src/main/java/fil/rouge/Ressource.java
    private Integer idRessource;
=======
    private Integer id;
>>>>>>> Yannick:src/main/java/fil/rouge/model/Ressource.java

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
<<<<<<< HEAD:app/src/main/java/fil/rouge/Ressource.java

    public Ressource(int id) {

    }

    public Ressource(){
        
    }

    // #region getset

    public Integer getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(Integer idRessource) {
        this.idRessource = idRessource;
=======
    //#endregion
    
    // #region getset

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
>>>>>>> Yannick:src/main/java/fil/rouge/model/Ressource.java
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

       

<<<<<<< HEAD:app/src/main/java/fil/rouge/Ressource.java
    }

    

    public void ramasser(Personnage j, int quantite) {
        // j.ajouterRessource(this, quantite);
=======
    public void ramasser(Personnage j, int quantite) {
        j.ajouterRessource(this, quantite);
>>>>>>> Yannick:src/main/java/fil/rouge/model/Ressource.java
    }

}
