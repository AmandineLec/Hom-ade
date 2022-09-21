package fil.rouge.model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    @Transient // non sauvegardé dans la bdd. Pour accéder à la pièce
    protected ArrayList<Piece> pieces = new ArrayList<Piece>();

    @Transient
    protected ArrayList<HashMap<Integer, Integer>> recettes = new ArrayList<>();

    public ArrayList<HashMap<Integer, Integer>> ajouterRecettes(){
        recettes.add(this.recetteNiveauMaisonDe1A2());
        recettes.add(this.recetteNiveauMaisonDe2A3());
        recettes.add(this.recetteNiveauMaisonDe3A4());
        recettes.add(this.recetteNiveauMaisonDe4A5());
        recettes.add(this.recetteNiveauMaisonDe5A6());
        recettes.add(this.recetteNiveauMaisonDe6A7());
        recettes.add(this.recetteNiveauMaisonDe7A8());
        recettes.add(this.recetteNiveauMaisonDe8A9());
        recettes.add(this.recetteNiveauMaisonDe9A10());
        return recettes;
    }

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

    public ArrayList<HashMap<Integer, Integer>> getRecettes() {
        return recettes;
    }

    public void setRecettes(ArrayList<HashMap<Integer, Integer>> recettes) {
        this.recettes = recettes;
    }


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

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }


    
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
public HashMap<Integer, Integer>  recetteNiveauMaisonDe1A2(){
    HashMap<Integer, Integer> niveau2 = new HashMap<Integer, Integer >();
    niveau2.put(7,2);
    niveau2.put(2,2);
    niveau2.put(33,2);
    niveau2.put(3,2);
    niveau2.put(1,2);
    // recuperer la ressource ayant pour id => 7
    // recuperer la ressource ayant pour id => 2
    // recuperer la ressource ayant pour id => 33
    // recuperer la ressource ayant pour id => 3
    // recuperer la ressource ayant pour id => 1
    return niveau2;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe2A3(){
    HashMap<Integer, Integer> niveau3 = new HashMap<Integer, Integer >();
    niveau3.put(7,3);
    niveau3.put(2,3);
    niveau3.put(33,3);
    niveau3.put(3,3);
    niveau3.put(1,3);
    return niveau3;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe3A4(){
    HashMap<Integer, Integer> niveau4 = new HashMap<Integer, Integer >();
    niveau4.put(7,4);
    niveau4.put(23,4);
    niveau4.put(34,4);
    niveau4.put(17,4);
    niveau4.put(27,4);
    return niveau4;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe4A5(){
    HashMap<Integer, Integer> niveau5 = new HashMap<Integer, Integer >();
    niveau5.put(8,5);
    niveau5.put(22,5);
    niveau5.put(34,5);
    niveau5.put(17,5);
    niveau5.put(28,5);
    return niveau5;
}


public HashMap<Integer, Integer>  recetteNiveauMaisonDe5A6(){
    HashMap<Integer, Integer> niveau6 = new HashMap<Integer, Integer >();
    niveau6.put(8,6);
    niveau6.put(22,6);
    niveau6.put(34,6);
    niveau6.put(17,6);
    niveau6.put(28,6);
    return niveau6;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe6A7(){
    HashMap<Integer, Integer> niveau7 = new HashMap<Integer, Integer >();
    niveau7.put(8,7);
    niveau7.put(22,7);
    niveau7.put(34,7);
    niveau7.put(17,7);
    niveau7.put(28,7);
    return niveau7;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe7A8(){
    HashMap<Integer, Integer> niveau8 = new HashMap<Integer, Integer >();
    niveau8.put(9,4);
    niveau8.put(23,4);
    niveau8.put(35,4);
    niveau8.put(18,4);
    niveau8.put(29,4);
    return niveau8;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe8A9(){
    HashMap<Integer, Integer> niveau9 = new HashMap<Integer, Integer >();
    niveau9.put(9,5);
    niveau9.put(23,5);
    niveau9.put(35,5);
    niveau9.put(18,5);
    niveau9.put(29,5);
    return niveau9;
}

public HashMap<Integer, Integer>  recetteNiveauMaisonDe9A10(){
    HashMap<Integer, Integer> niveau10 = new HashMap<Integer, Integer >();
    niveau10.put(9,6);
    niveau10.put(23,6);
    niveau10.put(35,6);
    niveau10.put(18,6);
    niveau10.put(29,6);
    return niveau10;
}



    //#endregion
}
