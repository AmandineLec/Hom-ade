package fil.rouge.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;

@Service
public class InventaireRessourceService {
    
    @Autowired
    private PersonnageRepository pRepository;

    @Autowired 
    private RessourceRepository rRepository;

    @Autowired
    private InventaireRessourceRepository irRepository;

    //Permet d'ajouter une ressource dans l'inventaire
    public boolean ajouterRessource(int idPerso, int idRes, int quantite){ // id perso concerné, id ressource à ajouter, quantité à ajouter
        Personnage personnage = pRepository.getReferenceById(idPerso); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
        Ressource ressource = rRepository.getReferenceById(idRes);

        Collection<InventaireRessource> it = irRepository.findByPersonnageAndRessource(personnage, ressource); //On récupère les inventaires via la query d'InventaireRessourceRepository
        for(InventaireRessource invRes : it){ // On parcours la collection d'inventaire

            // Si l'id de la ressource à ajouter ET si l'id du perso sont trouvés
            if (invRes.getRessource().getId() == ressource.getId() && invRes.getPersonnage().getIdPersonnage() == personnage.getIdPersonnage()) { 
                invRes.ajouterRessource(quantite); // Alors on modifie la quantité de la ressource
                irRepository.save(invRes); // On sauvegarde en BDD la MAJ de l'inventaire
                return true;
            }
        }

        // si pas trouvé l'association
        InventaireRessource invObj = new InventaireRessource(personnage, ressource, quantite);
        irRepository.save(invObj);
        return true;
    }

    //Permet de retirer une ressource de l'inventaire
    public boolean retirerRessource(int idRes, int quantite, int idPerso) { // ressource à retirer, quantité à retirer, id du perso concerné
        Personnage personnage = pRepository.getReferenceById(idPerso); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
        Ressource ressource = rRepository.getReferenceById(idRes);

        Collection<InventaireRessource> it = irRepository.findByPersonnageAndRessource(personnage, ressource); //On récupère les inventaires via la query d'InventaireRessourceRepository
        for(InventaireRessource invRes : it){ // On parcours la collection d'inventaire
            // Si l'id de la ressource à ajouter ET si l'id du perso sont trouvés
            if (invRes.getRessource().getId() == ressource.getId() && invRes.getPersonnage().getIdPersonnage() == personnage.getIdPersonnage()) {
                invRes.retirerRessource(quantite); // Alors on modifie la quantité de la ressource
                irRepository.save(invRes); // On sauvegarde en BDD la MAJ de l'inventaire
                return true; // Return true si on a réussi à retirer la quantité de ressource indiquée
            }
        }
        return false; // Si les id ne sont pas trouvés, on ne peut pas retirer donc return false
    }


    

}
