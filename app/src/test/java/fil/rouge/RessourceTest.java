package fil.rouge;

import org.junit.jupiter.api.Test;

public class RessourceTest {
    
    @Test
    public void testRamasser() {
        Bois test = new Bois(1, "test");
        
        test.ramasser();
    }

}
