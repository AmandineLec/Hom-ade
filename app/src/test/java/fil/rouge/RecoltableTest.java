package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecoltableTest {
    @Test
    public void ramasserTest(){
        Joueur perso = new Joueur("Paul", 1);
        Ressource bois = new Ressource("bois");
        bois.setId(1);
        ObjetRecoltable arbre = new ObjetRecoltable(bois, "bois de chêne", "chêne");
        arbre.ramasser(perso, 1);
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
        Joueur perso = new Joueur("Paul", 1);
        Ressource bois = new Ressource("bois");
        bois.setId(2);
        ObjetRecoltable arbre = new ObjetRecoltable(bois, "arbre", "chêne");
        perso.setOutils(hache);
        arbre.difficulte(arbre.getSorte());
        arbre.setOutil(hache);
        arbre.recolter(perso, hache);
        int nb = arbre.getQuantite()*hache.getCapacite();
        assertTrue(perso.getInventoryressource().get(bois.getId())==nb);
    }
}
