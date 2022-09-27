package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import fil.rouge.dto.ObjetRecoltableDTO;
import fil.rouge.model.Personnage;
import fil.rouge.service.RecolteService;

@RestController
public class RecolteController {
    @Autowired
    RecolteService recolteService;
    
    @PostMapping("/recolte")
    public ObjetRecoltableDTO recolte(@SessionAttribute("personnage") Personnage personnage, @RequestParam int id, @RequestParam int pv) {
        
        ObjetRecoltableDTO dto = recolteService.recoltageRamassage(personnage, id, pv);
        
        return dto;
    }

    
    

}
