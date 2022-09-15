package fil.rouge.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "element_recoltable")
public class ObjetRecoltable {
    @Id
    @Column(name = "id_element_recoltable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    protected Integer id;
=======
    protected int idElementRecoltable;
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected Integer categorie;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "objet_element_recoltable",
        joinColumns = @JoinColumn(name = "id_element_recoltable"),
        inverseJoinColumns = @JoinColumn(name = "id_objet")
    )
<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    protected Set<Objet> objets = new HashSet<Objet>(); // id de l'outil à utiliser pour récolter
=======
    protected Set<Outil> outils = new HashSet<Outil>(); // id de l'outil à utiliser pour récolter
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java

    @OneToMany(mappedBy = "objetRecoltable")
    protected Set<RessourcesRecoltees> ressourcesRecoltees = new HashSet<RessourcesRecoltees>();
    
    @Column(name = "niveau_requis")
    protected int niveauRequis;
    
    @Transient
    protected int difficulte;
    
    //#region Constructeurs

    public ObjetRecoltable(String nom){
        this.nom = nom;
    }

    public ObjetRecoltable(String nom, int id){
        
    }

   
    //#endregion


    //#region GETSET
    

<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    public Integer getQuantite() {
        return quantite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
=======
    public int getId() {
        return idElementRecoltable;
    }

    public void setId(int id) {
        this.idElementRecoltable = id;
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    public Set<Objet> getObjets() {
        return objets;
    }

    // public void addOutil(Outils outil) {
    //     outils.add(outil);
    // }
=======
    public Set<Outil> getOutils() {
        return outils;
    }

    public void addOutil(Outil outil) {
        outils.add(outil);
    }
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java

    public Set<RessourcesRecoltees> getRessourcesRecoltees() {
        return ressourcesRecoltees;
    }

    public void addRessourcesRecoltees(RessourcesRecoltees ressourcesRecoltees) {
        this.ressourcesRecoltees.add(ressourcesRecoltees);
<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
=======
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java
    }

    public int getNiveauRequis() {
        return niveauRequis;
    }

<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    public void setSorte(String sorte) {
        this.sorte = sorte;
    }

    public Integer getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Integer difficulte) {
        this.difficulte = difficulte;
=======
    public void setNiveauRequis(int niveauRequis) {
        this.niveauRequis = niveauRequis;
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java
    }

    //#endregion

    

    //#region Méthodes
<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    public boolean ramasser(Personnage joueur,int nombre){
        // if (joueur.ajouterRessource(this.getType(), nombre)){
        //     return true;
        // }
        return false;
    }
=======
    // public boolean ramasser(Personnage joueur,int nombre){
        
    //     if (joueur.ajouterRessource(this.getType(), nombre)){
    //         return true;
    //     }
    //     return false;
    // }
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java

    public int rand(int min, int max){
        int rand = min + (int)(Math.random()*((max - min)+1));
        return rand;
    }

    public int difficulte(String sorte){
        if(sorte.equals("roseau") || sorte.equals("sardine") || sorte.equals("fer") || sorte.equals("brique") || sorte.equals("champignon") || sorte.equals("mare")){
            this.difficulte = 1;
        }
        if(sorte.equals("bambou") || sorte.equals("carpe")|| sorte.equals("cuivre") || sorte.equals("granit") || sorte.equals("coton") || sorte.equals("rivière")){
            this.difficulte = 2;
        }
        if(sorte.equals("chêne") || sorte.equals("truite") || sorte.equals("aimant") || sorte.equals("marbre") || sorte.equals("lin") || sorte.equals("source")){
            this.difficulte = 3;
        }
        if(sorte.equals("ébène ") || sorte.equals("brochet") || sorte.equals("or") || sorte.equals("schiste") || sorte.equals("orties") || sorte.equals("pluie")){
            this.difficulte = 4;
        }
        if(sorte.equals("séquoïa") || sorte.equals("requin") || sorte.equals("titane") || sorte.equals("diamant") || sorte.equals("rosier") || sorte.equals("seve")){
            this.difficulte = 5;
        }
        return this.difficulte;
    }

    // public int quantiteProduite(){
    //     if(this.difficulte == 1)
    //         this.quantite = this.rand(1, 3);

    //     else if(this.difficulte == 2)
    //         this.quantite = this.rand(1, 5);

    //     else if(this.difficulte == 3)
    //         this.quantite = this.rand(2, 6);

    //     else if(this.difficulte == 4)
    //         this.quantite = this.rand(2, 7);

    //     else if(this.difficulte == 5)
    //         this.quantite = this.rand(3, 8);

    //     return this.quantite;
    // }

<<<<<<< HEAD:app/src/main/java/fil/rouge/ObjetRecoltable.java
    // public boolean recolter(Personnage joueur, Outils outil){
    //     // if (joueur.getOutils()==this.getOutil()){
    //     //     int nombre = outil.getCapacite() * this.quantiteProduite();
    //     //     this.ramasser(joueur, nombre);
    //     //     return true;
    //     // }
    //     return false;
    
// si outil dispo équipé alors on utilise pour extraire ressource selon la capacité outil et objet recoltable (+ on retire de la résistance et si resistance >= 0 alors on retire l'objet de l'inventaire => a faire plus tard)
// puis ramasser
    // }

=======
    public boolean recolter(Personnage joueur, Outil outil){
        if (this.getOutils().contains(joueur.getOutil())){
            for (RessourcesRecoltees ressourceR : ressourcesRecoltees) {
            int nombre = ressourceR.getQuantite();
            Ressource ressource = ressourceR.getRessource();
            ressource.ramasser(joueur, nombre);
            return true;
            }
        }
        return false;
    
// si outil dispo équipé alors on utilise pour extraire ressource selon la capacité outil et objet recoltable (+ on retire de la résistance et si resistance >= 0 alors on retire l'objet de l'inventaire => a faire plus tard)
// puis ramasser
    }
    //#endregion
>>>>>>> Yannick:src/main/java/fil/rouge/model/ObjetRecoltable.java
}
