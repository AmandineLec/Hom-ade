package fil.rouge.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EquipementMaisonkey implements Serializable { // obtenir la clé primaire pour créer la classe inventaireMaison
    
    @Column(name = "id_maison")
    protected Integer idMaison;

    @Column(name = "id_objet")
    protected Integer idObjet;

    public Integer getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(Integer idMaison) {
        this.idMaison = idMaison;
    }

    public Integer getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(Integer idObjet) {
        this.idObjet = idObjet;
    }

    public EquipementMaisonkey(){}

    // public InventaireMaisonKey(Integer idMaison, Integer dObjet){
    //     this.idMaison = idMaison;
    //     this.idObjet = idObjet;
    // }




    

}

