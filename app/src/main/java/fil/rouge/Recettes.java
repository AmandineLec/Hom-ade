package fil.rouge;
import java.util.HashMap;
import java.sql.*;
import fil.rouge.utils.DBManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Recettes {
    //#region Variables
    protected String nom;
    protected HashMap<Integer, Integer> quantite; 
    protected int quantite_necessaire; 
    protected int id_element; 
    protected int niveau_requis; 
    protected int  id_ressource;

    //#endregion

    //#region Constructeur
    public Recettes(String nom, int id_element){
        this.nom = nom;
        try {
            ResultSet resultat = DBManager.query("SELECT id_ressource, quantite, id_objet, niveau_requis FROM objet WHERE id_objet = "+ id_element);
            if(resultat.next()){
                this.quantite = new HashMap<Integer, Integer>();
                this.id_element = resultat.getInt("id_objet");
                this.niveau_requis = resultat.getInt("niveau_requis");
                while(resultat.next()){
                    this.id_ressource = resultat.getInt("id_ressource");
                    this.quantite_necessaire = resultat.getInt("quantite");
                    quantite.put(id_ressource, quantite_necessaire);                    
                    }
                }
            }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Recettes(int id_element){
        this.id_element = id_element;
    }
    //#endregion

    //#region GETTER & SETTER

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }    
    public HashMap<Integer, Integer> getQuantite() {
        return quantite;
    }
    public void setQuantite(HashMap<Integer, Integer> quantite) {
        this.quantite = quantite;
    }
    public int getId_element() {
        return id_element;
    }
    public void setId_element(int id_element) {
        this.id_element = id_element;
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
    
    //#region METHOD

    //Méthode de création d'objet en fonction de son type  et de l'id élément de la recette
    public Objet creerObjet(int id_element){
        Objet objet = null; 
        try {
            ResultSet resultat = DBManager.query("SELECT type FROM objet INNER JOIN recette ON id_objet = "+id_element);
            if(resultat.next()){
                if(resultat.getInt("type") == EnumTypeObjet.Outils.getValue()){
                    objet = new Outils(id_element);
                }
                else if(resultat.getInt("type") == EnumTypeObjet.Meubles.getValue()){
                    objet = new Meubles(id_element);
                }
                else if(resultat.getInt("type") == EnumTypeObjet.Decoration.getValue()){
                    objet = new Decoration(id_element);
                }

            }
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return objet;
    }

    //Méthode de création d'objet à partir de recette
    public boolean fusionnerRessource(Joueur joueur, Objet objet){

        boolean craftable = true; 

        //On regarde déjà si la maison du joueur a le bon niveau pour pouvoir créer cette recette
        if(this.getNiveau_requis()==joueur.getMaison().getNiveau()) {

            //On crée un itérateur qui va nous permette de parcourir la hashmap

            Iterator<Entry<Integer, Integer> > iterator_recette = this.getQuantite().entrySet().iterator(); //Itérateur de la hashmap des recettes

            //On commence une boucle, qui va nous permettre de vérifier si les ressources nécessaires à la création de l'objet sont présentes dans l'inventaire, en bonne quantité. 
            //Tant qu'il y a des ressources dans la recette
            while(iterator_recette.hasNext()){

                //On recrée une carte des éléments que l'on récupère avec l'itérateur et on va chercher sa clef
                Map.Entry<Integer, Integer> entry_recette = (Map.Entry<Integer, Integer>)iterator_recette.next();
                int id_ressource = entry_recette.getKey();

                //On compare les valeurs associés à la clef id_ressource dans les deux hashmap (recette et inventaire) si le nombre de ressource demandé dans la recette est 
                //supérieur au nombre de ressource présentes dans l'inventaire ou si la clef id_ressource n'est pas présente dans l'inventaire (et donc renvoi null)
                //La variable craftable passe à false. 
                if(joueur.getInventoryressource().get(id_ressource)==null || 
                this.getQuantite().get(id_ressource)>joueur.getInventoryressource().get(id_ressource)){
                    craftable = false; 
                }
            } 
            //Si on possède bien les ressources nécessaires, on enlève ces ressources de notre inventaire
            if(craftable){

                Iterator<Entry<Integer, Integer> > i_recette = this.getQuantite().entrySet().iterator(); //Itérateur de la hashmap des recettes
                
                while(i_recette.hasNext()){

                    //On recrée une carte des éléments que l'on récupère avec l'itérateur et on va chercher sa clef
                    Map.Entry<Integer, Integer> entry_recettes = (Map.Entry<Integer, Integer>)i_recette.next();
                    int id_ressources = entry_recettes.getKey();

                    //On stocke la nouvelle valeur dans une variable quantité et on effectue le calcul : On soustraie la quantité nécessaire à la réalisation de la recette 
                    //à la quantité de ressource présente dans l'inventaire
                    int quantite = joueur.getInventoryressource().get(id_ressources) - this.getQuantite().get(id_ressources);   

                    //Et on remplace l'ancienne quantité par la nouvelle quantité dans l'inventaire.                      
                    joueur.getInventoryressource().replace(id_ressources, quantite);

                    //On crée alors un nouvel objet grâce à son id, et en fonction de son type
                    objet = this.creerObjet(this.id_element);

                    //Finalement, on ajoute l'objet à l'inventaire du joueur. 
                    joueur.ajouterObjet(objet, 1);
                }
            }
        }
        return craftable; 
    }
    //#endregion
}
