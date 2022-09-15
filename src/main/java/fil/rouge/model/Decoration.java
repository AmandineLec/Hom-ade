package fil.rouge.model;

import javax.persistence.*;

import fil.rouge.Deplacable;

@Entity
@DiscriminatorValue(value = "3")
public class Decoration extends Objet implements Deplacable {
     //#region Variables
     @Column(name = "taille")
     int taille;
     //#endregion
 
     //#region Constructeur
    public Decoration(String nom){
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
