package fil.rouge;

public class Maison {
    protected int id_maison;
    protected int taille; //en mètres carrés
    protected int niveau; // début à 1
    protected int nb_pieces; // début à 1
    protected String id_ressource; // pour récupérer les ressources nécessaires à l'agrandissement
    protected int nb_ressources; // pour définir le nombre de ressources nécéssaires pour agrandir
    protected int id_decoration; // pour récupérer la déco placée dans la maison
    protected int id_meuble; // pour récupérer le meuble placé dans la maison
    protected String etabli; // pour accéder à l'établi lors de la création d'objets

    //#region Constructeurs
    public Maison(){
        this.taille = 9;
        this.niveau = 1;
    }

    public Maison(int nb_pieces){
        this. nb_pieces = nb_pieces;
    }

    public Maison(int taille, int niveau){
        this.taille = taille;
    }
    //#endregion

    //#region GETSET
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNb_pieces() {
        return nb_pieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nb_pieces = nb_pieces;
    }

    public String getId_ressource() {
        return id_ressource;
    }

    public void setId_ressource(String id_ressource) {
        this.id_ressource = id_ressource;
    }

    public int getNb_ressources() {
        return nb_ressources;
    }

    public void setNb_ressources(int nb_ressources) {
        this.nb_ressources = nb_ressources;
    }

    public int getId_decoration() {
        return id_decoration;
    }

    public void setId_decoration(int id_decoration) {
        this.id_decoration = id_decoration;
    }

    public int getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }

    public String getEtabli() {
        return etabli;
    }

    public void setEtabli(String etabli) {
        this.etabli = etabli;
    }
    //#endregion

    //#region Méthodes
    public void levelUp(){

    }

    public void agrandir(){

    }
    
    //#endregion
}
