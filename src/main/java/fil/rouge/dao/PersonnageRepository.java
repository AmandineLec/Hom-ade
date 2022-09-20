package fil.rouge.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fil.rouge.model.Personnage;

@Repository
public interface PersonnageRepository extends CrudRepository<Personnage, Integer>{
    // Créer les requetes nécessaires au service

}

//
/*
 * 
 * List<Player> findByWeapon_Damage(Integer damage);

    public class Player
    {
        private Weapon weapon;
    }

    public class Weapon
    {
        private Integer damage;
    }

 */