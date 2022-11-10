package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.service.InventaireObjetService;

@SpringBootTest
public class InventaireObjetServiceTest {

    @Autowired 
    InventaireObjetService inventaireObjetService;

    @MockBean 
    InventaireObjetRepository inventaireObjetRepository;

    @MockBean
    ObjetRepository objetRepository;

    @Test
    public void InventaireObjetServiceTestAjouterObjet(){
        //On instancie un personnage test
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie un objet test
        Objet objet = new Objet("Hache", 1);
        //ON instancie une liste "Inventaire objet" qui va nous servir pour le mockito
        List<InventaireObjet> objets = new ArrayList<>();
        //On mocke le inventaireObjetRepository pour le test, et on lui renvoie la liste d'inventaireobjet instanciée plus haut.
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(objets); 
        //On moque également le objetRepository qui est utilisé dans la méthode "ajouterObjet" afin de la mocké et ne pas avoir de nullpointerexception
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(objet);
        //On utilise la méthode à tester
        inventaireObjetService.ajouterObjet(personnage, 1, 1);
        //On vérifie que l'inventaire du personnage a bien été créé, et qu'il a une taille de 1 (et donc qu'il contient qqch)
        assertTrue(personnage.getInventaireObjet().size()==1);
    }

    @Test
    public void InventaireObjetServiceTestAjouterDeuxObjet(){
        //On instancie un personnage test
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie un objet test
        Objet objet = new Objet("Hache", 1);
        Objet objetTest = new Objet("Objet", 2);
        //On instancie un inventaire objet que l'on ajoute au personnage
        //ON instancie une liste "Inventaire objet" qui va nous servir pour le mockito
        List<InventaireObjet> objets = new ArrayList<>();
        //On mocke le inventaireObjetRepository pour le test, et on lui renvoie la liste d'inventaireobjet instanciée plus haut.
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(objets); 
        //On moque également le objetRepository qui est utilisé dans la méthode "ajouterObjet" afin de la mocké et ne pas avoir de nullpointerexception
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(objet);
        Mockito.when(objetRepository.getReferenceById(2)).thenReturn(objetTest);
        //On utilise la méthode à tester
        inventaireObjetService.ajouterObjet(personnage, 1, 1);
        inventaireObjetService.ajouterObjet(personnage, 2, 1);
        //On vérifie que l'inventaire du personnage a bien été créé, et qu'il a une taille de 1 (et donc qu'il contient qqch)
        assertTrue(personnage.getInventaireObjet().size()==2);
    }
    
    @Test
    public void InventaireObejtServiceTestRetirerObjet(){
        //On instancie un personnage test
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //On instancie un objet test
        Objet objet = new Objet("Hache", 1);
        //On instancie une liste d''inventaire objet
        List<InventaireObjet> objets = new ArrayList<>();
        //On set un inventaire au personnage contenant de base l'objet en 3 exemplaires
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, objet, 3);
        //On ajoute l'inventaire du personnage à la liste inventaire objet 
        objets.add(inventaireObjet);
        //On mocke l'inventaire objet repository pour le test et on lui renvoie la liste d'inventaire objet instancié plus haut
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(objets); 
        //On mocke l'objet repository afin de ne pas avoir de nullpointerexception
        Mockito.when(objetRepository.getReferenceById(1)).thenReturn(objet);
        //On retire un objet de l'inventaire du personnage
        inventaireObjetService.retirerObjet(objet.getId(), 1, personnage);

        //On vérifie que la quantité présente dans l'inventaire est de 2
        assertTrue(inventaireObjet.getQuantite()==2);
    }
}
