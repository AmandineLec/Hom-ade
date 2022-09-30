package fil.rouge.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "ressources_recoltees")
public class RessourcesRecoltees {
    @EmbeddedId
    protected RessourcesRecolteesKey id;

    @ManyToOne
    @MapsId("idElementRecoltable")
    @JoinColumn(name = "id_element_recoltable")
    protected ObjetRecoltable objetRecoltable;

    @ManyToOne
    @MapsId("idRessource")
    @JoinColumn(name = "id_ressource")
    protected Ressource ressource;

    @Column(name = "quantite")
    protected int quantite;

    //#region getset
    public RessourcesRecolteesKey getId() {
        return id;
    }

    public void setId(RessourcesRecolteesKey id) {
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public RessourcesRecoltees(){}

    //#endregion

    

}
