package fil.rouge;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecetteTest {

    @Test
    public void TestCreerItem(){
        Joueur joueur = new Joueur("joueur", true);
        Recettes recette = new Recettes("Recette");

        joueur.Creer_item(recette);
        
        assertTrue(joueur.getInventory().containsKey(recette)==true);
    }
}
