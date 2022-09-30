package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.RecetteRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.exception.ReceiptsException;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Maison;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.model.Recette;
import fil.rouge.model.Ressource;
import fil.rouge.service.RecetteService;

@SpringBootTest
public class ReceiptsExceptionTest {
    @Autowired
    RecetteService recetteService; 

    @MockBean
    ObjetRepository objetRepository;

    @MockBean
    RecetteRepository recetteRepository;
    
    @MockBean
    RessourceRepository ressourceRepository; 

    @MockBean
    InventaireRessourceRepository inventaireRessourceRepository;

    @MockBean
    InventaireObjetRepository inventaireObjetRepository;

    @Test
    public void RecetteExceptionTestNiveau() throws ReceiptsException{
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        Objet obj = new Objet("Hache", 1);
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        Recette recette1 = new Recette(obj, ressource1, 2, 2);
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);
        InventaireRessource inventaireR = new InventaireRessource(personnage, ressource1, 4);
        personnage.addInventaireRessource(inventaireR);
        
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(obj);
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        inventaireRessources.add(inventaireR);
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);

        assertThrows(ReceiptsException.class, () -> recetteService.fusionnerRessource(obj.getId(), personnage));
    }

    @Test
    public void RecetteExceptionTestQuantite() throws ReceiptsException{
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        Objet obj = new Objet("Hache", 1);
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);
        InventaireRessource inventaireR = new InventaireRessource(personnage, ressource1, 1);
        personnage.addInventaireRessource(inventaireR);
        
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(obj);
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        inventaireRessources.add(inventaireR);
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);

        assertThrows(ReceiptsException.class, () -> recetteService.fusionnerRessource(obj.getId(), personnage));
    }
    @Test
    public void RecetteExceptionTestRessource() throws ReceiptsException{
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        Objet obj = new Objet("Hache", 1);
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        Ressource ressource2  = new Ressource("Ressource2", 2, "Test2");
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);
        InventaireRessource inventaireR = new InventaireRessource();
        inventaireR.setRessource(ressource2);
        personnage.addInventaireRessource(inventaireR);
        
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(obj);
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        inventaireRessources.add(inventaireR);
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);

        assertThrows(ReceiptsException.class, () -> recetteService.fusionnerRessource(obj.getId(), personnage));
    }

    @Test
    public void RecetteExceptionTestInventaireVide() throws ReceiptsException{
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        Objet obj = new Objet("Hache", 1);
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);
        
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(obj);
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);

        assertThrows(ReceiptsException.class, () -> recetteService.fusionnerRessource(obj.getId(), personnage));
    }
}
