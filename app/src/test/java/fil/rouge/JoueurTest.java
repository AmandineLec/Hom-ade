package fil.rouge;

import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoueurTest {

  @Test void testAjouterRessource(){

    Bois bois = new Bois(1, "bois");
    Joueur luffy = new Joueur("luffy", true);
    HashMap<Ressource, Integer> inventaire = new HashMap<>();
    inventaire.put(bois, 1);
    luffy.setInventaire(inventaire);
    assertTrue(inventaire.get(bois) == 1);
  }

  @Test
  void testRetirerRessource() {

    Bois bois = new Bois(1, "bois");
    Joueur luffy = new Joueur("luffy", true);
    HashMap<Ressource, Integer> inventaire = new HashMap<>();
    inventaire.put(bois, 1);
    luffy.setInventaire(inventaire);
    inventaire.remove(bois);
    assertTrue(inventaire.size() == 0);
  }

  @Test void testAjouterElement(){

    CanneAPeche canneApeche = new CanneAPeche("canne a pèche");
    Joueur mikasa = new Joueur("mikasa", false);
    HashMap<Objet, Integer> inventaire = new HashMap<>();
    inventaire.put(canneApeche, 1);
    mikasa.setInventaireObjet(inventaire);
    assertTrue(inventaire.get(canneApeche) == 1);
  }

  @Test
  void testRetirerElement() {

    CanneAPeche canneApeche = new CanneAPeche("canne a pèche");
    Joueur mikasa = new Joueur("mikasa", false);
    HashMap<Objet, Integer> inventaire = new HashMap<>();
    inventaire.put(canneApeche, 1);
    mikasa.setInventaireObjet(inventaire);
    inventaire.remove(canneApeche);
    assertTrue(inventaire.get(canneApeche) == 1);
    assertTrue(inventaire.size() == 0);
  }

}
