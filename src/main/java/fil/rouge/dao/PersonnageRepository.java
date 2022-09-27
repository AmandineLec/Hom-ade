package fil.rouge.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Personnage;

@Repository
public interface PersonnageRepository extends CrudRepository<Personnage, Integer>{
    // Créer les requetes nécessaires au service
}