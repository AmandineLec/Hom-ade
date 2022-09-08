package fil.rouge;

import jakarta.persistence.*;

@Entity
@Table(name = "objet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Objet {

    //#region Variables
    @Id
    @Column(name = "id_objet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected int types;
    
    //#endregion

    //#region Constructeur

    public Objet(String nom){
        this.nom = nom;
    }
    public Objet(int id){
        this.id = id;
    }

    public Objet(String nom, int id){
        this.nom = nom; 
        this.id = id; 
    }
    //#endregion

    //#region GETTER & SETTER
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getTypes() {
        return types;
    }
    public void setTypes(int types) {
        this.types = types;
    }
    
    
    
    //#endregion 

    

}
