package fil.rouge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.InventaireRessource;

@Repository
public interface InventaireRessourceRepository extends CrudRepository<InventaireRessource, Integer>{
    
}
