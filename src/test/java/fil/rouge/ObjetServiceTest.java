package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.OutilException;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;
import fil.rouge.service.InventaireObjetService;
import fil.rouge.service.ObjetService;

@SpringBootTest
public class ObjetServiceTest {
    @Autowired
    ObjetService objetService; 

    @Autowired
    InventaireObjetService iOService;

    @MockBean
    ObjetRepository oRepository;

    @MockBean
    InventaireObjetRepository iORepository;

    @MockBean
    PersonnageRepository pRepository;

    @Test
    public void givenObjet_WhenFindById_ShouldreturnObjet(){

        //On instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //on instancie un nouvel objet qui sera utilisé pour le mockito
        Objet obj = new Objet("Hache", 2);
        //On fait une liste Inventaire Objet que l'on va utilisé pour le mockito et on y ajoute l'inventaire de notre personnage. 
        List<InventaireObjet> inventaires = new ArrayList<>();
        
        //On mocke l'objet repository getReferenceById Afin qu'il nous retourne l'objet instancié
        Mockito.when(oRepository.getReferenceById(2)).thenReturn(obj);
        //On mocke inventaireObjetRepository afin qu'il nous retourne la liste d'inventaire
        Mockito.when(iORepository.findByPersonnage(personnage)).thenReturn(inventaires);
        //On utilise la méthode createObjet qui va créer le nouvel objet et l'ajouter à l'inventaire du personnage
        objetService.creerObjet(personnage, 2);
        //On vérifie que l'objet est bien présent dans l'inventaire. 
        assertTrue(personnage.getInventaireObjet().size()==1);
    }

    @Test
    public void givenObjet_WhengetReferenceById_ShouldreturnQuantityIncrement(){
        //On instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //on instancie un nouvel objet qui sera utilisé pour le mockito
        Objet obj = new Objet("Hache", 2);
        //On instancie un nouvel inventaire objet que l'on attribue au personnage et on y ajoute l'inventaire précédemment instancié en quantité 1
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, obj, 1);
        //On fait une liste Inventaire Objet que l'on va utilisé pour le mockito et on y ajoute l'inventaire de notre personnage. 
        List<InventaireObjet> inventaires = new ArrayList<>();
        //On ajoute l'inventaire à la liste qui sera mocké. 
        inventaires.add(inventaireObjet);
        personnage.addInventaireObjet(inventaireObjet);
        
        //On mocke l'objet repository getReferenceById Afin qu'il nous retourne l'objet instancié
        Mockito.when(oRepository.getReferenceById(2)).thenReturn(obj);
        //On mocke inventaireObjetRepository afin qu'il nous retourne la liste d'inventaire
        Mockito.when(iORepository.findByPersonnage(personnage)).thenReturn(inventaires);
        //On utilise la méthode createObjet qui va créer le nouvel objet et l'ajouter à l'inventaire du personnage
        objetService.creerObjet(personnage, 2);
        //On vérifie que l'objet est bien présent dans l'inventaire. 
        assertTrue(inventaireObjet.getQuantite()==2);
    }
    @Test
    public void givenObjet_WhengetReferenceById_ShouldreturnTwoObjetInInventory(){
        //On instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, "mail", "password", 1);
        //on instancie un nouvel objet qui sera utilisé pour le mockito
        Objet obj = new Objet("Hache", 2);
        Objet objet = new Objet("Objet", 1); 
        //On instancie un nouvel inventaire objet que l'on attribue au personnage et on y ajoute l'inventaire précédemment instancié en quantité 1
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, objet, 1);
        //On fait une liste Inventaire Objet que l'on va utilisé pour le mockito et on y ajoute l'inventaire de notre personnage. 
        List<InventaireObjet> inventaires = new ArrayList<>();
        //On ajoute l'inventaire à la liste qui sera mocké. 
        inventaires.add(inventaireObjet);
        personnage.addInventaireObjet(inventaireObjet);
        
        //On mocke l'objet repository getReferenceById Afin qu'il nous retourne l'objet instancié
        Mockito.when(oRepository.getReferenceById(2)).thenReturn(obj);
        //On mocke inventaireObjetRepository afin qu'il nous retourne la liste d'inventaire
        Mockito.when(iORepository.findByPersonnage(personnage)).thenReturn(inventaires);
        //On utilise la méthode createObjet qui va créer le nouvel objet et l'ajouter à l'inventaire du personnage
        objetService.creerObjet(personnage, 2);
        //On vérifie que l'objet est bien présent dans l'inventaire. 
        assertTrue(personnage.getInventaireObjet().size()==2);
    }

    // Tests Equiper outil
    @Test
    public void whenValidMail_ThenThrowExceptionIfOutilAlreadySet(){
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456"));
        Outil outil = new Outil(1);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);
        iOService.ajouterObjet(perso.get(), 1, 1);
        Outil outil2 = new Outil(1);
        perso.get().setOutil(outil2);

        assertThrows(OutilException.class, () -> objetService.equiperOutil(31, outil));
    }

    @Test
    public void givenValidMail_WhenOutilPresent_ThenEquiper() throws OutilException{
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456", 31));
        Outil outil = new Outil(1, 1);
        Outil outil2 = new Outil(2, 1);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);
        Mockito.when(oRepository.getReferenceById(2)).thenReturn(outil2);
        iOService.ajouterObjet(perso.get(), outil.getId(), 1);
        iOService.ajouterObjet(perso.get(), outil2.getId(), 1);
        perso.get().setOutil(outil2);

        assertTrue(objetService.equiperOutil(31, outil));
    }

    @Test
    public void givenValidMail_WhenOutilAlreadyEquiped_ThenThrowException() throws OutilException{
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456"));
        Outil outil = new Outil(1);
        Outil outil2 = new Outil(1);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);
        iOService.ajouterObjet(perso.get(), outil.getId(), 1);
        iOService.ajouterObjet(perso.get(), outil2.getId(), 1);
        perso.get().setOutil(outil2);

        assertThrows(OutilException.class, () -> objetService.equiperOutil(31, outil));
    }

    @Test
    public void givenValidMail_WhenOutilNotPresent_ThenThrowException() throws OutilException{
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456"));
        Outil outil = new Outil(1);
        Outil outil2 = new Outil(1);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);
        iOService.ajouterObjet(perso.get(), outil2.getId(), 1);
        perso.get().setOutil(outil2);

        assertThrows(OutilException.class, () -> objetService.equiperOutil(31, outil));
    }

    // Tests Déséquiper 

    @Test
    public void givenValidMail_WhenOutilEquiped_ThenDesequiper() throws OutilException{
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456", 31));
        Outil outil = new Outil(1, 1);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);
        iOService.ajouterObjet(perso.get(), outil.getId(), 1);
        perso.get().setOutil(outil);

        assertTrue(objetService.desequiperOutil(31, outil.getId()));
    }

    @Test
    public void givenValidMail_WhenOutilNotEquiped_ThenThrowException() throws OutilException{
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456"));
        Outil outil = new Outil(1);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);

        assertThrows(OutilException.class, () -> objetService.desequiperOutil(31, outil.getId()));
    }

    @Test
    public void givenValidMail_WhenWrongOutilEquiped_ThenThrowException() throws OutilException{
        Optional<Personnage> perso = Optional.of(new Personnage("Bob", 1, "bob@bob.bob", "123456"));
        Outil outil = new Outil(1);
        Outil outil2 = new Outil(2);
        List<InventaireObjet> objets = new ArrayList<>();
        Mockito.when(pRepository.findById(31)).thenReturn(perso);
        Mockito.when(iORepository.findByPersonnage(perso.get())).thenReturn(objets); 
        Mockito.when(oRepository.getReferenceById(1)).thenReturn(outil);
        Mockito.when(oRepository.getReferenceById(2)).thenReturn(outil2);

        iOService.ajouterObjet(perso.get(), outil2.getId(), 1);
        perso.get().setOutil(outil2);

        assertThrows(OutilException.class, () -> objetService.desequiperOutil(31, outil.getId()));
    }
    
}
