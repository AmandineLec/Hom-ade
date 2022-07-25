package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class RessourceTest {
    
    @Test
    public void testRamasser() {
        Bois test = new Bois(1, "test");
        Joueur j = new Joueur("test", true);
        
        test.ramasser(j);

        assertEquals(1, j.getInventaire().get(test));
    }

}
