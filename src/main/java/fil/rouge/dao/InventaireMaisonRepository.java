package fil.rouge.dao;

import fil.rouge.model.EquipementMaisonkey;
import fil.rouge.model.EquipementMaison;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import fil.rouge.model.Maison;
// liens ci-dessous suceptibles d'expliquer la finalité du repository
// https://www.baeldung.com/spring-data-repositories
// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
// https://gayerie.dev/epsi-b3-orm/spring_data/spring_data_jpa.html
@Repository // le repository sert à effectuer les requêtes. requêtes natives => findBy, findAll, delete...
public interface InventaireMaisonRepository extends CrudRepository<EquipementMaison, EquipementMaisonkey>  {
     // SELECT(find) <inventaire_maison> FROM inventaire_maison WHERE(By) id_maison(Maison) = id_maison(maison dans le paramètre)
     // il s'agit d'accèder aux objets placés dans la maison
    List<EquipementMaison> findByMaison(Maison maison);

    
}
