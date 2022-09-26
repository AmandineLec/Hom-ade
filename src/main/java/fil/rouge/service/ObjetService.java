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

    public boolean createObject(Personnage personnage, int id){
        Optional<Objet> Optobjet = oRepository.findById(id);
        Objet objet = Optobjet.get();
        inventaireObjetService.ajouterObjet(personnage, objet.getId(), 1);
        return true;
    }
}
