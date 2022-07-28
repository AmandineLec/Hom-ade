package fil.rouge;

import org.junit.jupiter.api.Test;

import fil.rouge.utils.DBManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.sql.SQLException;

public class JoueurTest {

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
    assertTrue(Joueur.sauvegarderJoueur(mikasa) != -1);
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
