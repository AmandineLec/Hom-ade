package fil.rouge;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;



import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InventaireRessourceRepositoryTest {

    @Autowired 
    InventaireRessourceRepository inventaireRessourceRepository;

    @Autowired
    PersonnageRepository personnageRepository;

    @Test
    @Sql("givenPersonnage_WhenFindByPersonnage_ShouldreturnAllResourceOfAPersonnage.sql")
    public void givenPersonnage_WhenFindByPersonnage_ShouldreturnAllResourceOfAPersonnage(){
        Optional<Personnage> personnages = personnageRepository.findById(1);
        Personnage personnage = personnages.get(); //Création d'un nouveau personnage     
        List<InventaireRessource> ressources = inventaireRessourceRepository.findByPersonnage(personnage);
        assertThat(ressources.size()).isEqualTo(1);
    }

}
