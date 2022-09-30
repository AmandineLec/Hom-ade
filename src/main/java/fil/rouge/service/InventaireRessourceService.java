package fil.rouge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    //Méhtode d'ajout de ressource dans l'inventaire du personnage en fonction de l'id de la ressource que l'on veut ajouter, du personnage a qui on veut l'ajouter et de la quantité ramasser/récolter
    public boolean ajouterRessource(int idRessource, Personnage personnage, int quantite){
        //On instancie une ressource que l'on va retirer en getReferenceById car on ne sait pas quelle ressource on va retirer par avance. 
        Ressource resource = ressourceRepository.getReferenceById(idRessource);
        //On va chercher toutes les ressources présentes dans l'inventaire du personnage. 
        List<InventaireRessource> ressources = inventaireRessourceRepository.findByPersonnage(personnage);
        //Pour chaque ressource présente dans l'inventaire
        for(InventaireRessource ressource : ressources){
            //On compare l'id de la ressource instanciée avec les id des ressources présentes dans l'inventaire
            if(resource.getId() == ressource.getRessource().getId()){
                //Si la ressource est déjà présente, on met à jour sa quantité
                ressource.setQuantite(ressource.getQuantite()+quantite);
                //On save ensuite la nouvelle quantité dans la base de données. 
                inventaireRessourceRepository.save(ressource);
                return true;
            }
        }
        //Si on ne trouve aucun inventaireRessource au personnage (et donc qu'il est vide), On lui crée son inventaire, 
        //En lui ajoutant la ressource et lui settant la quantité. 
        InventaireRessource invRessource = new InventaireRessource(personnage, resource, quantite);
        personnage.addInventaireRessource(invRessource);
        //On save ensuite cet inventaire dans la base de données. 
        inventaireRessourceRepository.save(invRessource);
        return true; 
    }

    //Permet de retirer un objet de l'inventaire
    public boolean retirerRessource(int idRessource, int quantite, Personnage personnage) { // Ressource à retirer, quantité à retirer, id du perso concerné
        Ressource ressource = ressourceRepository.getReferenceById(idRessource);

        List<InventaireRessource> it = inventaireRessourceRepository.findByPersonnage(personnage); //On récupère les inventaires via la query d'InventaireRessourceRepository
        for(InventaireRessource invRessource : it){ // On parcours la collection d'inventaire
            if (invRessource.getRessource().getId() == ressource.getId()) {// Si l'id de la ressource à retirer est trouvé dans la collection
                invRessource.setQuantite(invRessource.getQuantite()-quantite);; // Alors on modifie la quantité de la ressource
                inventaireRessourceRepository.save(invRessource); // On sauvegarde en BDD la MAJ de l'inventaire
                return true; // Return true si on a réussi à retirer la quantité de ressource indiquée
            }
        }
        return false; // Si l'id n'est pas trouvé, on ne peut pas le retirer donc return false
    }


}
