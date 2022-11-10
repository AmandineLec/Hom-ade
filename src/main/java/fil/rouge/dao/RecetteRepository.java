package fil.rouge.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fil.rouge.model.Objet;
import fil.rouge.model.Recette;


@Repository
public interface RecetteRepository extends CrudRepository<Recette, Integer> {

    @Bean
    List<Recette> findByObjet(Objet objet);

    @Query(value ="SELECT * FROM recette as r LEFT JOIN objet as o on r.id_objet = o.id_objet WHERE o.type = :type", nativeQuery = true)
    List<Recette> findbyTypeNative(@Param("type") Integer type);



}
