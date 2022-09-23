package fil.rouge.model;
import java.util.ArrayList;

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

    @Column(name = "nb_pieces")
    protected int nbPieces; // début à 1

    @OneToMany(mappedBy = "maison")
    protected Set<Personnage> personnages = new HashSet<Personnage>();

    @OneToMany(mappedBy = "maison") // grâce à la table inventaire_maison : accés aux maisons equipées de l'objet
    protected Set<EquipementMaison> maisonEquipees = new HashSet<EquipementMaison>();


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

    public int getNb_pieces() {
        return nbPieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nbPieces = nb_pieces;
    }


    public int getId_maison() {
        return idMaison;
    }

    public Set<EquipementMaison> getEquipementsMaison() {
        return maisonEquipees;
    }


    public void setEquipementsMaison(Set<EquipementMaison> maisonEquipees) {
        this.maisonEquipees = maisonEquipees;
    }
}
    
    //#endregion

