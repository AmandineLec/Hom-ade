package fil.rouge.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Meuble;

@Repository
public interface MeubleRepository extends CrudRepository<Meuble, String>{
    @Bean
    List<Meuble> findAll();
}
