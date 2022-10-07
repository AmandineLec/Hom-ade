package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import fil.rouge.inter.IEquipable;

@Entity
@DiscriminatorValue(value = "1")
public class Outil extends Objet implements IEquipable {

    // #region Variables
    @Column(name = "resistance")
    protected int resistance;

    @Column(name = "capacite")
    protected int capacite;

    @ManyToMany(mappedBy = "outils")
    protected Set<ObjetRecoltable> ObjetRecoltables = new HashSet<ObjetRecoltable>();

    @OneToMany(mappedBy = "outil")
    protected Set<Personnage> personnages = new HashSet<Personnage>();
    // #endregion

    // #region Constructeur
    public Outil(String nom) {
        super(nom);
    }

    public Outil(Integer id) {
        super(id);
    }

    public Outil() {
    }
    // #endregion

    // #region GETTER & SETTER
    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Set<ObjetRecoltable> getObjetRecoltables() {
        return ObjetRecoltables;
    }

    public void addObjetRecoltables(ObjetRecoltable objetRecoltable) {
        ObjetRecoltables.add(objetRecoltable);
    }
    // #endregion

    // #region METHOD

    public boolean equiper(Personnage target) {
        // if (target.getOutil() != null) {
        //     target.ajouterObjet(target.getOutil(), 1);

        // }
        // if (target.retirerObjet(this, 1)) {
        //     target.setOutil(this);
        //     return true;
        // }
        return false;
    }

    public boolean desequipper(Personnage target) {
        // if (target.getOutil() == this) {
        //     target.ajouterObjet(this, 1);
        //     target.setOutil(null);
        //     return true;
        // }
        return false;
    }

    // #endregion

}
