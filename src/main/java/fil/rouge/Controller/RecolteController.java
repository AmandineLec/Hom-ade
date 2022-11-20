package fil.rouge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.dto.TabObjetRecoltableDTO;
import fil.rouge.service.ObjetRecoltableService;
import fil.rouge.service.RecolteService;

@RestController
@SessionAttributes("tabObjetRecoltableDTO")
public class RecolteController {
    @Autowired
    RecolteService recolteService;

    @Autowired
    ObjetRecoltableService objetRecoltableService;

    // accède lorsqu'on clique sur un objet récoltable
    @GetMapping("/api/recolte")
    public ObjetRecoltableDTO recolte(Principal principal,
            @ModelAttribute TabObjetRecoltableDTO tabObjetRecoltableDTO,
            @RequestParam int index, Model model) {

        ObjetRecoltableDTO objRecDTO = tabObjetRecoltableDTO.getObjetsRecoltables(index);
        
        System.out.println(principal.getName());
        ObjetRecoltableDTO objetRecoltableDTO = recolteService.recolteRamassage(principal.getName(), // récupère l'objet
                                                                                                     // récoltable après
                                                                                                     // une action
                objRecDTO);
        if (objetRecoltableDTO.getIdObjetRecoltable() != 0)
            tabObjetRecoltableDTO.addObjetsRecoltables(objetRecoltableDTO, index); // remet l'objet récoltable à sa place
                                                                               // dans le tableau des objets récoltables

        // model.addAttribute("tabObjetRecoltableDTO", tabObjetRecoltableDTO);

        return objetRecoltableDTO;
    }

    // renvoie la liste des objets récoltables en jeu
    @GetMapping("api/recoltables")
    public ObjetRecoltableDTO[] getRecoltables(Principal principal,
    @ModelAttribute TabObjetRecoltableDTO tabObjetRecoltableDTO, Model model) {
        ObjetRecoltableDTO[] objetsRecoltables = tabObjetRecoltableDTO.getObjetsRecoltables();
        for (ObjetRecoltableDTO objetRecoltable : objetsRecoltables) {
            if (objetRecoltable.getPv() == 0 && objetRecoltableService.reapparait(objetRecoltable)) // respawn de
                                                                                                    // l'objet
                                                                                                    // récoltable
                objetRecoltable.setPv(objetRecoltable.getPvMax());
        }
        return objetsRecoltables;
    }

    @ModelAttribute("tabObjetRecoltableDTO")
      public TabObjetRecoltableDTO tabObjetRecoltableDTOb() {
         return objetRecoltableService.initObjReco();
     }
}
