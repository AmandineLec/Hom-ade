package fil.rouge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.model.Personnage;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.InventaireObjet;

@RestController
@SessionAttributes("personnage")
public class InventaireRestController {
    @Autowired
    InventaireRessourceRepository inventaireRessourceRepository;

    @GetMapping("/api/InventaireRessource")
    public List<InventaireRessource> InventaireRessource(@ModelAttribute Personnage personnage){
        return inventaireRessourceRepository.findByPersonnage(personnage);
    }

    @Autowired
    InventaireObjetRepository inventaireObjetRepository;

    @GetMapping("/api/InventaireObjet")
    public List<InventaireObjet> InventaireObjet(@ModelAttribute Personnage personnage){
        return inventaireObjetRepository.findByPersonnage(personnage);
    }
}
