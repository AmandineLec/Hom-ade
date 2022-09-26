package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;
import fil.rouge.service.InventaireRessourceService;

@SpringBootTest
public class InventaireRessourceServiceTest {
    @Autowired 
    InventaireRessourceService inventaireRessourceService;

    @MockBean 
    InventaireRessourceRepository inventaireRessourceRepository;

    @Test
    public void InventaireRessourceServiceTestRetirerRessource(){
        Personnage personnage = new Personnage("Jpp", 1, 3); //Création d'un nouveau personnage
        List<InventaireRessource> ressources = new ArrayList<>(); //Création d'une array list d'inventaireressource
        Ressource ressource = new Ressource("RessourceTest", 3, "Typetest");//Création d'une ressource
        InventaireRessource inventaireRessource = new InventaireRessource(personnage);//On set un inventaire ressource au personnage
        ressources.add(inventaireRessource); //On ajoute l'inventaire ressource du personnage à la liste d'inventaire
        inventaireRessourceService.ajouterRessource(personnage, ressource.getId(), 4);
        inventaireRessourceService.retirerRessource(ressource.getId(), 1, personnage);//On retire une ressource de l'inventaire

        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(ressources);
        //On moque la requête pour qu'elle nous renvoie l'inventaire du personnage instancié
        assertTrue(inventaireRessource.getQuantite()==3);
    }
}
