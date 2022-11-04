package fil.rouge.dao;

<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> Marie

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Objet;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer>{
<<<<<<< HEAD
    Optional<Objet> findByNom(String nom);
    
=======
>>>>>>> Marie
}
