package fil.rouge.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import fil.rouge.Deplacable;

@Entity
@DiscriminatorValue(value = "2")
public class Meuble extends Objet implements Deplacable{

    //#region Variables
    @Column(name = "taille")
    int taille;
    //#endregion

    //#region Constructeur
    public Meuble(String nom){
        super(nom);
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
