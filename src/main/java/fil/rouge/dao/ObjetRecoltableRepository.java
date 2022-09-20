package fil.rouge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.ObjetRecoltable;

@Repository
public interface ObjetRecoltableRepository extends CrudRepository<ObjetRecoltable, Integer> {
    
}
