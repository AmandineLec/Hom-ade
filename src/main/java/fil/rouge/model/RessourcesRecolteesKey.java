package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class RessourcesRecolteesKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5306688055493608727L;

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