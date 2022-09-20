package fil.rouge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "objet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
// @NamedQuery(name="Objet.getType", query="SELECT o FROM Objet o WHERE id = :id_element")
public class Objet {

    //#region Variables
    @Id
    @Column(name = "id_objet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected int categorie;

    @OneToMany(mappedBy = "objet")
    protected Set<Recette> recette = new HashSet<Recette>();

    @OneToMany(mappedBy = "objet")
    protected Set<InventaireObjet> inventaireObjets = new HashSet<InventaireObjet>();
    
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


    public void setId(Integer id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getCategorie() {
        return categorie;
    }
    public void setCategorie(int categorie) {
        this.categorie = categorie;
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
