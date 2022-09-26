package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "maison")
public class Maison {
    @Id
    @Column(name = "id_maison")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idMaison;

    @Column(name = "niveau")
    protected int niveau; // début à 1

    // @Column(name = "nb_pieces")
    // protected int nb_pieces; // début à 1

    @OneToMany(mappedBy = "maison")
    protected Set<Personnage> personnages = new HashSet<Personnage>();

    //#region Constructeurs
    public Maison(){
        this.niveau = 1;
    }

    //#endregion

    //#region GETSET
    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getId_maison() {
        return idMaison;
    }

    public void setId_maison(int idMaison) {
        this.idMaison = idMaison;
    }

}
