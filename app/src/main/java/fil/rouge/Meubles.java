package fil.rouge;

public class Meubles extends Objet implements Deplacable{

    //#region Variables
    int taille;
    //#endregion

    //#region Constructeur
    public Meubles(String nom){
        super(nom);
    }

    public Meubles(int id){
        super(id);
    }
    //#endregion

    //#region GETTER & SETTER
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    //#endregion

    //#region METHOD

    public void deplacer(){

    }

    public void tourner(){

    }
    //#endregion

}
