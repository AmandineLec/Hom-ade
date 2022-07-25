package fil.rouge;

public class Maison {
    protected int id_maison;
    protected int niveau; // début à 1
    protected int nb_pieces; // début à 1
    protected String id_ressource; // pour récupérer les ressources nécessaires à l'agrandissement
    protected int nb_ressources; // pour définir le nombre de ressources nécéssaires pour agrandir
    protected String etabli; // pour accéder à l'établi lors de la création d'objets
    protected Pieces piece; // pour accéder à la pièce

    //#region Constructeurs
    public Maison(){
        this.niveau = 1;
    }

    public Maison(int nb_pieces){
        this. nb_pieces = nb_pieces;
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


    public String getEtabli() {
        return etabli;
    }

    public void setEtabli(String etabli) {
        this.etabli = 
        etabli;
    }

    public Pieces getPiece() {
        return piece;
    }

    public void setPiece(Pieces piece) {
        this.piece = piece;
    }
    //#endregion

    //#region Méthodes
    public void levelUp(){
        // max 15, ajout 1 niveau + agrandir

    }

    public void ajoutpieces(Pieces piece){
        // gerer ajout dans bdd

    }


    
    //#endregion
}
