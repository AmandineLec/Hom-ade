package fil.rouge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Objet;

@Repository
public interface ObjetRepository extends CrudRepository<Objet, Integer>{
    
}
