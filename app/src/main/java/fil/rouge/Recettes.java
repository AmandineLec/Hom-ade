package fil.rouge;
import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.Session;

@Embeddable
class RecettesKey implements Serializable {
    @Column(name = "id_objet")
    protected Integer idObjet;

    @Column(name = "id_ressource")
    protected Integer idRessource;


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
@Entity
@Table(name = "recette")
class Recettes {
    //#region Variables

    Session session; 
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
    protected Integer quantite_necessaire;

    @Column(name = "niveau_requis")
    protected Integer niveau_requis;

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

    public Integer getQuantite_necessaire() {
        return quantite_necessaire;
    }
    public void setQuantite_necessaire(Integer quantite_necessaire) {
        this.quantite_necessaire = quantite_necessaire;
    }
    public Integer getNiveau_requis() {
        return niveau_requis;
    }
    public void setNiveau_requis(Integer niveau_requis) {
        this.niveau_requis = niveau_requis;
    }

    //#endregion

    //#region METHOD

    // //Méthode de création d'objet en fonction de son type  et de l'id élément de la recette
    //

    // //Méthode de création d'objet à partir de recette
    // public boolean fusionnerRessource(Joueur joueur, Objet objet){

    //     boolean craftable = true;

    //     //On regarde déjà si la maison du joueur a le bon niveau pour pouvoir créer cette recette
    //     if(this.getNiveau_requis()==joueur.getMaison().getNiveau()) {

    //         //On crée un itérateur qui va nous permette de parcourir la hashmap

    //         Iterator<Entry<Integer, Integer> > iterator_recette = this.getQuantite().entrySet().iterator(); //Itérateur de la hashmap des recettes

    //         //On commence une boucle, qui va nous permettre de vérifier si les ressources nécessaires à la création de l'objet sont présentes dans l'inventaire, en bonne quantité.
    //         //Tant qu'il y a des ressources dans la recette
    //         while(iterator_recette.hasNext()){

    //             //On recrée une carte des éléments que l'on récupère avec l'itérateur et on va chercher sa clef
    //             Map.Entry<Integer, Integer> entry_recette = (Map.Entry<Integer, Integer>)iterator_recette.next();
    //             int id_ressource = entry_recette.getKey();

    //             //On compare les valeurs associés à la clef id_ressource dans les deux hashmap (recette et inventaire) si le nombre de ressource demandé dans la recette est
    //             //supérieur au nombre de ressource présentes dans l'inventaire ou si la clef id_ressource n'est pas présente dans l'inventaire (et donc renvoi null)
    //             //La variable craftable passe à false.
    //             if(joueur.getInventoryressource().get(id_ressource)==null ||
    //             this.getQuantite().get(id_ressource)>joueur.getInventoryressource().get(id_ressource)){
    //                 craftable = false;
    //             }
    //         }
    //         //Si on possède bien les ressources nécessaires, on enlève ces ressources de notre inventaire
    //         if(craftable){

    //             Iterator<Entry<Integer, Integer> > i_recette = this.getQuantite().entrySet().iterator(); //Itérateur de la hashmap des recettes

    //             while(i_recette.hasNext()){

    //                 //On recrée une carte des éléments que l'on récupère avec l'itérateur et on va chercher sa clef
    //                 Map.Entry<Integer, Integer> entry_recettes = (Map.Entry<Integer, Integer>)i_recette.next();
    //                 int id_ressources = entry_recettes.getKey();

    //                 //On stocke la nouvelle valeur dans une variable quantité et on effectue le calcul : On soustraie la quantité nécessaire à la réalisation de la recette
    //                 //à la quantité de ressource présente dans l'inventaire
    //                 int quantite = joueur.getInventoryressource().get(id_ressources) - this.getQuantite().get(id_ressources);

    //                 //Et on remplace l'ancienne quantité par la nouvelle quantité dans l'inventaire.
    //                 joueur.getInventoryressource().replace(id_ressources, quantite);

    //                 //On crée alors un nouvel objet grâce à son id, et en fonction de son type
    //                 objet = this.creerObjet(this.getId_element());

    //                 //Finalement, on ajoute l'objet à l'inventaire du joueur.
    //                 joueur.ajouterObjet(objet, 1);
    //             }
    //         }
    //     }
    //     return craftable;
    // }
    //#endregion
}
