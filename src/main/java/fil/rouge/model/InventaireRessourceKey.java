package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventaireRessourceKey implements Serializable {
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