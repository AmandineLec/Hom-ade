package fil.rouge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoueurTest {

  @Test void testAjouterRessource(){

    Bois bois = new Bois("bois");
    Joueur luffy = new Joueur("luffy", true);
    luffy.ajouterObjet(bois, 1);
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


}
