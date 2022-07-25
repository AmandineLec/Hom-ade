package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecoltableTest {
    @Test
    public boolean ramasserTest(){
        Joueur perso = new Joueur("Paul", true);
        Bois bois = new Bois(1, "bois");
        bois.ramasser();
        perso.add(bois);
        assertTrue(perso.getInventory().containsKey(bois));
    }

    @Test
    public void recolterTest(){
        Hache hache = new Hache("hache");
        Joueur perso = new Joueur("Paul", true);
        ObjetRecoltable arbre = new ObjetRecoltable("arbre");
        Bois bois = new Bois(1, "bois");
        perso.add(hache);
        arbre.recolter(hache);
        assertTrue(perso.getInventory().containsKey(bois));
    }
}
