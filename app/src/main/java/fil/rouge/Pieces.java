package fil.rouge;

import jakarta.persistence.*;

@Entity
@Table(name = "piece")
public class Pieces {
    @Id
    @Column(name = "id_piece")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id_piece;

    @Column(name = "nom")
    protected String nom;

    @Column(name = "taille")
    protected int taille; //en mètres carrés

    @ManyToOne
    @JoinColumn(name = "id_maison")
    protected Maison maison;
    
    protected int id_decoration; // pour récupérer la déco placée dans la maison
    protected int id_meuble; // pour récupérer le meuble placé dans la maison

    //#region Constructeurs
    public Pieces(){
        this.taille = 9;
    }

    public Pieces(String nom){
        this.nom = nom;
        this.taille = 9;
    }

    public Pieces(String nom, int taille){
        this.nom = nom;
        this.taille = taille;
    }
    //#endregion

    //#region GETSET
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getId_decoration() {
        return id_decoration;
    }

    public void setId_decoration(int id_decoration) {
        this.id_decoration = id_decoration;
    }

    public int getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }

    public int getId_piece() {
        return id_piece;
    }

    public void setId_piece(int id_piece) {
        this.id_piece = id_piece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    //#endregion

    //#region Méthodes
    public void agrandir(int agrandissement){
        this.setTaille(this.getTaille() + 1);
    }

    //#endregion
}
