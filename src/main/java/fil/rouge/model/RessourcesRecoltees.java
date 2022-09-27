package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable
class RessourceRecolteesKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5306688055493608727L;

	@Column(name = "id_element_recoltable")
    protected int idElementRecoltable;

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
    protected Integer quantite;

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

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public RessourcesRecoltees(){}

    //#endregion

    

}
