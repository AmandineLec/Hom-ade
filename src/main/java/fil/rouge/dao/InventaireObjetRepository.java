package fil.rouge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.InventaireObjet;

@Repository
public interface InventaireObjetRepository extends CrudRepository<InventaireObjet, Integer> {
    
}
