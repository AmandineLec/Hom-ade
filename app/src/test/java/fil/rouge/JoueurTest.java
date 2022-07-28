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

    Bois bois = new Bois("bois");
    Joueur luffy = new Joueur("luffy", true);
    luffy.ajouterObjet(bois, 1); // grâce au constructeur intégrant l'inventaire
    assertTrue(luffy.getInventory().get(bois) == 1);
  }

  @Test
  void testRetirerRessource() {

    Bois bois = new Bois("bois");
    Joueur luffy = new Joueur("luffy", true);
    luffy.ajouterObjet(bois, 1);
    luffy.retirerObjet(bois, 1);
    assertFalse(luffy.getInventory().containsKey(bois));
  }

  @Test
  void testSauvegarderJoueur(){
    Joueur mikasa = new Joueur("mikasa", false);
    assertFalse(Joueur.sauvegarderJoueur(mikasa) == -1);
  }




}
