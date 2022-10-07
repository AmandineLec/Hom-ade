package fil.rouge.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRepository;
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
        //On fait appel à la méthide ajouter objet pour ajouter l'objet dans l'inventaire du personnage. 
        inventaireObjetService.ajouterObjet(personnage, objet.getId(), 1);
        return true;
    }

    public boolean equiperOutil(Integer idOutil, Integer idPerso) throws OutilException{
        Optional<Personnage> personnage = pRepository.findById(idPerso);
        Set<InventaireObjet> inventaireObjet = personnage.get().getInventaireObjet();
        Optional<Objet> outil = oRepository.findByIdAndCategorie(idOutil, 1);

        boolean outilPresent = false; 
        for(InventaireObjet invObjet : inventaireObjet){
          if(invObjet.getObjet().getId() == outil.get().getId()){
            outilPresent = true;
          }
        }
    
        if (!outilPresent){
          throw new OutilException("Vous ne disposez pas de cet outil dans votre inventaire");
        }
    
        if(personnage.get().getOutil()!= null && personnage.get().getOutil().getId() == outil.get().getId()){
          throw new OutilException("Vous êtes déjà equipé de cet outil");
        }
    
        inventaireObjetService.ajouterObjet(personnage.get(), personnage.get().getOutil().getId(), 1);
        inventaireObjetService.retirerObjet(outil.get().getId(), 1, personnage.get());
        personnage.get().setOutil((Outil)outil.get());
    
        return true;
      }
    
    
      public boolean desequiperOutil(Integer idPersonnage, Integer idOutil) throws OutilException{
        Optional<Personnage> personnage = pRepository.findById(idPersonnage);
        Optional<Objet> outil = oRepository.findByIdAndCategorie(idOutil, 1);
    
        if (personnage.get().getOutil()== null){
          throw new OutilException("Vous n'êtes pas équipé d'un outil");
        }
    
        if(personnage.get().getOutil()!= null && personnage.get().getOutil().getId() != outil.get().getId()){
          throw new OutilException("Vous n'êtes pas équipé d'un outil");
        }
    
        if(personnage.get().getOutil()!= null && personnage.get().getOutil().getId() == outil.get().getId()){
            inventaireObjetService.ajouterObjet(personnage.get(), outil.get().getId(), 1);
        }
    
        personnage.get().setOutil(null);
    
    
        return true;
      }
    
}
