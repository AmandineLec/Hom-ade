package fil.rouge;

public class Seau extends Outils{
    
    //#region Variables
    protected int capacite;
    //#endregion

    //#region Constructeur
    public Seau(String nom){
        super(nom);
    }
    public Seau(int id){
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

    //#region METHOD
    @Override
    public void equiper(Joueur target){

    }
    @Override
    public void desequipper(Joueur target){
        
    }
    //#endregion
    
}
