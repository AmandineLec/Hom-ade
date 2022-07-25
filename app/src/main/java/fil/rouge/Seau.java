package fil.rouge;

public class Seau extends Objet implements Equipable {
    
    //#region Variables
    protected int capacite;
    protected int resistance;
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
    public int getResistance() {
        return resistance;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    //#endregion

    //#region METHOD
    public void equiper(){

    }
    public void desequipper(){
        
    }
    //#endregion
    
}
