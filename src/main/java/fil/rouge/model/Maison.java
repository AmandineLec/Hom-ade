package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "maison")
public class Maison {
    @Id
    @Column(name = "id_maison")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idMaison;

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

    public Maison(Integer id_maison, int niveau){
        this.niveau = niveau;
        this.idMaison = id_maison; 
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
