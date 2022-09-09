package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

@Entity
@Table(name = "ressource")
public class Ressource implements IRamassable {
    @Id
    @Column(name = "id_ressource")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRessource;

    @Column(name = "nom")
    private String nom;

    @Column(name = "categorie")
    private String type = "";

    @OneToMany(mappedBy = "ressource")
    protected Set<RessourcesRecoltees> ressourcesRecoltees = new HashSet<RessourcesRecoltees>();

    @OneToMany(mappedBy = "ressource")
    protected Set<InventaireRessources> inventaireRessources = new HashSet<InventaireRessources>();

    public Ressource(String nom, int id, String type) {
        this.nom = nom;
        this.idRessource = id;
        this.type = type;
    }

    public Ressource(String nom) {
        this.nom = nom;
    }

    public Ressource(int id) {

    }

    // #region getset

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
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

    public Set<InventaireRessources> getInventaireRessources() {
        return inventaireRessources;
    }

    public void addInventaireRessources(InventaireRessources inventaireRessource) {
        inventaireRessources.add(inventaireRessource);
    }

    // #endregion

    public Ressource getById(int id) {
        DBManager.open();
        Ressource ressource = DBManager.session.getReference(Ressource.class, id);
        DBManager.close();
        return ressource;

    }

    

    public void ramasser(Joueur j, int quantite) {
        j.ajouterRessource(this, quantite);
    }

}
