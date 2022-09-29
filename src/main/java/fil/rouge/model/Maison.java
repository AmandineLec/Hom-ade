package fil.rouge.model;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "maison")
public class Maison {
    @Id
    @Column(name = "id_maison")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    protected int idMaison;
=======
    protected Integer idMaison;
>>>>>>> Marie

    @Column(name = "niveau")
    protected int niveau; // début à 1

<<<<<<< HEAD
    @Column(name = "nb_pieces")
    protected int nbPieces; // début à 1
=======
    // @Column(name = "nb_pieces")
    // protected int nb_pieces; // début à 1
>>>>>>> Marie

    @OneToMany(mappedBy = "maison")
    protected Set<Personnage> personnages = new HashSet<Personnage>();

<<<<<<< HEAD
    @OneToMany(mappedBy = "maison") // grâce à la table inventaire_maison : accés aux maisons equipées de l'objet
    protected Set<EquipementMaison> maisonEquipees = new HashSet<EquipementMaison>();


=======
>>>>>>> Marie
    //#region Constructeurs
    public Maison(){
        this.niveau = 1;
    }
<<<<<<< HEAD
=======

    public Maison(Integer id_maison, int niveau){
        this.niveau = niveau;
        this.idMaison = id_maison; 
    }

>>>>>>> Marie
    //#endregion


    //#region GETSET
    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

<<<<<<< HEAD
    public int getNb_pieces() {
        return nbPieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nbPieces = nb_pieces;
    }


=======
>>>>>>> Marie
    public int getId_maison() {
        return idMaison;
    }

<<<<<<< HEAD
    public Set<EquipementMaison> getEquipementsMaison() {
        return maisonEquipees;
    }


    public void setEquipementsMaison(Set<EquipementMaison> maisonEquipees) {
        this.maisonEquipees = maisonEquipees;
    }
=======
    public void setId_maison(int idMaison) {
        this.idMaison = idMaison;
    }

>>>>>>> Marie
}
    
    //#endregion

