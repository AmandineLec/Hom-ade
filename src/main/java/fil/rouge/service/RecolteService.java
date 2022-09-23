package fil.rouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.model.Personnage;
import fil.rouge.model.RessourcesRecoltees;


@Service
public class RecolteService {

    @Autowired
    RamassageService ramassageService;

    @Autowired
    ObjetRecoltableService recoltageService;

    
    
    public int recoltageRamassage(Personnage personnage, int objetRecoltableId, int resistance) {
        
        resistance = recoltageService.utiliserOutil(personnage, objetRecoltableId, resistance);
        if (resistance <= 0) {
            List<RessourcesRecoltees> listeRessources = ramassageService.listeRessourcesRamassees(objetRecoltableId);
            for (RessourcesRecoltees ressources : listeRessources) {
                ramassageService.ajoutRessourceInventaire(personnage, ressources.getRessource().getId(), ressources.getQuantite());
            }
        }

        return resistance;
    }
}
