package fil.rouge;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.MailAlreadyUsedException;
import fil.rouge.model.Personnage;
import fil.rouge.service.PersonnageService;

@SpringBootTest
public class PersonnageServiceTest {
    
    @Autowired
    PersonnageService pService;

    @MockBean
    PersonnageRepository pRepository;

    @Test
    public void WhenInvalidInscription_ThenThrowsException() {
        //Personnage personnage = new Personnage("Jean", 1, "marie@mail.fr", "1234");
        //Mockito.when(pRepository.save(personnage)).thenReturn(personnage);

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

        }
        /* Syntaxes pour faire une vérification d'un argument de méthode :
        * ArgumentMatcher<Personnage> matcher = this::checkPersonnageHasMaison;
        * matcher = x -> x.getMaison() != null;
        */

        /*
         * Ce que fait Mockito.verify :
         * 
         * Demande à Mockito de vérifier si la méthode "save" a été appelée
         * sur pRepository.
         * 
         * Puis demande à Mockito de vérifier si l'argument passé à "save" (donc un personnage)
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
}

