package fil.rouge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Maison;

@Repository
public interface MaisonRepository extends CrudRepository<Maison, Integer> {
    
}
