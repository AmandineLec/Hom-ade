package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetService;

@SpringBootTest
public class ObjetServiceTest {
    @Autowired
    ObjetService objetService; 

    @MockBean
    ObjetRepository oRepository; 
    @Test
    public void givenObjet_WhenFindById_ShouldreturnObjet(){

        Personnage personnage = new Personnage("Jpp", 1, 3);
        Objet obj = new Objet("Hache", 2);
        Optional<Objet> objet = Optional.of(obj);
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, obj, 1);

        Mockito.when(oRepository.findById(2)).thenReturn(objet);
        objetService.createObject(personnage, 2);
        assertTrue(personnage.getInventaireObjet().contains(inventaireObjet));
    }
}
