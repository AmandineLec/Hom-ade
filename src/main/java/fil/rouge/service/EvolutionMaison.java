package fil.rouge.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Maison;
import fil.rouge.model.Personnage;
import fil.rouge.model.Recette;
import fil.rouge.model.Ressource;

public class EvolutionMaison {
    @Autowired // pour importer le repository de Personnage
    private PersonnageRepository personnageRepository;

    @Autowired
    private InventaireRessource inventaireRessourceRepository;

    @Autowired
    private Maison maisonRepository;

    // @Autowired
    // private Recette recette;
    public void augmenterNiveauMaison(int idPersonnage){
        // accèder à l'inventaire des ressources du personnage
        // comparer ses ressources à celles nécessaires pour augmenter le niveau de la maison
        // si il a les ressources nécessaires, maison.getNiveau =+ 1;
        Optional<Personnage> personnage = personnageRepository.findById(idPersonnage); // récupérer l'id du joueur pour accèder à son inventaire de ressource
        Set<InventaireRessource> ressourcesDuPersonnage  = personnage.get().getInventaireRessource(); // accès à l' inventaire des ressources du joueur
        Maison maisonDuPersonnage = personnage.get().getMaison();
        List<HashMap<Integer, Integer>> recettesDeLaMaisonDuPersonnage = maisonDuPersonnage.getRecettes();

        Collection<Integer> idRessources;
        Collection<Integer> quantiteRessources;

        for(HashMap<Integer, Integer> recettes : recettesDeLaMaisonDuPersonnage){
            idRessources = recettes.keySet();
            quantiteRessources = recettes.values();
        }

        Iterator<InventaireRessource> ressources = ressourcesDuPersonnage.iterator();
        Set<Integer> idTRouves;
        //vérification de la présence de l'id ressource dans les recettes de la maison
        while(ressources.hasNext()) {
            InventaireRessource ressource = ressources.next();
            if(idRessources.contains(ressource.getRessource().getId())){
                idTRouves.add(ressource.getRessource().getId());
            }
        }




                for (InventaireRessource inventaireRessource : ressourcesDuPersonnage) {
                    int idRessource = inventaireRessource.getRessource().getId();
                    Maison maison = personnage.get().getMaison();
                    ArrayList <HashMap<Integer, Integer>> recettesMaison = maison.getRecettes();
                    // parcourir l'inventaire ressource de type Set du personnage et vérifier si l'id de la ressource ainsi que sa quantité 
                    // mmatchent avec la hashmap des recettes de maison en comparant les clés idRessource et leurs valeurs quantiteRessource
                    // https://www.w3schools.com/java/tryjava.asp?filename=demo_hashmap_loop_value
                    for(int i = 0; i< recettesMaison.size(); i++){
                        Set<Integer> idRessourceRecette = recettesMaison.get(i).keySet();
                        Collection<Integer> quantiteRessourceRecette = recettesMaison.get(i).values();
                    }

                    if(idRessource == recettesMaison.get(1).get(key)){

                    }
                }   
    }
    
}
