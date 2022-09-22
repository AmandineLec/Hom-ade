package fil.rouge.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRecoltableRepository;
import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;

@Service
public class RecoltageService {

    @Autowired
    ObjetRecoltableRepository objetRecoltableRepository;


    // Simule l'utilisation d'un outil sur un objet récoltable
    public int utiliserOutil(Personnage personnage, int objetRecoltableId, int resistance) throws WrongToolException {
        ObjetRecoltable objetRecoltable = objetRecoltableRepository.findById(objetRecoltableId).get();
        Outil outil = personnage.getOutil();
        Set<Outil> outils = objetRecoltable.getOutils();
        
        if (!(outils.contains(outil)))
            throw new WrongToolException("Vous n'utilisez pas le bon outil"); // Lance une exception si l'outil utilisé ne peut pas être utilisé sur l'objet récoltable
                       

        resistance -= outil.getCapacite();
        return resistance;          // Retourne la résistance de l'objet récoltable après utilisation de l'outil
    }

    
}
