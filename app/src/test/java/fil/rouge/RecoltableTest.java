package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecoltableTest {
    @Test
    public void ramasserTest(){
        Joueur perso = new Joueur("Paul", true);
        Bois branche = new Bois("branche");
        ObjetRecoltable bois = new ObjetRecoltable(branche, "bois", "chêne");
        bois.setType(branche);
        bois.ramasser(perso, 1);
        assertTrue(perso.getInventory().containsKey(branche));
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

    @Test
    public void quantiteProduiteTest(){
        ObjetRecoltable objet = new ObjetRecoltable("objet");
        objet.setSorte("bambou");
        objet.difficulte(objet.getSorte());
        objet.quantiteProduite();
        assertTrue(objet.getQuantite()>=1 && objet.getQuantite()<=5);
    }

    @Test
    public void recolterTest(){
        Outils hache = new Outils("hache");
        hache.setCapacite(2);
        Joueur perso = new Joueur("Paul", true);
        Bois bois = new Bois("bois");
        ObjetRecoltable arbre = new ObjetRecoltable(bois, "arbre", "chêne");
        perso.setOutils(hache);
        arbre.difficulte(arbre.getSorte());
        arbre.setOutil(hache);
        arbre.recolter(perso, hache);
        int nb = arbre.getQuantite()*hache.getCapacite();
        assertTrue(perso.getInventory().get(bois)==nb);
    }
}
