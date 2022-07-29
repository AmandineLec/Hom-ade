package fil.rouge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fil.rouge.utils.DBManager;

public class Pieces {
    protected Maison maison;
    protected int id_piece;
    protected String nom;
    protected int taille; //en mètres carrés
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
