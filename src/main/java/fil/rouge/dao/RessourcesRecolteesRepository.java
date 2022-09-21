package fil.rouge.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.RessourcesRecoltees;

@Repository
public interface RessourcesRecolteesRepository extends CrudRepository<RessourcesRecoltees, Integer>{
    List<RessourcesRecoltees> findById_IdElementRecoltable(Integer idElementRecoltable);
}
