package fil.rouge;

import java.io.Serializable;

import jakarta.persistence.*;


@Embeddable
class RessourceRecolteesKey implements Serializable {
    @Column(name = "id_element_recoltable")
    protected int idElementRecoltable;

    @Column(name = "id_ressource")
    protected int idRessource;

    //#region getset
    public int getIdElementRecoltable() {
        return idElementRecoltable;
    }

    public void setIdElementRecoltable(int idElementRecoltable) {
        this.idElementRecoltable = idElementRecoltable;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
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
    protected int quantite;

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    //#endregion
}
