package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class InventaireRessourceKey implements Serializable {

	private static final long serialVersionUID = 189750697029213336L;

	@Column(name = "id_personnage")
    protected Integer idPersonnage;

    @Column(name = "id_ressource")
    protected Integer idRessource;

    public InventaireRessourceKey(Integer idPersonnage, Integer ressourceId) {
        this.idPersonnage = idPersonnage;
        this.idRessource = ressourceId;
    }

    public InventaireRessourceKey(){}

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