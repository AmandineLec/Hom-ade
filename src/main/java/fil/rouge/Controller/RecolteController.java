package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import fil.rouge.model.Personnage;
import fil.rouge.service.RecolteService;

@Controller
public class RecolteController {
    @Autowired
    RecolteService recolteService;
    
    @PostMapping("/recolte")
    public String recolte(@SessionAttribute("personnage") Personnage personnage, Model model) {
        System.out.println(personnage.getName());
        //recolteService.recoltageRamassage(personnage, objetRecoltableId, resistance);
        return "jeu";
    }

    
}
