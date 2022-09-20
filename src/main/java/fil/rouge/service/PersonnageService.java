package fil.rouge.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;



@Service
public class PersonnageService {
    
    @Autowired
    PersonnageRepository pRepository;

    @Autowired
    InventaireObjetRepository iORepository;



    // Insertion des méthodes faites dans la classe personnage
    //Permet d'ajouter un objet dans l'inventaire
    public boolean ajouterObjet(Objet objet, int quantite, int id) {
        // Penser 
        Optional<Personnage> personnage = pRepository.findById(id);
        Collection<InventaireObjet> it = personnage.get().getInventaireObjet(); 
        
        for(InventaireObjet invObjet : it)
        {
        // while (it.hasNext()) {
        //   InventaireObjet invObjet = it.next();
          if (invObjet.getObjet().getId() == objet.getId()) {
            invObjet.ajouterObjet(quantite);
            return true;
          }
        }
        InventaireObjet invObj = new InventaireObjet(personnage.get(), objet, quantite);
        pRepository.save(personnage.get());
        iORepository.save(invObj);

        return personnage.get().addInventaireObjet(invObj);
        
        
      }
    
      public boolean retirerObjet(Objet objet, int quantite) {
        Iterator<InventaireObjet> it = inventaireObjets.iterator();
        while (it.hasNext()) {
          InventaireObjet invObjet = it.next();
          if (invObjet.getId().getIdObjet() == objet.getId()) {
            return invObjet.retirerObjet(quantite);
          }
        }
        return false;
      }
    
      public boolean ajouterRessource(Ressource ressource, int quantite) {
    
        Iterator<InventaireRessource> it = inventaireRessources.iterator();
        while (it.hasNext()) {
          InventaireRessource invRes = it.next();
          if (invRes.getId().getIdRessource() == ressource.getId()) {
            invRes.ajouterRessource(quantite);
            return true;
          }
        }
        InventaireRessource invRes = new InventaireRessource(this, ressource, quantite);
        return addInventaireRessource(invRes);
    
      }
    
      public boolean retirerRessource(Ressource ressource, int quantite) {
        Iterator<InventaireRessource> it = inventaireRessources.iterator();
        while (it.hasNext()) {
          InventaireRessource invRes = it.next();
          if (invRes.getId().getIdRessource() == ressource.getId()) {
            return invRes.retirerRessource(quantite);
    
          }
        }
        return false;
      }
    
      public boolean sauvegarderJoueur() {
        
        return true;
      }
    
}
