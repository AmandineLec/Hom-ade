package fil.rouge;

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
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetService;

@SpringBootTest
public class ObjetServiceTest {
    @Autowired
    ObjetService objetService; 

    @MockBean
    ObjetRepository oRepository; 

    @MockBean
    InventaireObjetRepository inventaireObjetRepository;

    @Test
    public void givenObjet_WhenFindById_ShouldreturnObjet(){

        //On instancie un nouveau personnage
        Personnage personnage = new Personnage("Jpp", 1, 3);
        //on instancie un nouvel objet qui sera utilisé pour le mockito
        Objet obj = new Objet("Hache", 2);
        //On instancie une liste optional qui sera utilisée pour le mockito. 
        Optional<Objet> objet = Optional.of(obj);
        //On instancie un nouvel inventaire objet que l'on attribue au personnage et on y ajoute l'inventaire précédemment instancié en quantité 1
        InventaireObjet inventaireObjet = new InventaireObjet(personnage, obj, 1);
        //On fait une liste Inventaire Objet que l'on va utilisé pour le mockito et on y ajoute l'inventaire de notre personnage. 
        List<InventaireObjet> inventaires = new ArrayList<>();
        inventaires.add(inventaireObjet);
        
        //On mocke l'objet repository "findByID" afin qu'il nous retourne la liste optional
        Mockito.when(oRepository.findById(2)).thenReturn(objet);
        //On mocke l'objet repository getReferenceById Afin qu'il nous retourne l'objet instancié
        Mockito.when(oRepository.getReferenceById(2)).thenReturn(obj);
        //On mocke inventaireObjetRepository afin qu'il nous retourne la liste d'inventaire
        Mockito.when(inventaireObjetRepository.findByPersonnage(personnage)).thenReturn(inventaires);
        //On utilise la méthode createObjet qui va créer le nouvel objet et l'ajouter à l'inventaire du personnage
        objetService.creerObjet(personnage, 2);
        //On vérifie que l'objet est bien présent dans l'inventaire. 
        assertTrue(inventaireObjet.getObjet().getNom()=="Hache");
    }
}
