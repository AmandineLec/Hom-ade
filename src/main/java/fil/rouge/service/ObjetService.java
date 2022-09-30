package fil.rouge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;

@Service
public class ObjetService {

    @Autowired
    protected ObjetRepository oRepository;

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
        //On crée un liste optional des objets en faisant un appel sur la BDD avec un ID
        Optional<Objet> Optobjet = oRepository.findById(id);
        //On va chercher l'objet présent dans la liste/ 
        Objet objet = Optobjet.get();
        //On fait appel à la méthode ajouter objet pour ajouter l'objet dans l'inventaire du personnage. 
        inventaireObjetService.ajouterObjet(personnage, objet.getId(), 1);
        return true;
    }
}
