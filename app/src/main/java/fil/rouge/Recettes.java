package fil.rouge;
import java.util.HashMap;
import java.sql.*;
import fil.rouge.utils.DBManager;

public class Recettes {
    //#region Variables
    protected String nom;
    protected HashMap<Ressource, Integer> quantite; 
    protected int quantite_necessaire; 
    protected int id_element; 

    //#endregion

    //#region Constructeur
    public Recettes(String nom, int id_element){
        this.nom = nom;
        try {
            ResultSet resultat = DBManager.query("SELECT id_ressource, quantite, id_objet FROM objet WHERE id_objet = "+ id_element);
            if(resultat.next()){
                this.quantite = new HashMap<Ressource, Integer>();
                this.id_element = resultat.getInt("id_objet");
                while(resultat.next()){
                    Ressource ressourceobjet = new Ressource(resultat.getInt("id_ressource"));
                    ressourceobjet.get(resultat.getInt("id_ressource"));
                    this.quantite_necessaire = resultat.getInt("quantite");
                    quantite.put(ressourceobjet, quantite_necessaire);                    
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
    //#endregion

    //#region GETTER & SETTER

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }    
    public HashMap<Ressource, Integer> getQuantite() {
        return quantite;
    }
    public void setQuantite(HashMap<Ressource, Integer> quantite) {
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
    //#endregion
    
    //#region METHOD
    public boolean fusionnerRessource(Joueur joueur){


        try {
            ResultSet resultat = DBManager.query("SELECT re.id_objet, re.id_ressource, re.quantite, re.niveau_requis, o.type, i.  id_ressource, i.quantite, m.niveau"+
                                                "FROM recette as re"+
                                                "INNER JOIN objet as o ON o.id_objet = re.id_objet"+
                                                "INNER JOIN ressource as r ON r.id_ressource = re.id_ressource"+
                                                "INNER JOIN inventaire as i ON i.id_ressource = r.id_ressource"+
                                                "INNER JOIN personnage as p ON p.id_personnage = i.id_presonnage"+
                                                "INNER JOIN maison as m ON m.id_maison = p.id_maison"
                                                +"WHERE re.id_element = o.id_element");
            if(resultat.next()){
                    if(resultat.getInt("re.id_ressource")==(resultat.getInt("i.id_ressource"))&& resultat.getInt("i.quantite")>=resultat.getInt("re.quantite")&& resultat.getInt("re.niveau_requis")==resultat.getInt("m.niveau")){
                        if(resultat.getString("e.type").equalsIgnoreCase("outils")){
                            Outils outil = new Outils(resultat.getInt("o.id_element")); 
                            joueur.ajouterObjet(outil, 1);
                            return true;
                        }
    
                        else if(resultat.getString("e.type").equalsIgnoreCase("meuble")){
                            Meubles meuble = new Meubles(resultat.getInt("o.id_element"));
                            joueur.ajouterObjet(meuble, 1); 
                            return true; 
                        }
                        else if(resultat.getString("e.type").equalsIgnoreCase("décoration")){
                            Decoration deco = new Decoration(resultat.getInt("o.id_element"));
                            joueur.ajouterObjet(deco, 1); 
                            return true; 
                        }
                    }
                }
            }
            catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            return false; 

    }


    //#endregion
}
