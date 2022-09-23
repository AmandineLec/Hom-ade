package fil.rouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Integer>{
    
}
