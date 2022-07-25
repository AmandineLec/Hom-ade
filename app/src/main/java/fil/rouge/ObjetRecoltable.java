package fil.rouge;

public abstract class ObjetRecoltable {
    protected int id_recoltable; // id en BDD
    protected String nom; // nom de l'objet à récolter
    protected int id_outil; // id de l'outil à utiliser pour récolter
    protected int nb_ressources; // nombre de ressources que cela va donner
    protected int id_ressource; // type de la ressource que cela va donner


    //#region Constructeurs
    public ObjetRecoltable(){
    }

    public ObjetRecoltable(String nom){
        this.nom = nom;
    }

    public ObjetRecoltable(String nom, int nb_ressources, int id_ressource){
        this.nom = nom;
        this.nb_ressources = nb_ressources;
        this.id_ressource = id_ressource;
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

    public int getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(int id_ressource) {
        this.id_ressource = id_ressource;
    }
    //#endregion

    //#region Méthodes

    public void recolte(int id_outil){

    }

    public boolean ramasser(){
        return false;
    }
}
