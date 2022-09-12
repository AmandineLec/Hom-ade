package fil.rouge;
import org.junit.jupiter.api.Test;

import fil.rouge.utils.DBManager;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Savepoint;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class MaisonTest {

  static Savepoint save;

  @BeforeAll
  static void setup() {
    DBManager.init();
    DBManager.setAutoCommit(false);
  }

  @BeforeEach
  void init() {
    save = DBManager.setSavePoint();
  }

  @AfterEach
  void done() {
    DBManager.rollback(save);
  }

  @AfterAll
  static void teardown() {
    DBManager.close();
  }


    @Test
    public void levelUpTestAvecAjoutPiece(){
        Piece piece = new Piece("salon", 10);
        Maison maison = new Maison(1);
        maison.setNiveau(3);
        maison.levelUp(piece);
        assertTrue(maison.getNiveau()==4 && maison.getNb_pieces()==2);
    }

    @Test
    public void levelUpTestAvecAgrandissement(){
        Piece piece = new Piece("salon", 10);
        Maison maison = new Maison(1);
        maison.setNiveau(4);
        maison.levelUp(piece);
        assertTrue(maison.getNiveau()==5 && piece.getTaille()==11 && maison.nb_pieces==1);
    }


    @Test
    public void pieceAccessibleTest(){
        Maison maison = new Maison(1);
        Piece cuisine = new Piece("cuisine");
        maison.pieceAccessible(cuisine);
        assertTrue(maison.getNb_pieces()==2 && maison.getPiece().getNom()=="cuisine");
    }

    @Test
    void testSauvegarderMaison() {
      assertTrue(Maison.sauvegarderMaison() != -1);
    }


}
