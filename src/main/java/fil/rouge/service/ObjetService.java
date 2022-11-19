package fil.rouge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.OutilRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.OutilException;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;

@Service
public class ObjetService {

    @Autowired
    protected ObjetRepository oRepository;

    @Autowired
    protected PersonnageRepository pRepository;

    @Autowired 
    private InventaireObjetService inventaireObjetService;

    @Autowired
    protected OutilRepository outilRepository; 


    public ObjetService(){

    }

    public ObjetRepository getObjetRepository() {
        return oRepository;
    }

    public void setObjetRepository(ObjetRepository oRepository) {
        this.oRepository = oRepository;
    }

    //Méthode de création d'un objet
    public boolean creerObjet(Personnage personnage, int id){
        Objet objet = oRepository.getReferenceById(id);
        //On fait appel à la méthode ajouter objet pour ajouter l'objet dans l'inventaire du personnage. 
        inventaireObjetService.ajouterObjet(personnage, objet.getId(), 1);
        return true;
    }

    public boolean equiperOutil(Personnage personnage, Integer idOutil) throws OutilException{
      //On va chercher l'outil a équiper par son id dans la base de donnée  
      Outil outilAEquiper = outilRepository.getReferenceById(idOutil);
      //On instancie un booléen pour savoir si l'objet est présent ou non dans l'inventaire
      boolean outilPresent = false; 
        //Si le personnage n'a pas d'outil équiper ou si l'id de l'outil équipé est différent de l'id de l'outil à équipé
        if(personnage.getOutil() == null || personnage.getOutil().getId() != outilAEquiper.getId()){ 
          //Pour chaque objet présent dans l'inventaire : 
          for(InventaireObjet invObjet : personnage.getInventaireObjet()){
            //Si l'id de l'objet dans l'inventaire correspond à l'id de l'objet à équiper
            if(invObjet.getObjet().getId() == outilAEquiper.getId()){
              //Si le personnage avait un outil d'équiper, on l'ajoute à son inventaire d'objet
              if(personnage.getOutil() != null){
                inventaireObjetService.ajouterObjet(personnage, personnage.getOutil().getId(), 1);
              }
              //On lui équipe l'outil que lon voulait équiper
              personnage.setOutil(outilAEquiper);
              inventaireObjetService.retirerObjet(outilAEquiper.getId(), 1, personnage);
              //on sauvegarde son outil en BDD
              pRepository.save(personnage);
              //On met le booléen pour qu'il nous renvoie true afin de savoir que l'outil a bien été équipé
              outilPresent = true; 
            }    
          }
          //Si le booléen est à false, on envoie l'exception indiquant que l'outil n'est pas dans l'inventaire
          if(outilPresent == false){
            throw new OutilException("Vous ne disposez pas de cet outil dans votre inventaire");
          }
        }
        //Si le personnage a déjà cet objet d'équiper, on envoie une exception
        else{
            throw new OutilException("Vous êtes déjà equipé de cet outil");
        }  
        //On renvoie ensuite le booléen pour le récupérer dans un controller
        return outilPresent;
      }


    public boolean desequiperOutil(Personnage personnage, Integer idOutil) throws OutilException{

      if (personnage.getOutil()== null){
        throw new OutilException("Vous n'êtes pas équipé d'un outil");
      }

      if(personnage.getOutil()!= null && personnage.getOutil().getId() != idOutil){
        throw new OutilException("Vous n'êtes pas équipé de cet outil");
      }

      if(personnage.getOutil()!= null && personnage.getOutil().getId() == idOutil){
          inventaireObjetService.ajouterObjet(personnage, idOutil, 1);
      }

      personnage.setOutil(null);


      return true;
    }

}