package fil.rouge.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import fil.rouge.model.Outil;

public interface OutilRepository extends CrudRepository<Outil, String>{

    @Bean
    List<Outil> findAll(); 
}
