package fil.rouge.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "inventaire_maison")
public class EquipementMaison { // ce n'est pas une classe(table intermediare) servant d'inventaire à la maison. Ce sont les objets placés dans la maison
    @EmbeddedId
    protected EquipementMaisonkey id;

    @ManyToOne
    @MapsId("idMaison")
    @JoinColumn(name = "id_maison")
    protected Maison maison;

    @ManyToOne
    @MapsId("idObjet")
    @JoinColumn(name ="id_objet")
    protected Objet objet;

    @Column(name ="quantite")
    private int quantite;

    @Column(name = "type")
    private int type;


    public EquipementMaisonkey getId() {
        return id;
    }

    public void setId(EquipementMaisonkey id) {
        this.id = id;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public EquipementMaison(Maison maison, Objet objet, int quantite, int type ){
        this.maison = maison;
        this.objet = objet;
        this.quantite = quantite;
        this.type = type;
    }

    // il s'agit de méthodes visant à modifier l'attribut donc elles n'ont pas être dans les services
    public void ajouterObjet(int quantite) { 
        this.quantite += quantite;

    }

    public boolean retirerObjet(int quantite) {
        if (quantite > this.quantite)
            return false;

        this.quantite -= quantite;
        return true;
    }

}
