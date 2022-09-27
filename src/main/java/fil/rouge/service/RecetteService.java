package fil.rouge.service;

import java.util.List;

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

    public boolean fusionnerRessource(int idObj, Personnage personnage){
        //On instancie un objet en getReferenceById car on ne sait pas à l'avance quel objet on veut créer. 
        Objet objet = oRepository.getReferenceById(idObj);

        //On va chercher en BDD toutes les lignes composant une recette en fonction de l'id de l'objet que l'on veut créer
        List<Recette> recettes = recetteRepository.findByObjet(objet);

        //POur chaque ligne présente dans la recette
        for (Recette recette : recettes){

            //On vérifie si le niveau de la maison du joueur est le même que le niveau de le recette si oui ou continue, si non, on ne peut pas créer l'objet.
            if( personnage.getMaison().getNiveau() == recette.getNiveau_requis())

            //Pour chaque ressource présente dans l'inventaire du personnage
                for(InventaireRessource inventaireRessource : personnage.getInventaireRessource()){

                    //On vérifie que la ressource est présente dans l'inventaire du personnage est en bonne quantité. Si oui, on continue si non, on ne peut pas créer l'objet. 
                    if(recette.getRessource().getId() == inventaireRessource.getRessource().getId() && recette.getQuantite_necessaire() <= inventaireRessource.getQuantite()){ 

                        //On instancie une variable quantité, calculant la quantité de ressource utilisée pour crée l'objet. 
                        int quantite = inventaireRessource.getQuantite() - recette.getQuantite_necessaire();

                        //On appelle la méthode "retirerRessource", permettant d'instancier la nouvelle quantité de ressource du personnage de la ressource utlisée

                        inventaireRessourceService.retirerRessource(inventaireRessource.getRessource().getId(),quantite, personnage);

                        //Finalement, on crée l'objet, et on l'ajoute à l'inventaire du personnage. 
                        objetService.creerObjet(personnage, idObj);                   
                        return true; 
                    }                
                }
            }
        return false;
    }
}
