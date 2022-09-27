package fil.rouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dto.ObjetRecoltableDTO;
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

    
    
    public ObjetRecoltableDTO recoltageRamassage(Personnage personnage, int objetRecoltableId, int pv) {
        ObjetRecoltable objetRecoltable = objetRecoltableService.getObjetRecoltable(objetRecoltableId);
        

        try {
            // Lors du clic, on utilise l'outil du personnage sur l'objet récoltable, et on récupère sa nouvelle résistance
            pv = Math.max(objetRecoltableService.utiliserOutil(personnage, objetRecoltable, pv), 0);
            objetRecoltable.setPv(pv);
        } catch (WrongToolException e) {
            e.printStackTrace();
        }
        // Si la résistance est à 0, on récupère la liste des ressources à récupérer sur l'objet récoltable et on les ajoute à l'inventaire
        if (pv == 0) {
            List<RessourcesRecoltees> listeRessources = ressourceService.listeRessourcesRamassees(objetRecoltable.getIdElementRecoltable());
            for (RessourcesRecoltees ressources : listeRessources) {
                ressourceService.ajoutRessourceInventaire(personnage, ressources.getRessource().getId(), ressources.getQuantite());
            }
            objetRecoltable = objetRecoltableService.disparait(objetRecoltable);
        }
        ObjetRecoltableDTO dto = convertDataIntoDTO(objetRecoltable);
        return dto;
    }

    // convertit un objet récoltable en DTO
    private ObjetRecoltableDTO convertDataIntoDTO(ObjetRecoltable objetRecoltable) {
        ObjetRecoltableDTO dto = new ObjetRecoltableDTO();

        dto.setIdObjetRecoltable(objetRecoltable.getIdElementRecoltable());
        dto.setNom(objetRecoltable.getNom());
        dto.setPv(objetRecoltable.getPv());
        dto.setCooldown(objetRecoltable.getCooldown());
        dto.setDisparitionTime(objetRecoltable.getDisparitionTime());

        return dto;
    }
}
