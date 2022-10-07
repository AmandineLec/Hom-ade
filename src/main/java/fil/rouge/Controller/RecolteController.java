package fil.rouge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    TabObjetRecoltableDTO tabORDto;
    
    @PostMapping("/recolte")
    public String recolte(Principal principal, @RequestParam int index, Model model) {
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        
        // if (oRDto.getPv() == 0)
        //     oRDto = new ObjetRecoltableDTO();
        // if (oRDto.getIdObjetRecoltable() == 0)
        //     oRDto = recolteService.recolteRamassage(personnage, id, -1);
            
        // else 
        //     oRDto = recolteService.recolteRamassage(personnage, id, oRDto.getPv());
        
        
        // model.addAttribute("oRDto", oRDto);

        ObjetRecoltableDTO objetRecoltableDTO = recolteService.recolteRamassage(personnage, index, tabORDto.getObjetsRecoltables(index).getPv());
        tabORDto.addObjetsRecoltables(objetRecoltableDTO, index); 
        model.addAttribute("tab", tabORDto.getObjetsRecoltables());
        
        return "jeu";
    }

    
    

}
