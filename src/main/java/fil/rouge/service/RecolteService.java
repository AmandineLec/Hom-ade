package fil.rouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Personnage;
import fil.rouge.model.RessourcesRecoltees;


@Service
public class RecolteService {

    @Autowired
    RessourceService ressourceService;

    @Autowired
    ObjetRecoltableService objetRecoltableService;

    
    
    public int recoltageRamassage(Personnage personnage, int objetRecoltableId, int pv) {
        ObjetRecoltable objetRecoltable = objetRecoltableService.getObjetRecoltable(objetRecoltableId);

        try {
            // Lors du clic, on utilise l'outil du personnage sur l'objet récoltable, et on récupère sa nouvelle résistance
            pv = Math.max(objetRecoltableService.utiliserOutil(personnage, objetRecoltable, pv), 0);
        } catch (WrongToolException e) {
            e.printStackTrace();
        }
        // Si la résistance est à 0, on récupère la liste des ressources à récupérer sur l'objet récoltable et on les ajoute à l'inventaire
        if (pv == 0) {
            List<RessourcesRecoltees> listeRessources = ressourceService.listeRessourcesRamassees(objetRecoltable.getIdElementRecoltable());
            for (RessourcesRecoltees ressources : listeRessources) {
                ressourceService.ajoutRessourceInventaire(personnage, ressources.getRessource().getId(), ressources.getQuantite());
            }
        }

        return pv;
    }
}
