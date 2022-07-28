package fil.rouge;
import org.junit.jupiter.api.Test;

import fil.rouge.utils.DBManager;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MaisonTest {

  @BeforeAll // s'execute avant tous les tests
  public static void initialisation() {
    DBManager.init(); // Pour se connecter à la bdd
  }

  @BeforeEach // s'execute avant chaque test
  public void setUp() {
    try {
      DBManager.conn.setAutoCommit(false); // ne pas faire la modif qu'on lui demande : c'est juste pour tester
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


    @Test
    public void levelUpTestAvecAjoutPiece(){
        Pieces piece = new Pieces("salon", 10);
        Maison maison = new Maison(1);
        maison.setNiveau(3);
        maison.levelUp(piece);
        assertTrue(maison.getNiveau()==4 && maison.getNb_pieces()==2);
    }

    @Test
    public void levelUpTestAvecAgrandissement(){
        Pieces piece = new Pieces("salon", 10);
        Maison maison = new Maison(1);
        maison.setNiveau(4);
        maison.levelUp(piece);
        assertTrue(maison.getNiveau()==5 && piece.getTaille()==11 && maison.nb_pieces==1);
    }


    @Test
    public void ajoutPieceTest(){
        Maison maison = new Maison(1);
        Pieces cuisine = new Pieces("cuisine");
        maison.ajoutPiece(cuisine);
        assertTrue(maison.getNb_pieces()==2 && maison.getPiece().getNom()=="cuisine");
    }

    @Test
    void testSauvegarderMaison() {
      assertTrue(Maison.sauvegarderMaison() != -1);
    }

    @AfterEach // s'execute après chaque test
    public void tearDown() {
      try {
        DBManager.conn.rollback(); // pour revenir à l'état initial car la simulation est faite dans la mémoire
                                   // cache
        DBManager.conn.setAutoCommit(true); // static pas besoin d'instance mais s'applique à toutes les autres classes
        // donc si je l'avais laissé en false je n'aurais pas pu faire de commit
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
}
