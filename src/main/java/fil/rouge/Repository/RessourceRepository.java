package fil.rouge.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Ressource;

@Repository
public interface RessourceRepository extends CrudRepository<Ressource, Integer>{
    
}
