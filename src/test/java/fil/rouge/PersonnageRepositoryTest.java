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
    @Sql("givenPersonnageWithMail_WhenFindingByMail_ThenReturnPersonnage.sql")
    public void givenPersonnageWithMail_WhenFindingByMail_ThenReturnPersonnage(){
        Optional<Personnage> perso = pRepository.findByMail("joe@aa.fr");
		assertEquals(perso.get().getName(), "Joe");
    }

    @Test
    @Sql("givenPersonnageWithMail_WhenNotFindingByMail_ThenReturnNoPersonnage.sql")
    public void givenPersonnageWithMail_WhenNotFindingByMail_ThenReturnNoPersonnage(){
        Optional<Personnage> perso = pRepository.findByMail("pierre@aa.fr");
		assertTrue(perso.isEmpty());
    }

    @Test
    @Sql("givenPersonnageWithMailAndPassword_WhenFindingByMailAndPassword_ThenReturnPersonnage.sql")
    public void givenPersonnageWithMailAndPassword_WhenFindingByMailAndPassword_ThenReturnPersonnage(){
        Optional<Personnage> perso = pRepository.findByMailAndPassword("joe@aa.fr", "1323");
		assertEquals(perso.get().getName(), "Joe");
    }

    @Test
    @Sql("givenPersonnageWithMailAndPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage.sql")
    public void givenPersonnageWithWrongMailAndGoodPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage(){
        Optional<Personnage> perso = pRepository.findByMailAndPassword("pierre@aa.fr", "1323");
		assertTrue(perso.isEmpty());
    }

    @Test
    @Sql("givenPersonnageWithMailAndPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage.sql")
    public void givenPersonnageWithGoodMailAndWrongPassword_WhenNotFindingByMailAndPassword_ThenReturnNoPersonnage(){
        Optional<Personnage> perso = pRepository.findByMailAndPassword("joe@aa.fr", "1324");
		assertTrue(perso.isEmpty());
    }
}
