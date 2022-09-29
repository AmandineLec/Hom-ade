package fil.rouge.model;


import javax.persistence.*;

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

    public InventaireObjet(){};

    public InventaireObjetKey getId(){
        return this.id;
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

    public InventaireObjet(Personnage personnage, Objet objet, int quantite) {
        this.personnage = personnage;
        this.objet = objet;
        this.quantite = quantite;
        this.id = new InventaireObjetKey(personnage.getIdPersonnage(), objet.getId());
    }

<<<<<<< HEAD

    //#region méthodes du service
    public void ajouterObjet(int quantite) { 
        this.quantite += quantite;

=======
    public void ajouterObjet(int quantity) {
        this.quantite += quantity;
>>>>>>> Marie
    }

    public boolean retirerObjet(int quantite) {
        if (quantite > this.quantite)
            return false;
        this.quantite -= quantite;
        return true;
    }
    //#endregion méthodes du service
}

