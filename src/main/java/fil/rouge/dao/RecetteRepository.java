package fil.rouge.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import fil.rouge.model.Recette;


@Repository
public interface RecetteRepository extends CrudRepository<Recette, Integer> {
    //
}
