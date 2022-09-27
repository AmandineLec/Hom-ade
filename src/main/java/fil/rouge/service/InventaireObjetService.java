package fil.rouge.service;

import java.util.Collection;
import java.util.Optional;

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

    // TODO:
    // Gérer toutes les exceptions

    //Permet d'ajouter un objet dans l'inventaire
    public boolean ajouterObjet(int idPerso, int idObj, int quantite){ // id perso concerné, id objet à ajouter, quantité à ajouter
        Personnage personnage = pRepository.getReferenceById(idPerso); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
        Optional<Objet> objet = oRepository.findById(idObj); //Récupère l'objet qu'il faut ajouter

        Collection<InventaireObjet> it = ioRepository.findByPersonnage(personnage); //On récupère les inventaires via la query d'InventaireObjetRepository
        for(InventaireObjet invObjet : it){ // On parcours la collection d'inventaire

            // Si l'id de l'objet à ajouter ET si l'id du perso sont trouvés
            if (invObjet.getObjet().getId() == objet.get().getId()) { 
                invObjet.ajouterObjet(quantite); // Alors on modifie la quantité de l'objet
                ioRepository.save(invObjet); // On sauvegarde en BDD la MAJ de l'inventaire
                return true;
            }
        }

        // si pas trouvé l'association
        InventaireObjet invObj = new InventaireObjet(personnage, objet.get(), quantite); //On crée un nouvel inventaire objet
        ioRepository.save(invObj); //On save en BDD
        return true;
    }

    //Permet de retirer un objet de l'inventaire
    public boolean retirerObjet(int idObj, int quantite, int idPerso) { // Objet à retirer, quantité à retirer, id du perso concerné
        Personnage personnage = pRepository.getReferenceById(idPerso); // Méthode de JpaRepository permettant de créer une "fausse" entité (éphémère) (ne récupère que ce qu'il y a besoin, cad l'id)
        Optional<Objet> objet = oRepository.findById(idObj);

        Collection<InventaireObjet> it = ioRepository.findByPersonnage(personnage); //On récupère les inventaires via la query d'InventaireObjetRepository
        for(InventaireObjet invObjet : it){ // On parcours la collection d'inventaire
            // Si l'id de l'objet à ajouter ET si l'id du perso sont trouvés
            if (invObjet.getObjet().getId() == objet.get().getId()) {
                invObjet.retirerObjet(quantite); // Alors on modifie la quantité de l'objet
                ioRepository.save(invObjet); // On sauvegarde en BDD la MAJ de l'inventaire
                return true; // Return true si on a réussi à retirer la quantité d'objet indiquée
            }
        }
        return false; // Si les id ne sont pas trouvés, on ne peut pas retirer donc return false
    }


    

}
