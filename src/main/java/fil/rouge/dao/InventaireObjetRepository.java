package fil.rouge.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireObjetKey;
import fil.rouge.model.Personnage;

@Repository
public interface InventaireObjetRepository extends CrudRepository<InventaireObjet, InventaireObjetKey> {
    // Créer requete list inventaire find by idperso AND id objet
    List<InventaireObjet> findByPersonnage(Personnage personnage);
}
