package fil.rouge.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Decoration;

@Repository
public interface DecorationRepository extends CrudRepository<Decoration, String> {
    @Bean
    List<Decoration> findAll();
}
