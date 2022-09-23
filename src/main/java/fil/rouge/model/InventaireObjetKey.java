package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventaireObjetKey implements Serializable{

	private static final long serialVersionUID = -5030374201224878732L;

	@Column(name = "id_personnage")
    protected Integer idPersonnage;

    @Column(name = "id_objet")
    protected Integer idObjet;

    public InventaireObjetKey(Integer idPersonnage, Integer objetId) {
        this.idPersonnage = idPersonnage;
        this.idObjet = objetId;
    }

    public InventaireObjetKey(){}

    //#region getset
    public Integer getIdPersonnage() {
        return idPersonnage;
    }

    public void setIdPersonnage(Integer idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public Integer getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(Integer idObjet) {
        this.idObjet = idObjet;
    }
    //#endregion
    
}
