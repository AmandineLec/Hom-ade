package fil.rouge;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
class InventaireRessourcesKey implements Serializable {
    @Column(name = "id_personnage")
    protected Integer idPersonnage;

    @Column(name = "id_ressource")
    protected Integer idRessource;

    //#region getset
    public Integer getIdPersonnage() {
        return idPersonnage;
    }

    public void setIdPersonnage(Integer idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public Integer getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(Integer idRessource) {
        this.idRessource = idRessource;
    }
    //#endregion
    
}

@Entity
@Table(name = "inventaire_ressources")
public class InventaireRessources {
    @EmbeddedId
    protected InventaireObjetKey id;

    @ManyToOne
    @MapsId("idPersonnage")
    @JoinColumn(name = "id_personnage")
    protected Personnage personnage;

    @ManyToOne
    @MapsId("idRessource")
    @JoinColumn(name = "id_ressource")
    protected Ressource ressource;

    @Column(name = "quantite")
    protected Integer quantite;

    
    //#region getset
    public InventaireObjetKey getId() {
        return id;
    }

    public void setId(InventaireObjetKey id) {
        this.id = id;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    //#endregion
    

    
}
