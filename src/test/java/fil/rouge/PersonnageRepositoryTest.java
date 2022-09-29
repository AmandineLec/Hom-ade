package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.Personnage;
@DataJpaTest
public class PersonnageRepositoryTest {
    @Autowired
	private PersonnageRepository pRepository;

    @Test
    @Sql("GivenPersonnageWithEmailWhenFindingByEmailShouldReturnPersonnage.sql")
    public void GivenPersonnageWithEmailWhenFindingByEmailShouldReturnPersonnage(){
    Personnage joueursTest = pRepository.findByMail("john@doe.mail.fr").get();
    
    assertEquals("john@doe.mail.fr", joueursTest.getMail());
    }

    @Test
    @Sql("GivenPersonnageWithEmailAndPasswordWhenFindingByEmailAndPasswordShouldReturnPersonnage.sql")
    public void GivenPersonnageWithEmailAndPasswordWhenFindingByEmailAndPasswordShouldReturnPersonnage(){
        Personnage joueursTest = pRepository.findByMailAndPassword("jane@doe.mail.fr", "soccer89").get();
        // test validé sous réserve de trouver une assertion moins longue ultérieurement
        assertTrue(joueursTest.getMail().equals("jane@doe.mail.fr" )&& joueursTest.getPassword().equals("soccer89" ));
    }


    //Si mail non présent en BDD
    @Test
    @Sql("givenPersonnageWithMail_WhenNotFindingByMail_ThenReturnNoPersonnage.sql")
    public void givenPersonnageWithMail_WhenNotFindingByMail_ThenReturnNoPersonnage(){
        Optional<Personnage> perso = pRepository.findByMail("pierre@aa.fr");
        assertTrue(perso.isEmpty());
    }

    // Si mail non présent mais password présent en BDD
    @Test
    @Sql("givenPersonnageWithMailAndPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage.sql")
    public void givenPersonnageWithWrongMailAndGoodPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage(){
        Optional<Personnage> perso = pRepository.findByMailAndPassword("pierre@aa.fr", "1323");
        assertTrue(perso.isEmpty());
    }

    // Si mail présent mais password non présent en BDD
    @Test
    @Sql("givenPersonnageWithMailAndPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage.sql")
    public void givenPersonnageWithGoodMailAndWrongPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage(){
        Optional<Personnage> perso = pRepository.findByMailAndPassword("joe@aa.fr", "1324");
        assertTrue(perso.isEmpty());
    }



    
}
