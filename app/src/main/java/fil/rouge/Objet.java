package fil.rouge;

import jakarta.persistence.*;

@Entity
@Table(name = "objet")
public abstract class Objet {

    //#region Variables
    @Id
    @Column(name = "id_objet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "type")
    protected EnumTypeObjet type_objet;

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
    public EnumTypeObjet getType_objet() {
        return type_objet;
    }
    public void setType_objet(EnumTypeObjet type_objet) {
        this.type_objet = type_objet;
    }
    
    
    //#endregion 

    

}
