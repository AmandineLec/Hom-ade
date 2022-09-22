package fil.rouge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.ObjetRecoltableRepository;
import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;
import fil.rouge.service.RecoltageService;

@SpringBootTest
public class RecoltageServiceTest {
    
    @Autowired
    RecoltageService recoltageService;

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
        
        Mockito.when(objetRecoltableRepository.findById(1)).thenReturn(Optional.of(objetRecoltable));
        
        assertThrows(WrongToolException.class, ()-> recoltageService.utiliserOutil(personnage, 1, 10));
    }

    @Test
    public void givenObjetRecoltableWithResistance10_WhenOutilCapacite3_ThenReturn7() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        Personnage personnage = new Personnage("toto", 1);
        Outil outil1 = new Outil("outil1");
        outil1.setId(1);
        outil1.setCapacite(3);

        personnage.setOutil(outil1);
        objetRecoltable.addOutil(outil1);

        Mockito.when(objetRecoltableRepository.findById(1)).thenReturn(Optional.of(objetRecoltable));

        try {
            assertThat(recoltageService.utiliserOutil(personnage, 1, 10)).isEqualTo(7);
        } catch (WrongToolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
