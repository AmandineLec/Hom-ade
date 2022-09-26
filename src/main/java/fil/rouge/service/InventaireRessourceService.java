package fil.rouge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;

@Service
public class InventaireRessourceService {


    @Autowired
    InventaireRessourceRepository inventaireRessourceRepository;

    @Autowired
    RessourceRepository ressourceRepository;


    //Permet de retirer un objet de l'inventaire
    public boolean retirerRessource(int idRessource, int quantite, Personnage personnage) { // Ressource à retirer, quantité à retirer, id du perso concerné
        Ressource ressource = ressourceRepository.getReferenceById(idRessource);

        Collection<InventaireRessource> it = inventaireRessourceRepository.findByPersonnage(personnage); //On récupère les inventaires via la query d'InventaireRessourceRepository
        for(InventaireRessource invRessource : it){ // On parcours la collection d'inventaire
            if (invRessource.getRessource().getId() == ressource.getId()) {// Si l'id de la ressource à retirer est trouvé dans la collection
                invRessource.retirerRessource(quantite); // Alors on modifie la quantité de la ressource
                inventaireRessourceRepository.save(invRessource); // On sauvegarde en BDD la MAJ de l'inventaire
                return true; // Return true si on a réussi à retirer la quantité de ressource indiquée
            }
        }
        return false; // Si l'id n'est pas trouvé, on ne peut pas le retirer donc return false
    }

        //Permet d'ajouter un objet dans l'inventaire
        public boolean ajouterRessource(Personnage personnage, int Idressource, int quantite){ // id perso concerné, id objet à ajouter, quantité à ajouter
            Ressource ressource = ressourceRepository.getReferenceById(Idressource); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
    
            Collection<InventaireRessource> it = inventaireRessourceRepository.findByPersonnage(personnage); //On récupère les inventaires via la query d'InventaireObjetRepository
            for(InventaireRessource invRessource : it){ // On parcours la collection d'inventaire
    
                // Si l'id de l'objet à ajouter ET si l'id du perso sont trouvés
                if (invRessource.getRessource().getId() == ressource.getId() && invRessource.getPersonnage().getId_personnage() == personnage.getId_personnage()) { 
                    invRessource.ajouterRessource(quantite); // Alors on modifie la quantité de l'objet
                    inventaireRessourceRepository.save(invRessource); // On sauvegarde en BDD la MAJ de l'inventaire
                    return true;
                }
            }
    
            // si pas trouvé l'association
            InventaireRessource invObj = new InventaireRessource(personnage, ressource, quantite);
            inventaireRessourceRepository.save(invObj);
            return true;
        }
}
