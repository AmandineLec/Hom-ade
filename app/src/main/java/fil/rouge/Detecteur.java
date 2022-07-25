package fil.rouge;

public class Detecteur extends Outils{

    //#region Variables
    protected int capacite;
    //#endregion

    //#region Constructeur
    public Detecteur(String nom){
        super(nom);
    }
    public Detecteur(int id){
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

    
}
