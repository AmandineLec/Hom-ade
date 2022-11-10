package fil.rouge.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.ObjetRecoltableRepository;
import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.dto.TabObjetRecoltableDTO;
import fil.rouge.exception.WrongToolException;
import fil.rouge.model.ObjetRecoltable;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;

@Service
public class ObjetRecoltableService {

    @Autowired
    private ObjetRecoltableRepository objetRecoltableRepository;

    public ObjetRecoltable getObjetRecoltable(int objetRecoltableId) throws EntityNotFoundException {
        return ServiceUtils.getEntity(objetRecoltableRepository, objetRecoltableId);
    }
    

    // Simule l'utilisation d'un outil sur un objet récoltable
    public int utiliserOutil(Personnage personnage, int objetRecoltableId, int pv)
            throws WrongToolException {
        ObjetRecoltable objetRecoltable = getObjetRecoltable(objetRecoltableId);
        Outil outil = personnage.getOutil();
        Set<Outil> outils = objetRecoltable.getOutils();

        if (!(outils.contains(outil)))
            throw new WrongToolException("Vous n'utilisez pas le bon outil"); // Lance une exception si l'outil utilisé
                                                                              // ne peut pas être utilisé sur l'objet
                                                                              // récoltable

        if (pv == -1)
                pv = objetRecoltable.getPv();

        return pv - outil.getCapacite(); // Retourne les pv de l'objet récoltable après utilisation de l'outil
    }

    public ObjetRecoltable disparait(ObjetRecoltable objetRecoltable) {
        objetRecoltable.setDisparitionTime(System.currentTimeMillis());
        return objetRecoltable;
    }

    // Indique si un objet récoltable peut réapparaitre
    public boolean reapparait(ObjetRecoltableDTO objetRecoltable) {
        long time = System.currentTimeMillis();

        return time >= objetRecoltable.getDisparitionTime() + objetRecoltable.getCooldown();
    }

    // Récupère tous les DTO des objets récoltables
    public List<ObjetRecoltableDTO> getAllObjetRecoltable() {
        return ((List<ObjetRecoltable>) objetRecoltableRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
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

    // Récupère un dto de l'objet récoltable d'id objRecId
    private ObjetRecoltableDTO getObjetRecoltablleDto(int objRecId) {
        ObjetRecoltable objetRecoltable = getObjetRecoltable(objRecId);

        return convertDataIntoDTO(objetRecoltable);
    }

    // Initialise les objets récoltables
    public TabObjetRecoltableDTO initObjReco() {
        TabObjetRecoltableDTO tabObjetRecoltableDTO = new TabObjetRecoltableDTO();
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(10), 0);  //Séquoia centre
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(26), 1);  //Sardine centre
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(51), 2);  //Silex centre
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(46), 3);  //Mare nord
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(42), 4);  //Coton nord
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(52), 5);  //Coquille Saint Jacques nord
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(6), 6);  //Roseau nord
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(47), 7);  //Pluie sud
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(43), 8);  //Lin sud
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(53), 9);  //Eau sud
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(38), 10);  //Marbre sud
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(50), 11);  //Sève sud-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(54), 12);  //Bois Mort sud-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(39), 13);  //Schiste sud-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(8), 14);  //Chêne sud-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(40), 15);  //Diamant ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(53), 16);  //Eau ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(41), 17);  //Champignon ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(9), 18);  //Ebène ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(7), 19);  //Bambou nord-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(55), 20);  //Paquerettes nord-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(36), 21);  //Brique nord-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(27), 22);  //Carpe nord-ouest
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(49), 23);  //Source est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(51), 24);  //silex est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(48), 25);  //Rivière est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(28), 26);  //Truite est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(32), 27);  //Cuivre nord-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(56), 28);  //Plomb nord-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(31), 29);  //Fer nord-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(37), 30);  //Granit nord-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(44), 31);  //Chanvre sud-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(52), 32);  //Coquille Saint Jacques sud-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(45), 33);  //Jute sud-est
        tabObjetRecoltableDTO.addObjetsRecoltables(getObjetRecoltablleDto(29), 34);  //Brochet sud-est
       
        
        return tabObjetRecoltableDTO;
    }
}
