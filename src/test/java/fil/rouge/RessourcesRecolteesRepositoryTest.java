package fil.rouge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import fil.rouge.dao.RessourcesRecolteesRepository;
import fil.rouge.model.RessourcesRecoltees;

@DataJpaTest
public class RessourcesRecolteesRepositoryTest {
    
    @Autowired
    RessourcesRecolteesRepository ressourcesRecolteesRepository;

    @Test
    @Sql("givenRessourcesRecolteesWithIdElementRecoltable112_WhenFindingbyId3_ShouldReturnNull.sql")
    public void givenRessourcesRecolteesWithIdElementRecoltable112_WhenFindingbyId3_ShouldReturnNull() {
        List<RessourcesRecoltees> ressourcesRecoltees = ressourcesRecolteesRepository.findById_IdElementRecoltable(3);

        assertThat(ressourcesRecoltees).isEmpty();
    }

    @Test
    @Sql("givenRessourcesRecolteesWithIdElementRecoltable112_WhenFindingbyId1_ShouldReturn2.sql")
    public void givenRessourcesRecolteesWithIdElementRecoltable112_WhenFindingbyId1_ShouldReturn2() {
        List<RessourcesRecoltees> ressourcesRecoltees = ressourcesRecolteesRepository.findById_IdElementRecoltable(1);

        assertThat(ressourcesRecoltees.size()).isEqualTo(2);
    }
}
