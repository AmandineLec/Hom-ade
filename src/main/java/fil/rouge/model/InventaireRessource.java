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
class InventaireRessourceKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 189750697029213336L;

	@Column(name = "id_personnage")
    protected int idPersonnage;

    @Column(name = "id_ressource")
    protected int idRessource;

    //#region getset
    public int getIdPersonnage() {
        return idPersonnage;
    }

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
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
@Table(name = "inventaire_ressources")
public class InventaireRessource {
    @EmbeddedId
    protected InventaireRessourceKey id;

    @ManyToOne
    @MapsId("idPersonnage")
    @JoinColumn(name = "id_personnage")
    protected Personnage personnage;

    @ManyToOne
    @MapsId("idRessource")
    @JoinColumn(name = "id_ressource")
    protected Ressource ressource;

    @Column(name = "quantite")
    protected int quantite;

    //#region getset
    public InventaireRessourceKey getId() {
        return id;
    }

    public void setId(InventaireRessourceKey id) {
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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    //#endregion
    
    InventaireRessource(Personnage personnage, Ressource ressource, int quantite) {
        this.personnage = personnage;
        this.ressource = ressource;
        this.quantite = quantite;
    }

    public void ajouterRessource(int quantite) {
        this.quantite += quantite;

    }

    public boolean retirerRessource(int quantite) {
        if (quantite > this.quantite)
            return false;
        this.quantite -= quantite;
        return true;
    }
}
