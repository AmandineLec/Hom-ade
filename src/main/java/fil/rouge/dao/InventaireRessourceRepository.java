package fil.rouge.dao;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.InventaireRessource;
import fil.rouge.model.InventaireRessourceKey;
import fil.rouge.model.Personnage;


@Repository
public interface InventaireRessourceRepository extends CrudRepository<InventaireRessource, InventaireRessourceKey>{
    
    @Bean
    List<InventaireRessource> findByPersonnage(Personnage personnage);

}
