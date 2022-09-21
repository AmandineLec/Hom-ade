package fil.rouge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fil.rouge.dao.RessourcesRecolteesRepository;

@DataJpaTest
public class RessourceRecolteesRepositoryTest {

    @Autowired
    RessourcesRecolteesRepository ressourcesRecolteesRepository;

    
    
}
