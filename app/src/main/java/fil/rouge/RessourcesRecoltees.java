package fil.rouge;

import java.io.Serializable;

import jakarta.persistence.*;


@Embeddable
class RessourceRecolteesKey implements Serializable {
    @Column(name = "id_element_recoltable")
    protected Integer idElementRecoltable;

    @Column(name = "id_ressource")
    protected Integer idRessource;

    //#region getset
    public Integer getIdElementRecoltable() {
        return idElementRecoltable;
    }

    public void setIdElementRecoltable(Integer idElementRecoltable) {
        this.idElementRecoltable = idElementRecoltable;
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
@Table(name = "ressources_recoltees")
public class RessourcesRecoltees {
    @EmbeddedId
    protected RessourceRecolteesKey id;

    @ManyToOne
    @MapsId("idElementRecoltable")
    @JoinColumn(name = "id_element_recoltable")
    protected ObjetRecoltable objetRecoltable;

    @ManyToOne
    @MapsId("idRessource")
    @JoinColumn(name = "id_ressource")
    protected Ressource ressource;

    @Column(name = "quantite")
    protected Integer quantite;

    //#region getset
    public RessourceRecolteesKey getId() {
        return id;
    }

    public void setId(RessourceRecolteesKey id) {
        this.id = id;
    }

    public ObjetRecoltable getObjetRecoltable() {
        return objetRecoltable;
    }

    public void setObjetRecoltable(ObjetRecoltable objetRecoltable) {
        this.objetRecoltable = objetRecoltable;
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
