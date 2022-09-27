package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
class InventaireRessourceKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 189750697029213336L;

	@Column(name = "id_personnage")
    protected Integer idPersonnage;


    @Column(name = "id_ressource")
    protected Integer idRessource;

    public InventaireRessourceKey(int id_personnage, int idRessource) {
        this.idPersonnage = id_personnage;
        this.idRessource = idRessource;
    }

    public InventaireRessourceKey(){

    };

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
    public InventaireRessource(){

    };

    public InventaireRessource(Personnage personnage, Ressource ressource, int quantite) {
        this.personnage = personnage;
        this.ressource = ressource;
        this.quantite = quantite;
        this.id = new InventaireRessourceKey(personnage.getIdPersonnage(), ressource.getId());
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

