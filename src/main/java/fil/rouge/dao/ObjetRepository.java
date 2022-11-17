package fil.rouge.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fil.rouge.model.Objet;


@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer>{
}
