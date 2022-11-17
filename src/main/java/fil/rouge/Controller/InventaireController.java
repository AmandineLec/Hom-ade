package fil.rouge.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;

@Controller
public class InventaireController {
    
    @Autowired
    InventaireRessourceRepository inventaireRessourceRepository;

    @Autowired
    PersonnageRepository pRepository; 


    @GetMapping("/modalInventaireRessource")
    public String InventaireRessource(Principal principal, Model model){
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        List<InventaireRessource> Iressources = inventaireRessourceRepository.findByPersonnage(personnage);
        model.addAttribute("Iressources", Iressources);
        return "/jeu ::modalInventaireRessource";
    }

    @Autowired
    InventaireObjetRepository inventaireObjetRepository;

    @GetMapping("/modalInventaireObjet")
    public String InventaireObjet(Principal principal, Model model){
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        List<InventaireObjet> Iobjets = inventaireObjetRepository.findByPersonnage(personnage);
        model.addAttribute("Iobjets", Iobjets);
        return "/jeu ::modalInventaireObjet";
    }
}
