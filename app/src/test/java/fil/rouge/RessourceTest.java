package fil.rouge;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Savepoint;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fil.rouge.utils.DBManager;


public class RessourceTest {
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
    }
    

    
    @Test
    public void testRamasser() {
        Ressource test = new Ressource("test");
        Joueur j = new Joueur("test", true);
        
        test.ramasser(j, 1);

        assertEquals(1, j.getInventory().get(test));
    }

    @Test
    public void testRamasserPlusieurs() {
        Ressource test = new Ressource("test");
        Joueur j = new Joueur("test", true);

        test.ramasser(j, 5);

        assertEquals(5, j.getInventory().get(test));
    }

}
