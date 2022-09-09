package fil.rouge;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
class InventaireObjetKey implements Serializable{
    @Column(name = "id_personnage")
    protected int idPersonnage;

    @Column(name = "id_objet")
    protected int idObjet;

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

@Entity
@Table(name = "inventaire_objet")
public class InventaireObjet {
    @EmbeddedId
    protected InventaireObjetKey id;

    @ManyToOne
    @MapsId("idPersonnage")
    @JoinColumn(name = "id_personnage")
    protected Personnage personnage;

    @ManyToOne
    @MapsId("idObjet")
    @JoinColumn(name = "id_objet")
    protected Objet objet;

    //#region getset
    public InventaireObjetKey getId() {
        return id;
    }

    public void setId(InventaireObjetKey id) {
        this.id = id;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    //#endregion
}

