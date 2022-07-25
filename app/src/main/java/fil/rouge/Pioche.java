package fil.rouge;

public class Pioche extends Objet implements Equipable {
    
    //#region Variables
    protected int capacite;
    protected int resistance;
    //#endregion

    //#region Constructeur
    public Pioche(String nom){
        super(nom);
    }
    public Pioche(int id){
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
