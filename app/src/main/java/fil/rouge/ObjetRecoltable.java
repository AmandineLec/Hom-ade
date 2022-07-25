package fil.rouge;

public class ObjetRecoltable {
    protected int id_recoltable; // id en BDD
    protected String nom; // nom de l'objet à récolter
    protected int id_outil; // id de l'outil à utiliser pour récolter
    protected int nb_ressources; // nombre de ressources que cela va donner
    protected Ressource type; // type de la ressource que cela va donner


    //#region Constructeurs
    public ObjetRecoltable(){
    }

    public ObjetRecoltable(String nom){
        this.nom = nom;
    }

    public ObjetRecoltable(String nom, int nb_ressources, Ressource type){
        this.nom = nom;
        this.nb_ressources = nb_ressources;
        this.type = type;
    }
    //#endregion


    //#region GETSET
    public int getId_recoltable() {
        return id_recoltable;
    }

    public void setId_recoltable(int id_recoltable) {
        this.id_recoltable = id_recoltable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

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
    //#endregion

    //#region Méthodes
    public boolean ramasser(){
        return false;
    }

    public void recolter(Outils outil){
// si outil dispo dans inventaire alors on utilise pour extraire ressource selon la capacité (+ on retire de la résistance et si resistance >= 0 alors on retire l'objet de l'inventaire)
// puis ramasser
    }

}
