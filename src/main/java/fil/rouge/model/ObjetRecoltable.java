package fil.rouge.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "element_recoltable")
public class ObjetRecoltable {
    @Id
    @Column(name = "id_element_recoltable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idElementRecoltable;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "categorie")
    protected int categorie;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "objet_element_recoltable",
        joinColumns = @JoinColumn(name = "id_element_recoltable"),
        inverseJoinColumns = @JoinColumn(name = "id_objet")
    )
    protected Set<Outil> outils = new HashSet<Outil>(); // id de l'outil à utiliser pour récolter

    @OneToMany(mappedBy = "objetRecoltable")
    protected Set<RessourcesRecoltees> ressourcesRecoltees = new HashSet<RessourcesRecoltees>();
    
    @Column(name = "niveau_requis")
    protected int niveauRequis;
    
    @Transient
    protected int difficulte;
    
    //#region Constructeurs

    public ObjetRecoltable() {}

    public ObjetRecoltable(String nom){
        this.nom = nom;
    }

    public ObjetRecoltable(String nom, int id){
        
    }


    //#endregion

    //#region GETSET
    

    public int getIdElementRecoltable() {
        return idElementRecoltable;
    }

    public void setIdElementRecoltable(int idElementRecoltable) {
        this.idElementRecoltable = idElementRecoltable;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public String getNom() {
        return nom;
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

    public Set<Outil> getOutils() {
        return outils;
    }

    public void addOutil(Outil outil) {
        outils.add(outil);
    }

    public Set<RessourcesRecoltees> getRessourcesRecoltees() {
        return ressourcesRecoltees;
    }

    public void addRessourcesRecoltees(RessourcesRecoltees ressourcesRecoltees) {
        this.ressourcesRecoltees.add(ressourcesRecoltees);
    }

    public int getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(int niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    //#endregion

    //#region Méthodes
    // public boolean ramasser(Personnage joueur,int nombre){
        
    //     if (joueur.ajouterRessource(this.getType(), nombre)){
    //         return true;
    //     }
    //     return false;
    // }

    // public int rand(int min, int max){
    //     int rand = min + (int)(Math.random()*((max - min)+1));
    //     return rand;
    // }

    // public int difficulte(String sorte){
    //     if(sorte.equals("roseau") || sorte.equals("sardine") || sorte.equals("fer") || sorte.equals("brique") || sorte.equals("champignon") || sorte.equals("mare")){
    //         this.difficulte = 1;
    //     }
    //     if(sorte.equals("bambou") || sorte.equals("carpe")|| sorte.equals("cuivre") || sorte.equals("granit") || sorte.equals("coton") || sorte.equals("rivière")){
    //         this.difficulte = 2;
    //     }
    //     if(sorte.equals("chêne") || sorte.equals("truite") || sorte.equals("aimant") || sorte.equals("marbre") || sorte.equals("lin") || sorte.equals("source")){
    //         this.difficulte = 3;
    //     }
    //     if(sorte.equals("ébène ") || sorte.equals("brochet") || sorte.equals("or") || sorte.equals("schiste") || sorte.equals("orties") || sorte.equals("pluie")){
    //         this.difficulte = 4;
    //     }
    //     if(sorte.equals("séquoïa") || sorte.equals("requin") || sorte.equals("titane") || sorte.equals("diamant") || sorte.equals("rosier") || sorte.equals("seve")){
    //         this.difficulte = 5;
    //     }
    //     return this.difficulte;
    // }

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

    // public boolean recolter(Personnage joueur, Outil outil){
    //     if (this.getOutils().contains(joueur.getOutil())){
    //         for (RessourcesRecoltees ressourceR : ressourcesRecoltees) {
    //         int nombre = ressourceR.getQuantite();
    //         Ressource ressource = ressourceR.getRessource();
    //         ressource.ramasser(joueur, nombre);
    //         return true;
    //         }
    //     }
    //     return false;
    
// si outil dispo équipé alors on utilise pour extraire ressource selon la capacité outil et objet recoltable (+ on retire de la résistance et si resistance >= 0 alors on retire l'objet de l'inventaire => a faire plus tard)
// puis ramasser
//    }
    //#endregion

}
