package fil.rouge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Maison;

@Repository
public interface MaisonRepository extends CrudRepository<Maison, Integer> {
    // gestion de l'accès à la table Maison
    // qui sera ensuite utilisé dans le service Maison

    
}
