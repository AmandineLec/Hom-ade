package fil.rouge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.Personnage;
@DataJpaTest
public class PersonnageRepositoryTest {
    @Autowired
	private PersonnageRepository personnageRepository;

    @Test
    @Sql("GivenPersonnageWithEmailWhenFindingByEmailShouldReturnPersonnage.sql")
    public void GivenPersonnageWithEmailWhenFindingByEmailShouldReturnPersonnage(){
    List<Personnage> joueursTest = personnageRepository.findByMail("john@doe.mail.fr");
    
    assertEquals("john@doe.mail.fr", joueursTest.get(0).getMail(), "Si le mail john@doe.mail.fr est renvoyé c'est que la méthode fonctionne");
    }

    @Test
    @Sql("GivenPersonnageWithEmailAndPasswordWhenFindingByEmailAndPasswordShouldReturnPersonnage.sql")
    public void GivenPersonnageWithEmailAndPasswordWhenFindingByEmailAndPasswordShouldReturnPersonnage(){
        List<Personnage> joueursTest = personnageRepository.findByMailAndPassword("jane@doe.mail.fr", "soccer89");
        // test validé sous réserve de trouver une assertion moins longue ultérieurement
        assertTrue(joueursTest.get(0).getMail().equals("jane@doe.mail.fr" )&& joueursTest.get(0).getPassword().equals("soccer89" ) , "Si le mail jane@doe.mail.fr et le mot de passe soccer89 sont renvoyés c'est que la méthode fonctionne");
        

    }





    
}
