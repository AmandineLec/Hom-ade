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

// https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/Serializable.html
// https://www.jmdoudoux.fr/java/dej/chap-jpa.htm
@Embeddable // pour la création d'une clé primaire resultante de l'agregation de deux entité : personnage et objet
//  https://www.geeksforgeeks.org/serializable-interface-in-java/
class InventaireObjetKey implements Serializable{
    /**
	 * 
	 */
    // https://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it
	private static final long serialVersionUID = -5030374201224878732L;

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

    @Column(name = "quantite")
    protected int quantite;

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    //#endregion

    InventaireObjet(Personnage personnage, Objet objet, int quantite) {
        this.personnage = personnage;
        this.objet = objet;
        this.quantite = quantite;
    }


    //#region méthodes du service
    public void ajouterObjet(int quantite) { 
        this.quantite += quantite;

    }

    public boolean retirerObjet(int quantite) {
        if (quantite > this.quantite)
            return false;
        this.quantite -= quantite;
        return true;
    }
    //#endregion méthodes du service
}
