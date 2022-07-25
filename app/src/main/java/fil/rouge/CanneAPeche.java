package fil.rouge;

public class CanneAPeche extends Objet implements Equipable {

    //#region Variables
    protected int resistance;
    //#endregion 

    //#region Constructeur

    public CanneAPeche(String nom){
        super(nom);
    }

    public CanneAPeche(int id){
        super(id);
    }

    //#endregion

    //#region GETTER & SETTER

    
    public int getResistance() {
        return resistance;
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
