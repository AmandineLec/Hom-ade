package fil.rouge;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

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
import fil.rouge.exception.ReceiptsQuantityException;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Maison;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.model.Recette;
import fil.rouge.model.Ressource;
import fil.rouge.service.RecetteService;

@SpringBootTest
public class RecetteServiceTest {
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
    public void givenRcette_WhengetReferenceById_ShouldReturnAnObjectInInventory() throws ReceiptsException, ReceiptsQuantityException{
        //On instancie un nouveau personnage 
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie un nouvel objet
        Objet obj = new Objet("Hache", 2);
        //On instancie une nouvelle ressource qui sera utilisée pour le mockito
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        //On instancie une nouvelle recette, lié à l'objet "Hache" et à la ressource 3, on "set" la quantité nécessaire
        //que l'on doit posséder dans son inventaire pour créer l'objet ainsi que le niveau requis pour pouvoir réaliser la recette
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        //On instancie une nouvelle maison que l'on va attribuer au personnage puisque c'est la maison qui détermine le niveau du personnage. 
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);

        //On instancie l'inventaireRessource que l'on attribue au personnage et on lui donne la ressource en quantité 4
        InventaireRessource inventaireR = new InventaireRessource(personnage, ressource1, 4);
        personnage.addInventaireRessource(inventaireR);

        
        //On vient mocker l'objet repository "getreferencebyId" pour qu'il nous retourne l'objet "Hache"
        Mockito.when(objetRepository.getReferenceById(2)).thenReturn(obj);
        //On vient mocker le ressourcerepository "getReferenceById" pour qu'il nous retourne la ressource1
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        //On vient créer une nouvelle liste de Recette que l'on va utilisé pour le mockito et on y ajouter la recette1
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        //On mocke le recetterepository "findByObjet" qui doit nous retourner toutes les lignes d'une recette en fonction de 
        //L'id d'un objet. Ici, il doit nous retourner toutes les ressources nécessaires pour la création de l'objet "Hache"
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        //On crée un nouvel liste d'inventaireRessource que l'on va utilisé pour le mockito et on y ajoute l'inventaire ressource du personnage
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        inventaireRessources.add(inventaireR);
        //On mocke l'inventaireRessourceRepository pour qu'il nous retourne la liste des inventaires ressources
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        //On crée un nouvel liste d'inventaireObjet que l'on va utilisé pour le mockito
        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        //On mocke l'inventaireObjetRepository pour qu'il nous retourne la liste des inventaires objets
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);

        //On vient utiliser la méthode fusionnerRessource qui doit vérifier que le personnage possède le niveau nécessaire pour créer un objet, 
        //ainsi que les ressources demandées en quantité suffisante. Si oui, on crée un nouvel objet, on l'ajoute à l'inventaire
        //Du personnage et on lui retire les ressource consommer de son inventaire. 
        recetteService.fusionnerRessource(obj.getId(), personnage);
        //On vérifie que l'inventaire objet du personnage possède bien deux objets. 
        assertTrue(personnage.getInventaireObjet().size()==1);
    }

    @Test
    public void givenRcette_WhengetReferenceById_ShouldaddAnObjectInInventory() throws ReceiptsException, ReceiptsQuantityException{
        //On instancie un nouveau personnage 
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie deux nouveaux objets
        Objet obj = new Objet("Hache", 2);
        Objet objet = new Objet("Objet", 1);
        //On instancie un inventaire auquel on ajoute un objet et on l'attribue au personnage
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, objet, 1);
        personnage.addInventaireObjet(inventaireObjet);
        //On instancie une nouvelle ressource qui sera utilisée pour le mockito
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        //On instancie une nouvelle recette, lié à l'objet "Hache" et à la ressource 3, on "set" la quantité nécessaire
        //que l'on doit posséder dans son inventaire pour créer l'objet ainsi que le niveau requis pour pouvoir réaliser la recette
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        //On instancie une nouvelle maison que l'on va attribuer au personnage puisque c'est la maison qui détermine le niveau du personnage. 
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);

        //On instancie l'inventaireRessource que l'on attribue au personnage et on lui donne la ressource en quantité 4
        InventaireRessource inventaireR = new InventaireRessource(personnage, ressource1, 4);
        personnage.addInventaireRessource(inventaireR);

        
        //On vient mocker l'objet repository "getreferencebyId" pour qu'il nous retourne l'objet "Hache"
        Mockito.when(objetRepository.getReferenceById(2)).thenReturn(obj);
        //On vient mocker le ressourcerepository "getReferenceById" pour qu'il nous retourne la ressource1
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        //On vient créer une nouvelle liste de Recette que l'on va utilisé pour le mockito et on y ajouter la recette1
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        //On mocke le recetterepository "findByObjet" qui doit nous retourner toutes les lignes d'une recette en fonction de 
        //L'id d'un objet. Ici, il doit nous retourner toutes les ressources nécessaires pour la création de l'objet "Hache"
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        //On crée un nouvel liste d'inventaireRessource que l'on va utilisé pour le mockito et on y ajoute l'inventaire ressource du personnage
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        inventaireRessources.add(inventaireR);
        //On mocke l'inventaireRessourceRepository pour qu'il nous retourne la liste des inventaires ressources
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        //On crée un nouvel liste d'inventaireObjet que l'on va utilisé pour le mockito
        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        //On mocke l'inventaireObjetRepository pour qu'il nous retourne la liste des inventaires objets
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);
        inventaireObjets.add(inventaireObjet);

        //On vient utiliser la méthode fusionnerRessource qui doit vérifier que le personnage possède le niveau nécessaire pour créer un objet, 
        //ainsi que les ressources demandées en quantité suffisante. Si oui, on crée un nouvel objet, on l'ajoute à l'inventaire
        //Du personnage et on lui retire les ressource consommer de son inventaire. 
        recetteService.fusionnerRessource(obj.getId(), personnage);
        //On vérifie que l'inventaire objet du personnage possède bien deux objets. 
        assertTrue(personnage.getInventaireObjet().size()==2);
    }

    @Test
    public void givenRcette_WhengetReferenceById_ShouldIncrementQuantity() throws ReceiptsException, ReceiptsQuantityException{
        //On instancie un nouveau personnage 
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie un nouvel objet
        Objet obj = new Objet("Hache", 2);
        //On instancie un inventaire auquel on ajoute un objet et on l'attribue au personnage
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, obj, 1);
        personnage.addInventaireObjet(inventaireObjet);
        //On instancie une nouvelle ressource qui sera utilisée pour le mockito
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        //On instancie une nouvelle recette, lié à l'objet "Hache" et à la ressource 3, on "set" la quantité nécessaire
        //que l'on doit posséder dans son inventaire pour créer l'objet ainsi que le niveau requis pour pouvoir réaliser la recette
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        //On instancie une nouvelle maison que l'on va attribuer au personnage puisque c'est la maison qui détermine le niveau du personnage. 
        Maison maison = new Maison(1, 1);
        personnage.setMaison(maison);

        //On instancie l'inventaireRessource que l'on attribue au personnage et on lui donne la ressource en quantité 4
        InventaireRessource inventaireR = new InventaireRessource(personnage, ressource1, 4);
        personnage.addInventaireRessource(inventaireR);

        
        //On vient mocker l'objet repository "getreferencebyId" pour qu'il nous retourne l'objet "Hache"
        Mockito.when(objetRepository.getReferenceById(2)).thenReturn(obj);
        //On vient mocker le ressourcerepository "getReferenceById" pour qu'il nous retourne la ressource1
        Mockito.when(ressourceRepository.getReferenceById(1)).thenReturn(ressource1);
        //On vient créer une nouvelle liste de Recette que l'on va utilisé pour le mockito et on y ajouter la recette1
        List<Recette> recettes = new ArrayList<>();
        recettes.add(recette1);
        //On mocke le recetterepository "findByObjet" qui doit nous retourner toutes les lignes d'une recette en fonction de 
        //L'id d'un objet. Ici, il doit nous retourner toutes les ressources nécessaires pour la création de l'objet "Hache"
        Mockito.when(recetteRepository.findByObjet(obj)).thenReturn(recettes);
        
        //On crée un nouvel liste d'inventaireRessource que l'on va utilisé pour le mockito et on y ajoute l'inventaire ressource du personnage
        List<InventaireRessource> inventaireRessources = new ArrayList<>();
        inventaireRessources.add(inventaireR);
        //On mocke l'inventaireRessourceRepository pour qu'il nous retourne la liste des inventaires ressources
        Mockito.when(inventaireRessourceRepository.findByPersonnage(personnage)).thenReturn(inventaireRessources);

        //On crée un nouvel liste d'inventaireObjet que l'on va utilisé pour le mockito
        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        //On mocke l'inventaireObjetRepository pour qu'il nous retourne la liste des inventaires objets
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);
        inventaireObjets.add(inventaireObjet);

        //On vient utiliser la méthode fusionnerRessource qui doit vérifier que le personnage possède le niveau nécessaire pour créer un objet, 
        //ainsi que les ressources demandées en quantité suffisante. Si oui, on crée un nouvel objet, on l'ajoute à l'inventaire
        //Du personnage et on lui retire les ressource consommer de son inventaire. 
        recetteService.fusionnerRessource(obj.getId(), personnage);
        //On vérifie que l'inventaire objet du personnage possède bien deux objets. 
        assertTrue(inventaireObjet.getQuantite()==2);
    }
    
    
}
