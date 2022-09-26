package fil.rouge.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.RecetteRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.model.Recette;

@Service
public class RecetteService {
    @Autowired
    RecetteRepository recetteRepository;

    @Autowired 
    private ObjetRepository oRepository;

    @Autowired
    private ObjetService objetService; 

    @Autowired
    private InventaireRessourceService inventaireRessourceService;

    public RecetteService(){

    }
    public RecetteRepository getRecetteRepository() {
        return recetteRepository;
    }
    public void setRecetteRepository(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    //Remonter la liste des ressources avec leur quantité dans une liste 
    //Comparé cette liste à l'inventaire du personnage 
    //Si inventaire perso > liste ressource : true
    //Sinon false
    //Comparaison des deux listes (on retirera les ressources dans le service inventaire)

    public boolean fusionnerRessource(int idObj, Personnage personnage){
        Objet objet = oRepository.getReferenceById(idObj);
        List<Recette> recettes = recetteRepository.findByObjet(objet);
        Set<InventaireRessource> inventaireRessources = personnage.getInventaireRessource();
        for (Recette recette : recettes){
            if( personnage.getMaison().getNiveau() == recette.getNiveau_requis())
                for(InventaireRessource inventaireRessource : inventaireRessources){
                    if(recette.getRessource().getId() == inventaireRessource.getRessource().getId() && recette.getQuantite_necessaire() <= inventaireRessource.getQuantite()){ 
                        int quantite = inventaireRessource.getQuantite() - recette.getQuantite_necessaire();
                        inventaireRessourceService.retirerRessource(inventaireRessource.getRessource().getId(),quantite, personnage);
                        objetService.createObject(personnage, idObj);                   
                        return true; 
                    }                
                }
            }
        return false;
    }
}
