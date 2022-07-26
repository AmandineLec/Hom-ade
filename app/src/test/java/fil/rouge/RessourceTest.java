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
        DBManager.close();
    }

    
    @Test
    public void testRamasser() {
        Bois test = new Bois("test");
        Joueur j = new Joueur("test", true);
        
        test.ramasser(j);

        assertEquals(1, j.getInventaire().get(test));
    }

}
