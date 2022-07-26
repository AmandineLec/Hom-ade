package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecoltableTest {
    @Test
    public void ramasserTest(){
        Joueur perso = new Joueur("Paul", true);
        Bois branche = new Bois(1, "branche");
        ObjetRecoltable bois = new ObjetRecoltable("bois", 1, branche);
        bois.ramasser(perso);
        assertTrue(perso.getInventory().containsKey(bois));
    }

    @Test
    public void recolterTest(){
        Hache hache = new Hache("hache");
        Joueur perso = new Joueur("Paul", true);
        ObjetRecoltable arbre = new ObjetRecoltable("arbre");
        Bois bois = new Bois(1, "bois");
        perso.ajouterObjet(hache, 1);
        arbre.recolter(hache);
        assertTrue(perso.getInventory().containsKey(bois));
    }
}
