package fil.rouge.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import fil.rouge.model.Outil;

public interface OutilRepository extends JpaRepository<Outil, Integer>{

    @Bean
    List<Outil> findAll(); 
}
