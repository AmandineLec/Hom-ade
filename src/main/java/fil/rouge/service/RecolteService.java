package fil.rouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.exception.WrongToolException;
import fil.rouge.model.Personnage;
import fil.rouge.model.RessourcesRecoltees;



@Service
public class RecolteService {

    @Autowired
    RamassageService ramassageService;

    @Autowired
    RecoltageService recoltageService;

    
    
    public int recoltageRamassage(Personnage personnage, int objetRecoltableId, int resistance) {
        
        try {
            // Lors du clic, on utilise l'outil du personnage sur l'objet récoltable, et on récupère sa nouvelle résistance
            resistance = Math.max(recoltageService.utiliserOutil(personnage, objetRecoltableId, resistance), 0);
        } catch (WrongToolException e) {
            e.printStackTrace();
        }
        // Si la résistance est à 0, on récupère la liste des ressources à récupérer sur l'objet récoltable et on les ajoute à l'inventaire
        if (resistance == 0) {
            List<RessourcesRecoltees> listeRessources = ramassageService.listeRessourcesRamassees(objetRecoltableId);
            for (RessourcesRecoltees ressources : listeRessources) {
                ramassageService.ajoutRessourceInventaire(personnage, ressources.getRessource().getId(), ressources.getQuantite());
            }
        }

        return resistance;
    }
}
