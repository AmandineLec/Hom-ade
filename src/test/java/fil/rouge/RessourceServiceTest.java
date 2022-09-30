package fil.rouge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.dto.PersonnageDto;
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
    
    @Test
    public void given4Ressource_WhenPersoHasNoRessource_ThenReturn4() {
        Ressource ressource = new Ressource();
        ressource.setId(1);
        //PersonnageDto personnageDto = new PersonnageDto("toto", "tata");
        Personnage personnage = new Personnage();

        Mockito.when(personnageRepository.findByMail("toto")).thenReturn(Optional.of(personnage));

        Mockito.when(ressourceRepository.findById(1)).thenReturn(Optional.of(ressource));
        ressourceService.ajoutRessourceInventaire(personnage,1, 4);

        Iterator<InventaireRessource> it = personnage.getInventaireRessource().iterator();
        assertThat(it.next().getQuantite()).isEqualTo(4);
    }

    @Test
    public void given4Ressource_WhenPersoHas2Ressource_ThenReturn6() {
        Ressource ressource = new Ressource();
        ressource.setId(1);
        //PersonnageDto personnageDto = new PersonnageDto("toto", "tata");
        Personnage personnage = new Personnage();
        InventaireRessource inventaireRessource = new InventaireRessource(personnage, ressource, 2);
        personnage.addInventaireRessource(inventaireRessource);

        Mockito.when(personnageRepository.findByMail("toto")).thenReturn(Optional.of(personnage));

        Mockito.when(ressourceRepository.findById(1)).thenReturn(Optional.of(ressource));
        ressourceService.ajoutRessourceInventaire(personnage,1, 4);

        Iterator<InventaireRessource> it = personnage.getInventaireRessource().iterator();
        assertThat(it.next().getQuantite()).isEqualTo(6);
    }
}
