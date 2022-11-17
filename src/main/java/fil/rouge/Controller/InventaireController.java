package fil.rouge.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;

@Controller
//@SessionAttributes("personnage")
public class InventaireController {
    
    @Autowired
    InventaireRessourceRepository inventaireRessourceRepository;

    @GetMapping("/modalInventaireRessource")
    public String InventaireRessource(@ModelAttribute Personnage personnage, Model model){
        List<InventaireRessource> Iressources = inventaireRessourceRepository.findByPersonnage(personnage);
        model.addAttribute("Iressources", Iressources);
        return "/jeu ::modalInventaireRessource";
    }

    @Autowired
    InventaireObjetRepository inventaireObjetRepository;

    @GetMapping("/modalInventaireObjet")
    public String InventaireObjet(@ModelAttribute Personnage personnage, Model model){
        List<InventaireObjet> Iobjets = inventaireObjetRepository.findByPersonnage(personnage);
        model.addAttribute("Iobjets", Iobjets);
        return "/jeu ::modalInventaireObjet";
    }
}
