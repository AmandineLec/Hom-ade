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
        this.niveau = 1;
    }

    //#endregion

    //#region GETSET

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

    public int getId_maison() {
        return id_maison;
    }

    public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public Pieces getPiece() {
        return piece;
    }

    public void setPiece(Pieces piece) {
        this.piece = piece;
    }

    //#endregion

    //#region Méthodes
    public void levelUp(Pieces piece){
        this.setNiveau(this.getNiveau()+1);
        if (this.getNiveau()>=1 && this.getNiveau()<=3){
            this.ajoutPiece(piece);
        }
        else if(this.getNiveau()>3 && this.getNiveau()%2==0){
            this.ajoutPiece(piece);
        }
        else{
            piece.agrandir(1);
        }

    }

    public void ajoutPiece(Pieces piece){
        this.setNb_pieces(this.getNb_pieces()+1);
        this.piece = piece;
    }

    //#endregion
}
