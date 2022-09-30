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
import fil.rouge.dao.RessourceRepository;
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

    @MockBean
    RessourceRepository ressourceRepository;

    @Test
    public void InventaireRessourceServiceTestAjouterRessource(){
        //ON instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //ON instancie une nouvelle ressource
        Ressource ressource = new Ressource("Ressourcetest", 1, "Test");
        //On instancie un nouvel inventaire ressource que l'on "set"à notre personnage, avec la ressource présente dans l'inventaire mais en quantité 0
        InventaireRessource inventaireRessource = new InventaireRessource(personnage, ressource, 0);
        //On fait une liste d'inventaire ressource que l'on utilisera pour le mockito et on y ajoute l'inventaire de notre personnage. 
        List<InventaireRessource> ressources = new ArrayList<>();
        ressources.add(inventaireRessource);

        //On mocke la requête "findByPersonnage" du InventaireRessourceReposiroty afin qu'il nous renvoie notre liste d'inventaireRessource
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(ressources); 
        //On mocke également le ressourcerepository présent dans la méthode "ajouterRessource" afin que 
        //La ressource instanciée nous soit retournée et ne pas avoir de nullpointerexception
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource);
        //On utilise la méthode ajouterRessource afin d'ajouter la ressource à l'inventaire du personnage en quantité 4
        inventaireRessourceService.ajouterRessource(ressource.getId(), personnage, 4);

        //ON vérifie que la ressource est présente dans l'inventaire en quantité 4 et donc qu'elle a correctement été ajoutée à l'inventaire
        assertTrue(inventaireRessource.getQuantite()==4);
    }
    
    @Test
    public void InventaireRessourceServiceTestRetirerRessource(){

        //On instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie une nouvelle ressource
        Ressource ressource = new Ressource("Ressourcetest", 1, "Test");
        //On instancie un nouvel inventaire ressource que l'on attribue au personnage avec ma ressource présente dans l'inventaire en quantité 4
        InventaireRessource inventaireRessource = new InventaireRessource(personnage, ressource, 4);
        //On fait une list d'inventaire ressource que l'on va utiliser pour le mockito puis on y ajoute l'inventaire du personnage
        List<InventaireRessource> ressources = new ArrayList<>();
        ressources.add(inventaireRessource);

        //On mocke la requête "findByPersonnage" du InventaireRessourceReposiroty afin qu'il nous renvoie notre liste d'inventaireRessource
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(ressources); 
        //On mocke également le ressourcerepository présent dans la méthode "ajouterRessource" afin que 
        //La ressource instanciée nous soit retournée et ne pas avoir de nullpointerexception
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource);
        //On retire une ressource de l'inventaire
        inventaireRessourceService.retirerRessource(ressource.getId(), 1, personnage);

        //On vérifie que la quantité de la ressource est bien égale à 3 et qu'une a bien été enlevée. 
        assertTrue(inventaireRessource.getQuantite()==3);
    }
}
