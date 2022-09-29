package fil.rouge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.ObjetRecoltableRepository;
import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetRecoltableService;

@SpringBootTest
public class ObjetRecoltableServiceTest {
    
    @Autowired
    ObjetRecoltableService objetRecoltableService;

    @MockBean
    ObjetRecoltableRepository objetRecoltableRepository;
    
    @Test
    public void givenObjetRecoltable_WhenOutilNotInOutils_ThenThrowsException() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        Personnage personnage = new Personnage("toto", 1);
        Outil outil1 = new Outil("outil1");
        outil1.setId(1);
        Outil outil2 = new Outil("outil2");
        outil2.setId(2);
        Outil outil3 = new Outil("outil3");
        outil3.setId(3);
        
        personnage.setOutil(outil1);
        objetRecoltable.addOutil(outil2);
        objetRecoltable.addOutil(outil3);
                      
        assertThrows(WrongToolException.class, ()-> objetRecoltableService.utiliserOutil(personnage, objetRecoltable, 10));
    }

    @Test
    public void givenObjetRecoltableWithPv10_WhenOutilCapacite3_ThenReturn7() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        Personnage personnage = new Personnage("toto", 1);
        Outil outil1 = new Outil("outil1");
        outil1.setId(1);
        outil1.setCapacite(3);

        personnage.setOutil(outil1);
        objetRecoltable.addOutil(outil1);

        try {
            assertThat(objetRecoltableService.utiliserOutil(personnage, objetRecoltable, 10)).isEqualTo(7);
        } catch (WrongToolException e) {
            
            e.printStackTrace();
        }
    }

    @Test
    public void givenObjetRecoltableDisparait_WhenReapparaitBeforeCooldown_ThenReturnFalse() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        objetRecoltable.setCooldown(100);
        objetRecoltableService.disparait(objetRecoltable);
        assertThat(objetRecoltableService.reapparait(objetRecoltable)).isFalse();
    }

    @Test
    public void givenObjetRecoltableDisparait_WhenReapparaitAfterCooldown_ThenReturnTrue() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        objetRecoltable.setCooldown(100);
        objetRecoltableService.disparait(objetRecoltable);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {           
            e.printStackTrace();
        }
        assertThat(objetRecoltableService.reapparait(objetRecoltable)).isTrue();
    }
}