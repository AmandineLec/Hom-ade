package fil.rouge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.RessourceRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;
import fil.rouge.service.RessourceService;

@SpringBootTest
public class RamassageServiceTest {

    @Autowired
    RessourceService ressourceService;

    @MockBean
    RessourceRepository ressourceRepository;
    
    @Test
    public void given4Ressource_WhenPersoHasNoRessource_ThenReturn4() {
        Ressource ressource = new Ressource();
        ressource.setId(1);
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);

        Mockito.when(ressourceRepository.findById(1)).thenReturn(Optional.of(ressource));
        ressourceService.ajoutRessourceInventaire(personnage,1, 4);

        Iterator<InventaireRessource> it = personnage.getInventaireRessource().iterator();
        assertThat(it.next().getQuantite()).isEqualTo(4);
    }

    @Test
    public void given4Ressource_WhenPersoHas2Ressource_ThenReturn6() {
        Ressource ressource = new Ressource();
        ressource.setId(1);
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        InventaireRessource inventaireRessource = new InventaireRessource(personnage, ressource, 2);
        personnage.addInventaireRessource(inventaireRessource);

        Mockito.when(ressourceRepository.findById(1)).thenReturn(Optional.of(ressource));
        ressourceService.ajoutRessourceInventaire(personnage,1, 4);

        Iterator<InventaireRessource> it = personnage.getInventaireRessource().iterator();
        assertThat(it.next().getQuantite()).isEqualTo(6);
    }
}
