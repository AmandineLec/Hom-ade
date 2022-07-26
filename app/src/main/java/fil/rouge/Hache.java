package fil.rouge;

public class Hache extends Outils{

    //#region Variables
    protected int capacite;
    //#endregion

    //#region Constructeur
    public Hache(String nom){
        super(nom);
    }

    public Hache(int id){
        super(id);
    }
    //#endregion

    //#region GETTER & SETTER
    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    //#endregion

    @Override
    public void equiper(Joueur target){
        // TODO Auto-generated method stub

    }

    @Override
    public void desequipper(Joueur target){
        // TODO Auto-generated method stub

    }

}
