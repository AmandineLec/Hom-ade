package fil.rouge;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.MailAlreadyUsedException;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.service.InventaireObjetService;
import fil.rouge.service.PersonnageService;

@SpringBootTest
public class PersonnageServiceTest {
    
    @Autowired
    PersonnageService pService;

    @MockBean
    InventaireObjetService inventaireObjetService;



    @MockBean
    ObjetRepository objRepo;

    @MockBean
    PersonnageRepository pRepository;

    @MockBean
    InventaireObjetRepository iORepository;

    @MockBean
    ObjetRepository oRepository;

    @Autowired
    InventaireObjetService iOService;

    @Test
    public void WhenInvalidInscription_ThenThrowsException() {

        List<Personnage> personnages = new ArrayList<Personnage>();
        Personnage perso = new Personnage("Pierre", 1, "marie@mail.fr", "123");
        personnages.add(perso);
        personnages.stream()
            .map(x -> x.getName());

        Mockito.when(pRepository.findAll()).thenReturn(personnages);

        assertThrows(MailAlreadyUsedException.class, () -> pService.inscription("marie@mail.fr", "1254", "Paul", 2));
    }

    @Test
    public void whenValidInscription_ThenSavedPersonnageHasMaison()
    {
        try{
            pService.inscription("marie@mail.fr", "1254", "Paul", 2);
        }
        catch(Exception e){
            System.out.println("Un affichage inutile dans la console juste pour ne pas rien mettre");
        }
        /* Syntaxes pour faire une v??rification d'un argument de m??thode :
        * ArgumentMatcher<Personnage> matcher = this::checkPersonnageHasMaison;
        * matcher = x -> x.getMaison() != null;
        */

        /*
         * Ce que fait Mockito.verify :
         * 
         * Demande ?? Mockito de v??rifier si la m??thode "save" a ??t?? appel??e
         * sur pRepository.
         * 
         * Puis demande ?? Mockito de v??rifier si l'argument pass?? ?? "save" (donc un personnage)
         * satisfait un test (ici "personnage.getMaison() != null")
         */
        Mockito.verify(pRepository).save(ArgumentMatchers.argThat(this::checkPersonnageHasMaison));
    }

    @Test
    public void whenValidInscription_ThenSavedPersonnageHasMail()
    {
        try{
            pService.inscription("marie@mail.fr", "1254", "Paul", 2);
        }
        catch(Exception e){

        }
        Mockito.verify(pRepository).save(ArgumentMatchers.argThat(this::checkPersonnageHasMail));
    }

    @Test
    public void whenValidInscription_ThenSavedPersonnageHasPassword()
    {
        try{
            pService.inscription("marie@mail.fr", "1254", "Paul", 2);
        }
        catch(Exception e){

        }
        Mockito.verify(pRepository).save(ArgumentMatchers.argThat(this::checkPersonnageHasPassword));
    }

    @Test
    public void whenValidInscription_ThenSavedPersonnageIsFemale()
    {
        try{
            pService.inscription("marie@mail.fr", "1254", "Paul", 2);
        }
        catch(Exception e){

        }
        Mockito.verify(pRepository).save(ArgumentMatchers.argThat(this::checkPersonnageIsFemale));
    }

    @Test
    public void whenValidInscription_ThenSavedPersonnageIsMale()
    {
        try{
            pService.inscription("marie@mail.fr", "1254", "Paul", 1);
        }
        catch(Exception e){

        }
        Mockito.verify(pRepository).save(ArgumentMatchers.argThat(this::checkPersonnageIsMale));
    }

    @Test
    public void givenMailAndPassword_WhenNotFoundPersoWithMailAndPassword_ThenThrowsException() {

        List<Personnage> personnages = new ArrayList<Personnage>();
        Personnage perso = new Personnage("Pierre", 1, "marie@mail.fr", "123");
        personnages.add(perso);
        personnages.stream().map(x -> x.getMail());
        personnages.stream().map(x -> x.getPassword());

        Mockito.when(pRepository.findAll()).thenReturn(personnages);

        assertThrows(NoSuchElementException.class, () -> pService.suppressionPartie("paul@mail.fr", "1234"));
    }

    @Test
    public void whenValidMailAndPassword_ThenDeletePersonnage(){
        Optional<Personnage> personnage = Optional.of(new Personnage("bob", 1, "marie@mail.fr", "1234"));
        Mockito.when(pRepository.findByMailAndPassword("marie@mail.fr", "1234")).thenReturn(personnage);
        pService.suppressionPartie("marie@mail.fr", "1234");
       
        Mockito.verify(pRepository).delete(personnage.get());
    }

    @Test
    public void whenWrongMailAndGoodPassword_ThenNoConnexion(){
        Optional<Personnage> personnage = Optional.of(new Personnage());
        Mockito.when(pRepository.findByMailAndPassword("marie@mail.fr", "1234")).thenReturn(personnage);
       
        assertThrows(NoSuchElementException.class, () -> pService.connexionPartie("mari@mail.fr", "1234"));
    }

    @Test
    public void whenGoodMailAndWrongPassword_ThenNoConnexion(){
        Optional<Personnage> personnage = Optional.of(new Personnage());
        Mockito.when(pRepository.findByMailAndPassword("marie@mail.fr", "1234")).thenReturn(personnage);
       
        assertThrows(NoSuchElementException.class, () -> pService.connexionPartie("marie@mail.fr", "234"));
    }

    @Test
    public void whenValidMailAndPassword_ThenConnexion(){
        Optional<Personnage> personnage = Optional.of(new Personnage());
        Mockito.when(pRepository.findByMailAndPassword("marie@mail.fr", "1234")).thenReturn(personnage);
        pService.connexionPartie("marie@mail.fr", "1234");
    
        assertFalse(personnage.isEmpty());
    }

    @Test
    public void whenWrongMailAndGoodPassowrd_ThenThrowsException(){
        Optional<Personnage> personnage = Optional.of(new Personnage());
        Mockito.when(pRepository.findByMailAndPassword("mari@mail.fr", "1234")).thenReturn(personnage);
        assertThrows(NoSuchElementException.class, () -> pService.modificationMail(personnage.get(), personnage.get().getMail(), personnage.get().getPassword(), "m@g.f"));
    }

    @Test
    public void whenValidMailAndPassword_ThenModifyMail(){
        Optional<Personnage> personnage = Optional.of(new Personnage());
        Mockito.when(pRepository.findByMailAndPassword("marie@mail.fr", "1234")).thenReturn(personnage);
        pService.modificationMail(personnage.get(), "marie@mail.fr", "1234","m@g.f");
    
        assertEquals(personnage.get().getMail(), "m@g.f");
    }

    
    //#region Verification Arguments
    private boolean checkPersonnageHasMaison(Personnage personnage)
    {
        return personnage.getMaison() != null;
    }

    private boolean checkPersonnageHasMail(Personnage personnage)
    {
        return personnage.getMail() != null;
    }

    private boolean checkPersonnageHasPassword(Personnage personnage)
    {
        return personnage.getPassword() != null;
    }

    private boolean checkPersonnageIsFemale(Personnage personnage)
    {
        return personnage.getSexe() == 2;
    }

    private boolean checkPersonnageIsMale(Personnage personnage)
    {
        return personnage.getSexe() == 1;
    }

    //#endregion

    @Test
    public void checkIfHasTool(){
        // je cr??er un perso
        Personnage Bob = new Personnage("Bob", 1);
        // Je cr??er un objet
        Objet hacheRudimentaire = new Objet("hacheRudimentaire", 3);
        // je simule une requ??te pour que mon outil fasse r??f??rence ?? la hache Rudimentaire dans la bdd
        Mockito.when(objRepo.getReferenceById(3)).thenReturn(hacheRudimentaire);

        List<InventaireObjet> inventaireBob = new ArrayList<InventaireObjet>();
        
        Mockito.when(iORepository.findByPersonnage(Bob)).thenReturn(inventaireBob);
        // j'ajoute l'outil ?? l'inventaireObjet du personnage
        inventaireObjetService.ajouterObjet(Bob, hacheRudimentaire.getId(), 1);
        // si la taille de l'inventaire de Bob est ??gale ?? 1 => true, le test passe
        assertTrue(Bob.getInventaireObjet().size() == 1);
        // pService.equiperOutil(31, (Outil)hacheRudimentaire.get());
        // assertEquals(Bob.get().getOutil(),hacheRudimentaire);
    }
}


