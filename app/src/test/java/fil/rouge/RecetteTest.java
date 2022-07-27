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

    @AfterEach
    void done() {
        DBManager.rollback(save);
    }

    @AfterAll
    static void teardown() {
        DBManager.close();
    }

    @Test
    public void TestCreerItem(){
        Joueur joueur = new Joueur("joueur", true);
        Recettes recette = new Recettes("Recette");

        recette.fusionnerRessource(joueur);
        
        assertTrue(joueur.getInventory().containsKey()==true);
    }
}
