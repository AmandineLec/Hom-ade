package fil.rouge.model;

import java.io.Serializable;

import javax.persistence.*;



@Embeddable
public class RecettesKey implements Serializable {

	private static final long serialVersionUID = -1959045878377964511L;

	@Column(name = "id_objet")
    protected int idObjet;

    @Column(name = "id_ressource")
    protected int idRessource;

    public RecettesKey(int idObjet, int idRessource) {
        this.idRessource = idRessource;
        this.idObjet = idObjet;
    }

    public RecettesKey(){};

    //#region getset
    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    //#endregion
}