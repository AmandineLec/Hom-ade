package fil.rouge.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;

@Service
public class InventaireObjetService {
    
    @Autowired
    private PersonnageRepository pRepository;

    @Autowired 
    private ObjetRepository oRepository;

    @Autowired
    private InventaireObjetRepository ioRepository;

    //Permet d'ajouter un objet dans l'inventaire
    public boolean ajouterObjet(int idPerso, int Idobj, int quantite){ // id perso concerné, id objet à ajouter, quantité à ajouter
        Personnage personnage = pRepository.getReferenceById(idPerso); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
        Objet objet = oRepository.getReferenceById(Idobj);

        Collection<InventaireObjet> it = ioRepository.findByPersonnageAndObjet(personnage, objet); //On récupère les inventaires via la query d'InventaireObjetRepository
        for(InventaireObjet invObjet : it){ // On parcours la collection d'inventaire

            // Si l'id de l'objet à ajouter ET si l'id du perso sont trouvés
            if (invObjet.getObjet().getId() == objet.getId() && invObjet.getPersonnage().getId_personnage() == personnage.getId_personnage()) { 
                invObjet.ajouterObjet(quantite); // Alors on modifie la quantité de l'objet
                ioRepository.save(invObjet); // On sauvegarde en BDD la MAJ de l'inventaire
                return true;
            }
        }

        // si pas trouvé l'association
        InventaireObjet invObj = new InventaireObjet(personnage, objet, quantite);
        ioRepository.save(invObj);
        return true;
    }

    //Permet de retirer un objet de l'inventaire
    public boolean retirerObjet(int idObj, int quantite, int idPerso) { // Objet à retirer, quantité à retirer, id du perso concerné
        Personnage personnage = pRepository.getReferenceById(idPerso); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
        Objet objet = oRepository.getReferenceById(idObj);

        Collection<InventaireObjet> it = ioRepository.findByPersonnageAndObjet(personnage, objet); //On récupère les inventaires via la query d'InventaireObjetRepository
        for(InventaireObjet invObjet : it){ // On parcours la collection d'inventaire
            if (invObjet.getObjet().getId() == objet.getId()) {// Si l'id de l'objet à retirer est trouvé dans la collection
                invObjet.retirerObjet(quantite); // Alors on modifie la quantité de l'objet
                ioRepository.save(invObjet); // On sauvegarde en BDD la MAJ de l'inventaire
                return true; // Return true si on a réussi à retirer la quantité d'objet indiquée
            }
        }
        return false; // Si l'id n'est pas trouvé, on ne peut pas le retirer donc return false
    }

}
