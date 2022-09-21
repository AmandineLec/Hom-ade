package fil.rouge.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRecoltableRepository;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;

@Service
public class RecoltageService {

    @Autowired
    ObjetRecoltableRepository objetRecoltableRepository;


    
    public int utiliserOutil(Personnage personnage, int objetRecoltableId, int resistance) {
        ObjetRecoltable objetRecoltable = objetRecoltableRepository.findById(objetRecoltableId).get();
        Outil outil = personnage.getOutil();
        
        Set<Outil> outils = objetRecoltable.getOutils();
        if (!outils.contains(outil))
            return -100;

        resistance -= outil.getCapacite();
        return resistance;
    }

    
}
