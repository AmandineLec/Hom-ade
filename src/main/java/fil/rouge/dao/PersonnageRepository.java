package fil.rouge.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Personnage;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer>{
    // Créer les requetes nécessaires au service
}