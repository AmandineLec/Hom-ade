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


    
    public boolean utiliserOutil(Personnage personnage, ObjetRecoltable objetRecoltable) {

        Outil outil = personnage.getOutil();
        
        Set<Outil> outils = objetRecoltable.getOutils();
        if (!outils.contains(outil))
            return false;

        objetRecoltable.setDifficulte(objetRecoltable.getDifficulte() - outil.getCapacite());
        return true;
    }

    
}
