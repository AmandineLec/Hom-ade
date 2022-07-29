package fil.rouge;

import org.junit.jupiter.api.Test;

import fil.rouge.utils.DBManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Savepoint;

public class JoueurTest {

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
  void testAjouterRessource(){

    Ressource bois = new Ressource("bois");
    Joueur luffy = new Joueur("luffy", 1);
    luffy.ajouterRessource(bois, 1);
    assertTrue(luffy.getInventoryressource().get(bois.getId()) == 1);
  }

  @Test
  void testRetirerRessource() {

    Ressource bois = new Ressource("bois");
    Joueur luffy = new Joueur("luffy", 1);
    luffy.ajouterRessource(bois, 1);
    luffy.retirerRessource(bois, 1);
    assertFalse(luffy.getInventoryressource().containsKey(bois.getId()));
  }

  @Test
  void testSauvegarderJoueur(){
    Joueur mikasa = new Joueur("mikasa", 2);
    assertFalse(Joueur.sauvegarderJoueur(mikasa) == -1);
  }




}
