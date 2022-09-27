package fil.rouge;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void RecetteTest(){
        //On instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, 3);
        //On instancie deux nouveaux objets afin de vérifier qu'un nouvel objet est bien ajouté dans un inventaire quand des objets y sont déjà présents
        Objet objet = new Objet("Objet", 3);
        Objet obj = new Objet("Hache", 2);
        //On instancie une nouvelle ressource qui sera utilisée pour le mockito
        Ressource ressource1 = new Ressource("Ressource1", 1, "Test1");
        //On instancie une nouvelle recette, lié à l'objet "Hache" et à la ressource 3, on "set" la quantité nécessaire
        //que l'on doit posséder dans son inventaire pour créer l'objet ainsi que le niveau requis pour pouvoir
        //Réaliser la recette
        Recette recette1 = new Recette(obj, ressource1, 2, 1);
        //On instancie une nouvelle maison que l'on va attribuer au personnage puisque c'est la maison qui détermine le niveau du personnage. 
        Maison maison = new Maison(1, 1, 1);
        personnage.setMaison(maison);
        //On instancie l'inventaireRessource que l'on attribue au personnage et on lui donne la ressource en quantité 4
        InventaireRessource inventaireR = new InventaireRessource(personnage, ressource1, 4);
        //On instancie l'inventaire objet que l'on attribue au personnage et on lui donne un objet en quantité 1
        InventaireObjet inventaireO = new InventaireObjet(personnage, objet, 1);
        
        //On vient mocket l'objet repository "getreferencebyId" pour qu'il nous retourne l'objet "Hache"
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

        //On crée un nouvel liste d'inventaireObjet que l'on va utilisé pour le mockito et on y ajoute l'inventaire objet du personnage
        List<InventaireObjet> inventaireObjets = new ArrayList<>();
        inventaireObjets.add(inventaireO);
        //On mocke l'inventaireObjetRepository pour qu'il nous retourne la liste des inventaires objets
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaireObjets);

        //On vient utiliser la méthode fusionnerRessource qui doit vérifier que le personnage possède le niveau nécessaire pour créer un objet, 
        //ainsi que les ressources demandées en quantité suffisante. Si oui, on crée un nouvel objet, on l'ajoute à l'inventaire
        //Du personnage et on lui retire les ressource consommer de son inventaire. 
        recetteService.fusionnerRessource(obj.getId(), personnage);
        //On vérifie que l'inventaire objet du personnage possède bien deux objets. 
        assertThat(personnage.getInventaireObjet().size()==2);


    }

    
}
