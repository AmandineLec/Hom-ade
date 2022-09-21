package fil.rouge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.model.Objet;

@Service
public class ObjetService {

    @Autowired
    protected ObjetRepository objetRepository;

    public ObjetService(){

    }

    public ObjetRepository getObjetRepository() {
        return objetRepository;
    }

    public void setObjetRepository(ObjetRepository objetRepository) {
        this.objetRepository = objetRepository;
    }

    public Objet createObject(int id){
        Optional<Objet> Optobjet = objetRepository.findById(id);
        Objet objet = Optobjet.get();
        return objet;
    }
}
