package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventaireObjetKey implements Serializable{

	private static final long serialVersionUID = -5030374201224878732L;

	@Column(name = "id_personnage")
    protected int idPersonnage;

    @Column(name = "id_objet")
    protected int idObjet;

    public InventaireObjetKey(int id_personnage, int objetId) {
        this.idPersonnage = id_personnage;
        this.idObjet = objetId;
    }

    public InventaireObjetKey(){}

    //#region getset
    public int getIdPersonnage() {
        return idPersonnage;
    }

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }
    //#endregion
    
}
