package fil.rouge.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD:app/src/main/java/fil/rouge/Objet.java
import fil.rouge.utils.DBManager;
import jakarta.persistence.*;
// import org.hibernate.Session;
=======
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
>>>>>>> Yannick:src/main/java/fil/rouge/model/Objet.java

@Entity
@Table(name = "objet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
@NamedQuery(name="Objet.getType", query="SELECT o FROM Objet o WHERE id = :id_element")
public class Objet {

    //#region Variables
    @Id
    @Column(name = "id_objet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
<<<<<<< HEAD:app/src/main/java/fil/rouge/Objet.java
    protected Integer types;

    // @Column(name="type")
    // protected Integer type;

    @OneToMany(mappedBy = "objet" )
    protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();
=======
    protected int categorie;
>>>>>>> Yannick:src/main/java/fil/rouge/model/Objet.java

    @OneToMany(mappedBy = "objet")
    protected Set<Recettes> recette = new HashSet<Recettes>();

    @ManyToMany(mappedBy = "objets")
    protected Set<ObjetRecoltable> objets = new HashSet<ObjetRecoltable>();
    
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
    public Objet(){
        
    }
    //#endregion

    //#region GETTER & SETTER
    public Integer getId() {
        return id;
    }
    public String getNom() {
        return nom;    }

    // public Integer getType() {
    //     return type;
    // }
    public int getTypes() {
        return types;
    }

    // public void setType(Integer type) {
    //     this.type = type;
    // }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
<<<<<<< HEAD:app/src/main/java/fil/rouge/Objet.java
    public void setTypes(Integer types) {
        this.types = types;
=======
    public int getCategorie() {
        return categorie;
    }
    public void setCategorie(int categorie) {
        this.categorie = categorie;
>>>>>>> Yannick:src/main/java/fil/rouge/model/Objet.java
    }
    public Set<InventaireObjet> getInventaireObjets() {
        return inventaireObjets;
    }
    public void addInventaireObjets(InventaireObjet inventaireObjet) {
        inventaireObjets.add(inventaireObjet);
    }   
    
    
    //#endregion 

    //#region Method

    // public void creerObjet(int id_element){
    //     DBManager.open();
    //     TypedQuery<Objet> myQuery = DBManager.session.createNamedQuery("Objet.getType", Objet.class);
    //     List<Objet> objets = myQuery.getResultList();
    //     myQuery.setParameter("id_element", id_element);
    //     objets.forEach((objet)->{
    //         System.out.println(objet.getNom());
    //     });



                // if(resultat.next()){
                //     if(resultat.getInt("o.type") == EnumTypeObjet.Outils.getValue()){
                //         objet = new Outils(id_element);
                //     }
                //     else if(resultat.getInt("o.type") == EnumTypeObjet.Meubles.getValue()){
                //         objet = new Meubles(id_element);
                //     }
                //     else if(resultat.getInt("o.type") == EnumTypeObjet.Decoration.getValue()){
                //         objet = new Decoration(id_element);
                //     }
    
                // }
            

    //#endregion
    

}
