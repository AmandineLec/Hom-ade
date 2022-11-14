package fil.rouge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.dto.TabObjetRecoltableDTO;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetRecoltableService;
import fil.rouge.service.RecolteService;

@RestController
public class RecolteController {
    @Autowired
    RecolteService recolteService;

    @Autowired
    ObjetRecoltableService objetRecoltableService;

    @Autowired
    PersonnageRepository pRepository;

    // accède lorsqu'on clique sur un objet récoltable
    @GetMapping("/api/recolte")
    public ObjetRecoltableDTO recolte(Principal principal, @SessionAttribute TabObjetRecoltableDTO tabObjetRecoltableDTO,
            @RequestParam int index, Model model) {
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        ObjetRecoltableDTO objRecDTO = tabObjetRecoltableDTO.getObjetsRecoltables(index);

        ObjetRecoltableDTO objetRecoltableDTO = recolteService.recolteRamassage(personnage,  // récupère l'objet récoltable après une action
        objRecDTO);
        tabObjetRecoltableDTO.addObjetsRecoltables(objetRecoltableDTO, index);  // remet l'objet récoltable à sa place dans le tableau des objets récoltables

        model.addAttribute("personnage", personnage);

        model.addAttribute("tabObjetRecoltableDTO", tabObjetRecoltableDTO);

        return objetRecoltableDTO;
    }

    // renvoie la liste des objets récoltables en jeu
    @GetMapping("api/recoltables")
    public ObjetRecoltableDTO[] getRecoltables(Principal principal, @SessionAttribute TabObjetRecoltableDTO tabObjetRecoltableDTO, Model model) {
        ObjetRecoltableDTO[] objetsRecoltables = tabObjetRecoltableDTO.getObjetsRecoltables();
        for (ObjetRecoltableDTO objetRecoltable : objetsRecoltables) {
            if(objetRecoltable.getPv() == 0 && objetRecoltableService.reapparait(objetRecoltable))   // respawn de l'objet récoltable
                objetRecoltable.setPv(objetRecoltable.getPvMax());
        }
        return objetsRecoltables;
    }

}
