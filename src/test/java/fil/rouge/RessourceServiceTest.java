package fil.rouge;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;
import fil.rouge.service.RessourceService;

@SpringBootTest
public class RessourceServiceTest {

    @Autowired
    private RessourceService ressourceService;

    @MockBean
    private RessourceRepository ressourceRepository;

    @MockBean
    private PersonnageRepository personnageRepository;

    @MockBean
    InventaireRessourceRepository inventaireRessourceRepository;
    
    @Test
    public void given4Ressource_WhenPersoHasNoRessource_ThenReturn4() {
        Ressource ressource = new Ressource();
        Personnage personnage = new Personnage();

        Mockito.when(personnageRepository.findByMail("toto")).thenReturn(Optional.of(personnage));

        Mockito.when(ressourceRepository.findById(1)).thenReturn(Optional.of(ressource));
        ressourceService.ajoutRessourceInventaire("toto",1, 4);

        Mockito.verify(inventaireRessourceRepository).save(ArgumentMatchers.argThat(invRes -> invRes.getQuantite() == 4));
    }

    @Test
    public void given4Ressource_WhenPersoHas2Ressource_ThenReturn6() {
        Ressource ressource = new Ressource();
        ressource.setId(1);
        Personnage personnage = new Personnage();
  
        InventaireRessource inventaireRessource = new InventaireRessource(personnage, ressource, 2);
        personnage.addInventaireRessource(inventaireRessource);

        Mockito.when(personnageRepository.findByMail("toto")).thenReturn(Optional.of(personnage));

        Mockito.when(ressourceRepository.findById(1)).thenReturn(Optional.of(ressource));
        ressourceService.ajoutRessourceInventaire("toto",1, 4);

        Mockito.verify(inventaireRessourceRepository).save(ArgumentMatchers.argThat(invRes -> invRes.getQuantite() == 6));
    }
}
