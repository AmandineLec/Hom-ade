package fil.rouge.model;

import javax.persistence.*;


@Entity
@Table(name = "recette")
public class Recette {
    //#region Variables
    @EmbeddedId
    protected RecettesKey id;

    @ManyToOne
    @MapsId("idObjet")
    @JoinColumn(name = "id_objet")
    protected Objet objet;

    @ManyToOne
    @MapsId("idRessource")
    @JoinColumn(name = "id_ressource")
    protected Ressource ressource;

    @Column(name = "quantite")
    protected int quantite_necessaire;

    @Column(name = "niveau_requis")
    protected int niveau_requis;
    //#endregion

    //#region Constructeur

    public Recette(){};

    public Recette(Objet objet, Ressource ressource, int quantite_necessaire, int niveau_requis){
        this.objet = objet; 
        this.ressource = ressource;
        this.quantite_necessaire = quantite_necessaire;
        this.niveau_requis = niveau_requis;

        this.id = new RecettesKey(ressource.getId(), objet.getId());
    }
    //#endregion

    //#region GETTER & SETTER
    
    public RecettesKey getId() {
        return id;
    }

    public void setId(RecettesKey id) {
        this.id = id;
    }

    public Objet getObjet() {
        return objet;
    }

    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public int getQuantite_necessaire() {
        return quantite_necessaire;
    }
    public void setQuantite_necessaire(int quantite_necessaire) {
        this.quantite_necessaire = quantite_necessaire;
    }
    public int getNiveau_requis() {
        return niveau_requis;
    }
    public void setNiveau_requis(int niveau_requis) {
        this.niveau_requis = niveau_requis;
    }

    //#endregion

}

