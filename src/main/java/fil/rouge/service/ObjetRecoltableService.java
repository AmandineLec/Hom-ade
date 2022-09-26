package fil.rouge.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRecoltableRepository;
import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;

@Service
public class ObjetRecoltableService {

    @Autowired
    ObjetRecoltableRepository objetRecoltableRepository;

    public ObjetRecoltable getObjetRecoltable(int objetRecoltableId) throws EntityNotFoundException {
        return ServiceUtils.getEntity(objetRecoltableRepository, objetRecoltableId);
      }

    // Simule l'utilisation d'un outil sur un objet récoltable
    public int utiliserOutil(Personnage personnage, ObjetRecoltable objetRecoltable, int pv) throws WrongToolException {
        Outil outil = personnage.getOutil();
        Set<Outil> outils = objetRecoltable.getOutils();
        
        if (!(outils.contains(outil)))
            throw new WrongToolException("Vous n'utilisez pas le bon outil"); // Lance une exception si l'outil utilisé ne peut pas être utilisé sur l'objet récoltable 

        pv -= outil.getCapacite();
        return pv;          // Retourne la résistance de l'objet récoltable après utilisation de l'outil
    }


    public void disparait(ObjetRecoltable objetRecoltable) {
        objetRecoltable.setDisparitionTime(System.currentTimeMillis());
    }


    // Indique si un objet récoltable peut réapparaitre
    public boolean reapparait(ObjetRecoltable objetRecoltable) {
        long time = System.currentTimeMillis();

        return time >= objetRecoltable.getDisparitionTime() + objetRecoltable.getCooldown();
    }

    public List<ObjetRecoltableDTO> getAllObjetRecoltable() {
        return ((List<ObjetRecoltable>) objetRecoltableRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                    .collect(Collectors.toList());
    }


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
