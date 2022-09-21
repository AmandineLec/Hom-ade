package fil.rouge.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;



@Service
public class PersonnageService {
    
    @Autowired
    private PersonnageRepository pRepository;

    @Autowired
    private InventaireRessourceRepository iRRepository;

    // TODO:
    // Penser à gérer les exception avec un try catch si les optionnal sont vides (=> si on n'arrive pas à récupérer un perso, si on n'arrive pas à ajouter/retirer un objet, etc)

    // Insertion des méthodes faites dans la classe personnage

    public Optional<Personnage> getPersoById(int idPerso){
      Optional<Personnage> perso = pRepository.findById(idPerso);
      return perso;
    }


// METHODE DEPLACEES DANS INVENTAIREOBJET SERVICE
    // //Permet d'ajouter un objet dans l'inventaire
    // public boolean ajouterObjet(Objet objet, int quantite, int idPerso) { // Objet à ajouter, quantité à ajouter, id du perso concerné
    //     Optional<Personnage> personnage = getPersoById(idPerso); //Stock dans l'optionnal le personnage si trouvé avec l'id
    //     Collection<InventaireObjet> it = personnage.get().getInventaireObjet(); // Récupère la liste d'inventaires du perso dans la collection
        
    //     for(InventaireObjet invObjet : it) // On parcours la collection d'inventaire
    //     {
    //       if (invObjet.getObjet().getId() == objet.getId()) { // Si l'id de l'objet à ajouter est trouvé dans la collection
    //         invObjet.ajouterObjet(quantite); // Alors on modifie la quantité de l'objet
    //         iORepository.save(invObjet); // On sauvegarde en BDD la MAJ de l'inventaire
    //         return true;
    //       }
    //     }
    //     InventaireObjet invObj = new InventaireObjet(personnage.get(), objet, quantite); // Si pas trouvé dans la collection, on créée un nouvel inventaire avec le perso, l'objet et la quantité
    //     personnage.get().addInventaireObjet(invObj); 
    //     iORepository.save(invObj); // On sauvegarde en BDD l'inventaire
    //     return true; // On retourne true si un inventaire a bien été ajoutée au set du perso
        
    //   }
    
    //   //Permet de retirer un objet de l'inventaire
    //   public boolean retirerObjet(Objet objet, int quantite, int idPerso) { // Objet à retirer, quantité à retirer, id du perso concerné
    //     Optional<Personnage> personnage = getPersoById(idPerso); // Stock dans l'optionnal le perso si trouvé avec l'id
    //     Collection<InventaireObjet> it = personnage.get().getInventaireObjet(); // Récupère la liste d'inventaires du perso dans la collection
    //     for(InventaireObjet invObjet : it){ // On parcours la collection d'inventaire
    //       if (invObjet.getObjet().getId() == objet.getId()) {// Si l'id de l'objet à retirer est trouvé dans la collection
    //         invObjet.retirerObjet(quantite); // Alors on modifie la quantité de l'objet
    //         iORepository.save(invObjet); // On sauvegarde en BDD la MAJ de l'inventaire
    //         return true; // Return true si on a réussi à retirer la quantité d'objet indiquée
    //       }
    //     }
    //     return false; // Si l'id n'est pas trouvé, on ne peut pas le retirer donc return false
    //   }
    



      //Permet d'ajouter une ressource dans l'inventaire
      public boolean ajouterRessource(Ressource ressource, int quantite, int idPerso) {
        Optional<Personnage> personnage = getPersoById(idPerso);
        Collection<InventaireRessource> it = personnage.get().getInventaireRessource();
        for(InventaireRessource invRessource : it){
          if (invRessource.getRessource().getId() == ressource.getId()) {
            invRessource.ajouterRessource(quantite);
            iRRepository.save(invRessource);
            return true;
          }
        }
        InventaireRessource invRes = new InventaireRessource(personnage.get(), ressource, quantite);
        personnage.get().addInventaireRessource(invRes);
        iRRepository.save(invRes);
        return true;
    
      }
    
      //Permet de retirer une ressource de l'inventaire
      public boolean retirerRessource(Ressource ressource, int quantite, int idPerso) {
        Optional<Personnage> personnage = getPersoById(idPerso);
        Collection<InventaireRessource> it = personnage.get().getInventaireRessource();
        for(InventaireRessource invRessource : it){
          if (invRessource.getRessource().getId() == ressource.getId()) {
            invRessource.retirerRessource(quantite);
            iRRepository.save(invRessource);
          }
        }
        return false;
      }
    
      //Sauvegarde du joueur en BDD
      public boolean sauvegarderJoueur(Personnage personnage) {
        pRepository.save(personnage);
        return true;
      }
    
}
