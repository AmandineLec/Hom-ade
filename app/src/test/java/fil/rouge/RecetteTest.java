package fil.rouge;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Savepoint;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import fil.rouge.utils.DBManager;

public class RecetteTest {
    static Savepoint save;

    @BeforeAll
    static void setup() {
        DBManager.init();
        DBManager.setAutoCommit(false);
    }

    @BeforeEach
    void init() {
        save = DBManager.setSavePoint();
    }

    
    @Test
    public void TestCreerItem(){

        Objet canneapeche = null;

        Maison maison = new Maison();
        maison.setNiveau(1);

        Joueur joueur = new Joueur("joueur", true);
        joueur.getInventoryressource().put(1, 7);
        joueur.getInventoryressource().put(3,8);
        joueur.getInventoryressource().put(7, 2);
        joueur.setMaison(maison);

        Recettes recette = new Recettes(1);
        recette.getQuantite().put(1, 5);
        recette.getQuantite().put(3, 6);
        recette.setNiveau_requis(1);

        recette.fusionnerRessource(joueur, canneapeche);
        assertTrue(joueur.getInventoryobjet().containsKey(canneapeche.getId()));
    }

    @AfterEach
    void done() {
        DBManager.rollback(save);
    }

    @AfterAll
    static void teardown() {
        DBManager.close();
    }

}
