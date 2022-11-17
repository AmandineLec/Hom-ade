package fil.rouge.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fil.rouge.serializer.InventaireRessourceSerializer;


@Entity
@JsonSerialize(using = InventaireRessourceSerializer.class)
@Table(name = "inventaire_ressources")
public class InventaireRessource {
    
    @EmbeddedId
    protected InventaireRessourceKey id;

    @ManyToOne
    @MapsId("idPersonnage")
    @JoinColumn(name = "id_personnage")
    @JsonBackReference
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

    @Override
    public String toString() {
        return "InventaireRessource [id=" + id + ", personnage=" + personnage + ", ressource=" + ressource
                + ", quantite=" + quantite + "]";
    }

    
}

