package fil.rouge;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
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
    public void inscriptionFailedTest() {
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

    // @Test
    // public void whenValidInscription_ThenSavedPersonnageHasMaison()
    // {
    //     // pService.inscription()

    //     // Syntaxes pour faire une vérification pour un argument :
    //     ArgumentMatcher<Personnage> matcher = this::checkPersonnageHasMaison;
    //     matcher = x -> x.getMaison() != null;
        
    //     /**
    //      * Demande à Mockito de vérifier si la méthode "save" a été appelée
    //      * sur pRepository.
    //      * 
    //      * Demande à Mockito de vérifier si l'argument passé à "save" (donc un personnage)
    //      * satisfait un test (ici "personnage.getMaison() != null")
    //      */
    //     Mockito
    //         .verify(pRepository)
    //         .save(ArgumentMatchers.argThat(this::checkPersonnageHasMaison));
    // }

    // private boolean checkPersonnageHasMaison(Personnage personnage)
    // {
    //     return personnage.getMaison() != null;
    // }
}

