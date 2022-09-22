package fil.rouge.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;

@Repository
public interface InventaireRessourceRepository extends CrudRepository<InventaireRessource, Integer>{
    List<InventaireRessource> findByPersonnageAndRessource(Personnage personnage, Ressource ressource);
}
