package fil.rouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.RecetteRepository;
import fil.rouge.exception.ReceiptsException;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.model.Recette;

@Service
public class RecetteService {
    @Autowired
    private RecetteRepository recetteRepository;

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

    public boolean fusionnerRessource(int idObj, Personnage personnage) throws ReceiptsException {
        //On instancie un objet en getReferenceById car on ne sait pas à l'avance quel objet on veut créer. 
        Objet objet = oRepository.getReferenceById(idObj);
        //On va chercher en BDD toutes les lignes composant une recette en fonction de l'id de l'objet que l'on veut créer
        List<Recette> recettes = recetteRepository.findByObjet(objet);
        //On instancie un booléen à false afin de vérifier nos conditions et le passer à true si tout va bien. 
        boolean craftable = false; 
        //Pour chaque ligne présente dans la recette
        for (Recette recette : recettes){
            //On vérifie si le niveau de la maison du joueur est le même que le niveau de le recette si oui ou continue, si non, on ne peut pas créer l'objet.
            if(personnage.getMaison().getNiveau() >= recette.getNiveau_requis()){
            //Pour chaque ressource présente dans l'inventaire du personnage
                for(InventaireRessource inventaireRessource : personnage.getInventaireRessource()){
                    //On vérifie que la ressource est présente dans l'inventaire du personnage, si oui, on continue. 
                    if(inventaireRessource.getRessource().getId() == recette.getRessource().getId()){
                        //On vérifie que la quantité de ressource dans l'inventaire du personnage est suffisante, si oui, on continue. 
                        if(inventaireRessource.getQuantite()>= recette.getQuantite_necessaire()) {
                            //On instancie une variable quantité, calculant la quantité de ressource utilisée pour crée l'objet. 
                            int quantite = inventaireRessource.getQuantite() - recette.getQuantite_necessaire();
                            //On appelle la méthode "retirerRessource", permettant d'instancier la nouvelle quantité de ressource du personnage de la ressource utlisée
                            inventaireRessourceService.retirerRessource(inventaireRessource.getRessource().getId(),quantite, personnage);
                            //Finalement, on crée l'objet, et on l'ajoute à l'inventaire du personnage. 
                            objetService.creerObjet(personnage, idObj); 
                            //On passe le boléen en true. 
                            craftable = true; 
                        }
                        //Si on a pas le nombre de ressource en quantité suffisante, on envoie une exception
                        else {
                            throw new ReceiptsException("Vous n'avez pas" + recette.getRessource().getNom()+ "en quantité nécessaire");
                        }           
                    }
                }
                //Si le boléen est à false en sortant de la boucle (ce qui signifie qu'il n'a pas été au bout des conditions), on envoie une exceptions. 
                if(craftable == false){
                    throw new ReceiptsException("Vous n'avez pas les ressources nécessaires pour créer cet objet");
                }
            }
            //Si le joueur n'a pas le niveau requis, on envoie une exception. 
            else {
                throw new ReceiptsException("Vous n'avez pas le niveau requis pour créer cet objet");
            }
        }
        //On retourne le booléen qui nous permettra de savoir si la recette a pu être réalisée. 
        return craftable;
    }
}
