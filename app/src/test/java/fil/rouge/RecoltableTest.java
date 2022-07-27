package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecoltableTest {
    @Test
    public void ramasserTest(){
        Joueur perso = new Joueur("Paul", true);
        Bois branche = new Bois("branche");
        ObjetRecoltable bois = new ObjetRecoltable("bois", 1, branche);
        bois.ramasser(perso);
        assertTrue(perso.getInventoryressource().containsKey(bois.getId()));
    }

    @Test
    public void randTest(){
        int min = 1;
        int max = 3;
        ObjetRecoltable objet = new ObjetRecoltable("objet");
        int test = objet.rand(min, max);
        assertTrue(test >=1 && test <=3);
    }

    @Test
    public void difficulteTest(){
        ObjetRecoltable objet = new ObjetRecoltable("objet");
        objet.setSorte("seve");
        objet.difficulte("seve");
        assertEquals(objet.difficulte, 5);
    }

    // @Test
    // public void recolterTest(){
    //     Hache hache = new Hache("hache");
    //     Joueur perso = new Joueur("Paul", true);
    //     Bois bois = new Bois("bois");
    //     ObjetRecoltable arbre = new ObjetRecoltable("arbre", 1, bois);
    //     perso.ajouterObjet(hache, 1);
    //     arbre.recolter(perso, hache);
    //     assertTrue(perso.getInventory().containsKey(bois));
    // }
}
