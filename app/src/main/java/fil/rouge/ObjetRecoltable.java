package fil.rouge;

public class ObjetRecoltable extends Objet {
    protected int id_outil; // id de l'outil à utiliser pour récolter
    protected int nb_ressources; // nombre de ressources que cela va donner
    protected Ressource type;  // type de la ressource que cela va donner
    protected int quantite;
    protected String sorte;
    protected int difficulte;
    //#region Constructeurs

    public ObjetRecoltable(String nom){
        super(nom);
    }

    public ObjetRecoltable(String nom, int id){
        super(nom, id);
    }

    public ObjetRecoltable(String nom, int nb_ressources, Ressource type){
        super(nom);
        this.nb_ressources = nb_ressources;
        this.type = type;
    }
    //#endregion


    //#region GETSET
    public int getId_outil() {
        return id_outil;
    }

    public void setId_outil(int id_outil) {
        this.id_outil = id_outil;
    }

    public int getNb_ressources() {
        return nb_ressources;
    }

    public void setNb_ressources(int nb_ressources) {
        this.nb_ressources = nb_ressources;
    }

    public Ressource getType() {
        return type;
    }
    

    public void setType(Ressource type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getSorte() {
        return sorte;
    }

    public void setSorte(String sorte) {
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
    public boolean ramasser(Joueur joueur){
        joueur.ajouterObjet(this, 1);
        return true;
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
        // si difficulte == 1 alors this.quantite = rand(1, 3)
        return this.quantite;
    }

    public boolean recolter(Joueur joueur, Outils outil){
        if (joueur.getInventoryressource().containsKey(outil.getId())){
            int nombre = outil.getCapacite();
            joueur.ajouterObjet(this.type, nombre);
            return true;
        }
        return false;

// si outil dispo dans inventaire alors on utilise pour extraire ressource selon la capacité (+ on retire de la résistance et si resistance >= 0 alors on retire l'objet de l'inventaire)
// puis ramasser
    }






}
