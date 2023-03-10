package fil.rouge.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Personnage;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer>{
    // Créer les requetes nécessaires au service
    Optional<Personnage> findByMail(String mail); // en recherchant un perso par mail, il est censé me le trouver avec tous ses attributs
    Optional<Personnage> findByMailAndPassword(String mail, String password);
}