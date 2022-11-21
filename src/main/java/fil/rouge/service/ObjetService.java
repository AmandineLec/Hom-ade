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
      // on défini outil présent à 0
      int outilPresent = 0;

      //On va chercher l'outil à équiper par son id dans la base de données 
      Outil outilAEquiper = outilRepository.getReferenceById(idOutil);

      //Si le personnage n'a pas d'outil équipé, ou si l'id de l'outil équipé est différent de l'id de l'outil à équiper
      if(personnage.getOutil() == null || personnage.getOutil().getId() != outilAEquiper.getId()){ 
        // Pour chaque inventaire objet dans l'inventaire du personnage
        for(InventaireObjet invObjet : personnage.getInventaireObjet()){

          //Si l'id de l'objet équipé est présent dans l'inventaire
          if(invObjet.getObjet().getId() == outilAEquiper.getId()){
            // on ajoute 1 à outilPresent (s'il n'est pas présent restera à 0, et ne peut être présent qu'une seule fois)
            outilPresent += 1;
          }
        } 

        // Onn sort du foreach pour modifier l'inventaire sur lequel on itère pour éviter les Conccurent Modification Exception
        // Si l'outil est bien présent dans l'inventaire
        if(outilPresent == 1){
          // Si le personnage est déjà équipé
          if(personnage.getOutil() != null){
            // On range l'outil dans l'inventaire
            inventaireObjetService.ajouterObjet(personnage, personnage.getOutil().getId(), 1);
          }
          // On retire l'outil à équiper de l'inventaire
          inventaireObjetService.retirerObjet(outilAEquiper.getId(), 1, personnage);
          // On équipe l'outil sur le personnage 
          personnage.setOutil(outilAEquiper);
          // Et on sauvegarde en BDD
          pRepository.save(personnage);
        }
        // Sinon (si l'outil n'est pas présent)
        else{
          // On envoie une exception
          throw new OutilException("Vous ne disposez pas de cet outil dans votre inventaire");
        }
      }
      //Sinon (si le personnage est déjà équipé de cet outil), on envoie une exception
      else {
          throw new OutilException("Vous êtes déjà equipé de cet outil");
      }

      //On renvoie true pour le récupérer dans un controller
      return true;
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