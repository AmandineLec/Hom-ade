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
        Outil outilAEquiper = outilRepository.getReferenceById(idOutil);

        boolean outilPresent = false; 
        if(personnage.getOutil() == null || personnage.getOutil().getId() != outilAEquiper.getId()){ 
          for(InventaireObjet invObjet : personnage.getInventaireObjet()){
            if(invObjet.getObjet().getId() == outilAEquiper.getId()){
              personnage.setOutil(outilAEquiper);
              inventaireObjetService.retirerObjet(outilAEquiper.getId(), 1, personnage);
              pRepository.save(personnage);
              return outilPresent = true; 
            }          
            else {
              throw new OutilException("Vous ne disposez pas de cet outil dans votre inventaire");
            }
          }
        }
        else{
            throw new OutilException("Vous êtes déjà equipé de cet outil");
        }  

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