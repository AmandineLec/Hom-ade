package fil.rouge.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.dto.TabObjetRecoltableDTO;
import fil.rouge.model.Personnage;
import fil.rouge.service.RecolteService;


@Controller
public class RecolteController {
    @Autowired
    RecolteService recolteService;

    @Autowired
    PersonnageRepository pRepository;

    @Autowired
    ObjetRecoltableDTO oRDto;

        
    @PostMapping("/recolte")
    public String recolte(Principal principal, @SessionAttribute TabObjetRecoltableDTO tabObjetRecoltableDTO, @RequestParam int index, Model model) {
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        ObjetRecoltableDTO objRecDTO = tabObjetRecoltableDTO.getObjetsRecoltables(index);
        System.out.println("test2" + tabObjetRecoltableDTO);
        // if (oRDto.getPv() == 0)
        //     oRDto = new ObjetRecoltableDTO();
        // if (oRDto.getIdObjetRecoltable() == 0)
        //     oRDto = recolteService.recolteRamassage(personnage, id, -1);
            
        // else 
        //     oRDto = recolteService.recolteRamassage(personnage, id, oRDto.getPv());
        
        
        // model.addAttribute("oRDto", oRDto);

        ObjetRecoltableDTO objetRecoltableDTO = recolteService.recolteRamassage(personnage, objRecDTO.getIdObjetRecoltable(), objRecDTO.getPv());
        tabObjetRecoltableDTO.addObjetsRecoltables(objetRecoltableDTO, index); 
        System.out.println("test3" + tabObjetRecoltableDTO);
        model.addAttribute("tabObjetRecoltableDTO", tabObjetRecoltableDTO);
        
        return "jeu";
    }

    
    

}
