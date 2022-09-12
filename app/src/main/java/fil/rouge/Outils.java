package fil.rouge;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import fil.rouge.utils.DBManager;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "1")
public class Outils extends Objet implements IEquipable {

        //#region Variables
        @Column(name = "resistance")
        protected int resistance;

        @Column(name = "capacite")
        protected int capacite;

        @ManyToMany(mappedBy = "outils")
        protected Set<ObjetRecoltable> ObjetRecoltables = new HashSet<ObjetRecoltable>();

        @OneToMany(mappedBy = "outil")
        protected Set<Personnage> personnages = new HashSet<Personnage>();
         //#endregion

        //#region Constructeur
        public Outils(String nom) {
            super(nom);
        }

        public Outils(int id){
            super("");
            try {
                ResultSet resultat = DBManager.query("SELECT * FROM objet WHERE id_objet = "+id);
                if(resultat.next()){
                    this.nom = resultat.getString("nom");
                    this.types = resultat.getInt("type");
                    // this.resistance = resultat.getInt("resistance");
                    // this.capacite = resultat.getInt("capacite");
                    this.id = id;
                    }
                }
                catch (SQLException ex) {
                    // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }
        }
        //#endregion

        //#region GETTER & SETTER
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
        //#endregion


        //#region METHOD

        public boolean equiper(Personnage target){
            if(target.getOutil()!=null){
                target.ajouterObjet(target.getOutil(), 1);
                
            }
            if(target.retirerObjet(this, 1)){
                target.setOutil(this);
                return true;
            }
            return false;
        }
        public boolean desequipper(Personnage target){
            if(target.getOutil()==this){
                target.ajouterObjet(this, 1);
                target.setOutil(null);
                return true;
            }
            return false;
        }
        //#endregion

        

        

}
