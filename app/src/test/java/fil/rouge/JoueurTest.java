package fil.rouge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoueurTest {

  @Test void testAjouterRessource(){

    Ressource bois = new Ressource("bois");
    Joueur luffy = new Joueur("luffy", true);
    luffy.ajouterRessource(bois, 1);
    assertTrue(luffy.getInventoryressource().get(bois.getId()) == 1);
  }

  @Test
  void testRetirerRessource() {

    Ressource bois = new Ressource("bois");
    Joueur luffy = new Joueur("luffy", true);
    luffy.ajouterRessource(bois, 1);
    luffy.retirerRessource(bois, 1);
    assertFalse(luffy.getInventoryressource().containsKey(bois.getId()));
  }


}
