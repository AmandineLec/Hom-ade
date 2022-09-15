package fil.rouge.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Objet;

@Repository
public interface ObjetRepository extends CrudRepository<Objet, Long>{
    
}
