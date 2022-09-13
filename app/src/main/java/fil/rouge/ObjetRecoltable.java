package fil.rouge;

import java.sql.*;

import fil.rouge.utils.DBManager;

public class ObjetRecoltable extends Objet {
    protected Outils outil; // id de l'outil à utiliser pour récolter
    protected Ressource typeRessource; // type de la ressource que cela va donner
    protected int quantite; // nombre de ressources que ca donne
    protected int sorte; // distingue les sortes de bois, sortes de pierres, sortes de métaux, etc
    protected int difficulte; // difficulté d'accès à la ressource, définit le rendement.
    protected int clic;
    protected int niveauRequis;

    //#region Constructeurs

    public ObjetRecoltable(String nom){
        super(nom);
    }

    public ObjetRecoltable(String nom, int id){
        super(nom, id);
    }

    public ObjetRecoltable(Ressource type, String nom, int sorte){
        super(nom);
        this.typeRessource = type;
        this.sorte = sorte;
    }

    public ObjetRecoltable(int id){
        super("");
            try {
                ResultSet resultat = DBManager.query("SELECT * FROM element_recoltable WHERE id_element_recoltable = "+id);
                if(resultat.next()){
                    this.nom = resultat.getString("nom");
                    this.id = id;
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


    //#region GETSET
    public Outils getOutil() {
        return outil;
    }

    public void setOutil(Outils outil) {
        this.outil = outil;
    }

    public Ressource getTypeRessource() {
        return typeRessource;
    }
    

    public void setTypeRessource(Ressource type) {
        this.typeRessource = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getSorte() {
        return sorte;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    //#endregion

    //#region Méthodes
    public boolean ramasser(Joueur joueur,int nombre){
        if (joueur.ajouterRessource(this.getTypeRessource(), nombre)){
            return true;
        }
        return false;
    }

    public int rand(int min, int max){
        int rand = min + (int)(Math.random()*((max - min)+1));
        return rand;
    }

    public int difficulte(String sorte){
        if(sorte.equals("roseau") || sorte.equals("sardine") || sorte.equals("fer") || sorte.equals("brique") || sorte.equals("champignon") || sorte.equals("mare")){
            this.difficulte = 1;
        }
        if(sorte.equals("bambou") || sorte.equals("carpe")|| sorte.equals("cuivre") || sorte.equals("granit") || sorte.equals("coton") || sorte.equals("rivière")){
            this.difficulte = 2;
        }
        if(sorte.equals("chêne") || sorte.equals("truite") || sorte.equals("aimant") || sorte.equals("marbre") || sorte.equals("lin") || sorte.equals("source")){
            this.difficulte = 3;
        }
        if(sorte.equals("ébène ") || sorte.equals("brochet") || sorte.equals("or") || sorte.equals("schiste") || sorte.equals("orties") || sorte.equals("pluie")){
            this.difficulte = 4;
        }
        if(sorte.equals("séquoïa") || sorte.equals("requin") || sorte.equals("titane") || sorte.equals("diamant") || sorte.equals("rosier") || sorte.equals("seve")){
            this.difficulte = 5;
        }
        return this.difficulte;
    }

    public int quantiteProduite(){
        if(this.difficulte == 1)
            this.quantite = this.rand(1, 3);

        else if(this.difficulte == 2)
            this.quantite = this.rand(1, 5);

        else if(this.difficulte == 3)
            this.quantite = this.rand(2, 6);

        else if(this.difficulte == 4)
            this.quantite = this.rand(2, 7);

        else if(this.difficulte == 5)
            this.quantite = this.rand(3, 8);

        return this.quantite;
    }

    public boolean recolter(Joueur joueur, Outils outil){
        if (joueur.getOutils()==this.getOutil()){
            int nombre = outil.getCapacite() * this.quantiteProduite();
            this.ramasser(joueur, nombre);
            return true;
        }
        return false;
    
        // si outil dispo équipé alors on utilise pour extraire ressource selon la capacité outil et objet recoltable (+ on retire de la résistance et si resistance >= 0 alors on retire l'objet de l'inventaire => a faire plus tard)
        // puis ramasser
        
    }


    public void resistance(){
        if(this.outil.getCapacite() > this.niveauRequis || this.outil.getCapacite() == this.niveauRequis){
            this.clic = 1;
        }
        else{
            this.clic = this.niveauRequis - this.outil.getCapacite();
        }
    }



}
