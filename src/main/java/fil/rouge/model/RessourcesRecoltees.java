package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Embeddable
class RessourceRecolteesKey implements Serializable {
<<<<<<< HEAD:app/src/main/java/fil/rouge/RessourcesRecoltees.java
    @Column(name = "id_element_recoltable")
    protected Integer idElementRecoltable;
=======
    /**
	 * 
	 */
	private static final long serialVersionUID = -5306688055493608727L;

	@Column(name = "id_element_recoltable")
    protected int idElementRecoltable;
>>>>>>> Yannick:src/main/java/fil/rouge/model/RessourcesRecoltees.java

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
