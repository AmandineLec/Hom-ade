package fil.rouge.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import fil.rouge.model.Objet;
import fil.rouge.model.Recette;


@Repository
public interface RecetteRepository extends CrudRepository<Recette, Integer> {

    @Bean
    List<Recette> findByObjet(Objet objet);

}
