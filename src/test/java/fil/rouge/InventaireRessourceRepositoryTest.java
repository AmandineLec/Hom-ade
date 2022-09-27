package fil.rouge;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;



import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InventaireRessourceRepositoryTest {

    @Autowired 
    InventaireRessourceRepository inventaireRessourceRepository;

    @Autowired
    PersonnageRepository personnageRepository;

    @Test
    @Sql("givenPersonnage_WhenFindByPersonnage_ShouldreturnAllResourceOfAPersonnage.sql")
    //On test le respository inventaire ressource via un fichier SQL contenant un personnage, une ressource et 
    //Une ligne dans la table inventaire_ressource (ce qui signifie que le personnage ne possède d'une seule ressource dans son inventaire)
    public void givenPersonnage_WhenFindByPersonnage_ShouldreturnAllResourceOfAPersonnage(){
        //On utilise la recherche "findById" qui va aller chercher le personnage possédant l'id 1 dans une liste d'optionnal. 
        Optional<Personnage> personnages = personnageRepository.findById(1);
        //On instancie ce nouveau personnage par un .get sur la liste optional
        Personnage personnage = personnages.get(); 
        //On fait une liste InventaireRessource qui va contenir toutes les ressource présentes dans l'inventaire du personnage.
        //On les remonte grâce à une recherche sur le personnage. Ce qui signifie qu'on va avoir toutes les ressources ayant 
        //Dans la table "inventaire_ressources" comme id_personnage 1.   
        List<InventaireRessource> ressources = inventaireRessourceRepository.findByPersonnage(personnage);
        //On vérifie que la liste inventaire ressource nous renvoie bien 1. 
        assertThat(ressources.size()).isEqualTo(1);
    }

}
