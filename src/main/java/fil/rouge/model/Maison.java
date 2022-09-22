package fil.rouge.model;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "maison")
public class Maison {
    @Id
    @Column(name = "id_maison")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idMaison;

    @Column(name = "niveau")
    protected int niveau; // début à 1

    @Column(name = "nb_pieces")
    protected int nbPieces; // début à 1

    @OneToMany(mappedBy = "maison")
    protected Set<Personnage> personnages = new HashSet<Personnage>();

    // @Transient // non sauvegardé dans la bdd. Pour accéder à la pièce
    // protected ArrayList<Piece> pieces = new ArrayList<Piece>();

    @Transient
    protected ArrayList<RecetteMaison> recetteMaison = new ArrayList<RecetteMaison>();
    



    // public ArrayList<HashMap<Integer, Integer>> ajouterRecettes(){
    //     recettes.add(this.recetteNiveauMaisonDe1A2());
    //     recettes.add(this.recetteNiveauMaisonDe2A3());
    //     recettes.add(this.recetteNiveauMaisonDe3A4());
    //     recettes.add(this.recetteNiveauMaisonDe4A5());
    //     recettes.add(this.recetteNiveauMaisonDe5A6());
    //     recettes.add(this.recetteNiveauMaisonDe6A7());
    //     recettes.add(this.recetteNiveauMaisonDe7A8());
    //     recettes.add(this.recetteNiveauMaisonDe8A9());
    //     recettes.add(this.recetteNiveauMaisonDe9A10());
    //     return recettes;
    // }

    // protected String idRessource; // pour récupérer les ressources nécessaires à l'augmentation du niveau
    // protected int nbRessources; // pour définir le nombre de ressources nécéssaires pour ajouter une pièce
    // protected String etabli; // pour accéder à l'établi lors de la création d'objets
    // protected Piece piece; 

    //#region Constructeurs
    public Maison(){
        this.niveau = 1;
    }
    //#endregion


    //#region GETSET
    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNb_pieces() {
        return nbPieces;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nbPieces = nb_pieces;
    }

    // public ArrayList<HashMap<Integer, Integer>> getRecettes() {
    //     return recettes;
    // }

    // public void setRecettes(ArrayList<HashMap<Integer, Integer>> recettes) {
    //     this.recettes = recettes;
    // }


    // public String getId_ressource() {
    //     return id_ressource;
    // }

    // public void setId_ressource(String id_ressource) {
    //     this.id_ressource = id_ressource;
    // }

    // public int getNb_ressources() {
    //     return nb_ressources;
    // }

    // public void setNb_ressources(int nb_ressources) {
    //     this.nb_ressources = nb_ressources;
    // }

    // public String getEtabli() {
    //     return etabli;
    // }

    // public void setEtabli(String etabli) {
    //     this.etabli =
    //     etabli;
    // }

    public int getId_maison() {
        return idMaison;
    }

    public void setId_maison(int idMaison) {
        this.idMaison = idMaison;
    }

    // public ArrayList<Piece> getPieces() {
    //     return pieces;
    // }

    // public void setPieces(ArrayList<Piece> pieces) {
    //     this.pieces = pieces;
    // }


    
    //#endregion

    //#region Méthodes
    // public void levelUp(Piece piece){
    //     this.setNiveau(this.getNiveau()+1);
    //     if (this.getNiveau()>=1 && this.getNiveau()<=3){
    //         this.pieceAccessible(piece);
    //     }
    //     else if(this.getNiveau()>3 && this.getNiveau()%2==0){ // si le niveau est pair on ajoute une pièce
    //         this.pieceAccessible(piece);
    //     }
    //     else{
    //         piece.agrandir(1);
    //     }
    // }

    // public void pieceAccessible(Piece piece){
    //     this.setNb_pieces(this.getNb_pieces()+1);
    //     this.piece = piece;
    // }

//       public static int sauvegarderMaison(){
//         try{
//           Maison maisonJoueur = new Maison(1);
//           int niveauMaison = maisonJoueur.getNiveau();
//           int nbPiecesMaison = maisonJoueur.getNb_pieces();
//           String query = "INSERT INTO maison (niveau,nb_pieces) VALUES (?,?)";
//           PreparedStatement myStmt = DBManager.preparedStatement(query);
//           myStmt.setInt(1, niveauMaison);
//           myStmt.setInt(2, nbPiecesMaison);
//           myStmt.executeUpdate();
//           ResultSet res = myStmt.getGeneratedKeys();
//           res.next();
//           int clePrimaireMaison = res.getInt(1);
//           return clePrimaireMaison;

//           } catch (SQLException ex) {
//           // handle any errors
//           System.out.println("SQLException: " + ex.getMessage());
//           System.out.println("SQLState: " + ex.getSQLState());
//           System.out.println("VendorError: " + ex.getErrorCode());
//         }
//       return -1;
//   }
public RecetteMaison niveauDeux(){
    RecetteMaison niveau2 = new RecetteMaison();
    Ingredients i1 = new Ingredients(7,2);
    niveau2.setI1(i1);
    Ingredients i2 = new Ingredients(2,2);
    niveau2.setI2(i2);
    Ingredients i3 = new Ingredients(33,2);
    niveau2.setI3(i3);
    Ingredients i4 = new Ingredients(3,2);
    niveau2.setI4(i4);
    Ingredients i5 = new Ingredients(1,2);
    niveau2.setI5(i5);
    return niveau2;
}

public RecetteMaison niveauTrois(){
    RecetteMaison niveau3 = new RecetteMaison();
    Ingredients i1 = new Ingredients(7,3);
    niveau3.setI1(i1);
    Ingredients i2 = new Ingredients(2,3);
    niveau3.setI2(i2);
    Ingredients i3 = new Ingredients(33,3);
    niveau3.setI2(i3);
    Ingredients i4 = new Ingredients(3,3);
    niveau3.setI4(i4);
    Ingredients i5 = new Ingredients(1,3);
    niveau3.setI5(i5);
    return niveau3;
}

public RecetteMaison niveauQuatre(){
    RecetteMaison niveau4 = new RecetteMaison();
    Ingredients i1 = new Ingredients(7,4);
    niveau4.setI1(i1);
    Ingredients i2 = new Ingredients(23,4);
    niveau4.setI2(i2);
    Ingredients i3 = new Ingredients(34,4);
    niveau4.setI3(i3);
    Ingredients i4 = new Ingredients(17,4);
    niveau4.setI4(i4);
    Ingredients i5 = new Ingredients(27,4);
    niveau4.setI5(i5);
    return niveau4;
}

public RecetteMaison niveauCinq(){
    RecetteMaison niveau5 = new RecetteMaison();
    Ingredients i1 = new Ingredients(8,5);
    niveau5.setI1(i1);
    Ingredients i2 = new Ingredients(22,5);
    niveau5.setI2(i2);
    Ingredients i3 = new Ingredients(34,5);
    niveau5.setI3(i3);
    Ingredients i4 = new Ingredients(17,5);
    niveau5.setI4(i4);
    Ingredients i5 = new Ingredients(28,5);
    niveau5.setI5(i5);
    return niveau5;
}


public RecetteMaison niveauSix(){
    RecetteMaison niveau6 = new RecetteMaison();
    Ingredients i1 = new Ingredients(8,6);
    niveau6.setI1(i1);
    Ingredients i2 = new Ingredients(22,6);
    niveau6.setI2(i2);
    Ingredients i3 = new Ingredients(34,6);
    niveau6.setI3(i3);
    Ingredients i4 = new Ingredients(17,6);
    niveau6.setI4(i4);
    Ingredients i5 = new Ingredients(28,6);
    niveau6.setI5(i5);
    return niveau6;
}

public RecetteMaison niveauSept(){
    RecetteMaison niveau7 = new RecetteMaison();
    Ingredients i1 = new Ingredients(8,7);
    niveau7.setI1(i1);
    Ingredients i2 = new Ingredients(22,7);
    niveau7.setI2(i2);
    Ingredients i3 = new Ingredients(34,7);
    niveau7.setI3(i3);
    Ingredients i4 = new Ingredients(17,7);
    niveau7.setI4(i4);
    Ingredients i5 = new Ingredients(28,7);
    niveau7.setI5(i5);
    return niveau7;
}

public RecetteMaison niveauHuit(){
    RecetteMaison niveau8 = new RecetteMaison();
    Ingredients i1 = new Ingredients(9,4);
    niveau8.setI1(i1);
    Ingredients i2 = new Ingredients(23,4);
    niveau8.setI2(i2);
    Ingredients i3 = new Ingredients(35,4);
    niveau8.setI3(i3);
    Ingredients i4 = new Ingredients(18,4);
    niveau8.setI4(i4);
    Ingredients i5 = new Ingredients(29,4);
    niveau8.setI5(i5);
    return niveau8;
}

public RecetteMaison niveauNeuf(){
    RecetteMaison niveau9 =  new RecetteMaison();
    Ingredients i1 = new Ingredients(9,5);
    niveau9.setI1(i1);
    Ingredients i2 = new Ingredients(23, 5);
    niveau9.setI2(i2);
    Ingredients i3 = new Ingredients(35, 5);
    niveau9.setI3(i3);
    Ingredients i4 = new Ingredients(18, 5);
    niveau9.setI4(i4);
    Ingredients i5 = new Ingredients(29, 5);
    niveau9.setI5(i5);
    return niveau9;
}

public RecetteMaison niveauDix(){
    RecetteMaison niveau10 = new RecetteMaison();
    Ingredients i1 = new Ingredients(9, 6);
    niveau10.setI1(i1);
    Ingredients i2 = new Ingredients(23, 6);
    niveau10.setI2(i2);
    Ingredients i3 = new Ingredients(35, 6);
    niveau10.setI3(i3);
    Ingredients i4 = new Ingredients(18, 6);
    niveau10.setI4(i4);
    Ingredients i5 = new Ingredients(29, 6);
    niveau10.setI5(i5);
    return niveau10;
}



    //#endregion
}
