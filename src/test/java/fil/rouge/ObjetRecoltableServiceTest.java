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
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetRecoltableService;

@SpringBootTest
public class ObjetRecoltableServiceTest {
    
    @Autowired
    private ObjetRecoltableService objetRecoltableService;

    @MockBean
    private ObjetRecoltableRepository objetRecoltableRepository;

    @MockBean
    private PersonnageRepository personnageRepository;
    
    @Test
    public void givenObjetRecoltable_WhenOutilNotInOutils_ThenThrowsException() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        Personnage personnage = new Personnage();
        ObjetRecoltableDTO oDto = new ObjetRecoltableDTO();
        oDto.setIdObjetRecoltable(1);
        oDto.setPv(10);
        Outil outil1 = new Outil("outil1");
        outil1.setId(1);
        Outil outil2 = new Outil("outil2");
        outil2.setId(2);
        Outil outil3 = new Outil("outil3");
        outil3.setId(3);
        
        personnage.setOutil(outil1);
        objetRecoltable.addOutil(outil2);
        objetRecoltable.addOutil(outil3);
        Mockito.when(personnageRepository.findByMail("toto")).thenReturn(Optional.of(personnage));
        Mockito.when(objetRecoltableRepository.findById(1)).thenReturn(Optional.of(objetRecoltable));
                      
        assertThrows(WrongToolException.class, ()-> objetRecoltableService.utiliserOutil(personnage, oDto));
    }

    @Test
    public void givenObjetRecoltableWithPv10_WhenOutilCapacite3_ThenReturn7() {
        ObjetRecoltable objetRecoltable = new ObjetRecoltable();
        Personnage personnage = new Personnage();
        ObjetRecoltableDTO oDto = new ObjetRecoltableDTO();
        Outil outil1 = new Outil("outil1");
        outil1.setId(1);
        outil1.setCapacite(3);
        oDto.setIdObjetRecoltable(1);
        oDto.setPv(10);

        personnage.setOutil(outil1);
        objetRecoltable.addOutil(outil1);
        Mockito.when(personnageRepository.findByMail("toto")).thenReturn(Optional.of(personnage));
        Mockito.when(objetRecoltableRepository.findById(1)).thenReturn(Optional.of(objetRecoltable));
        try {
            assertThat(objetRecoltableService.utiliserOutil(personnage, oDto)).isEqualTo(7);
        } catch (WrongToolException e) {
            
            e.printStackTrace();
        }
    }

    @Test
    public void givenObjetRecoltableDisparait_WhenReapparaitBeforeCooldown_ThenReturnFalse() {
        ObjetRecoltableDTO objetRecoltable = new ObjetRecoltableDTO();
        objetRecoltable.setCooldown(100);
        
        objetRecoltableService.disparait(objetRecoltable);
        assertThat(objetRecoltableService.reapparait(objetRecoltable)).isFalse();
    }

    @Test
    public void givenObjetRecoltableDisparait_WhenReapparaitAfterCooldown_ThenReturnTrue() {
        ObjetRecoltableDTO objetRecoltable = new ObjetRecoltableDTO();
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
