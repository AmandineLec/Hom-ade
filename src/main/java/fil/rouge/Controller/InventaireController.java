package fil.rouge.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.rouge.dao.InventaireObjetRepository;
import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;

@RestController
public class InventaireController {
    
    @Autowired
    InventaireRessourceRepository inventaireRessourceRepository;

    @Autowired
    PersonnageRepository pRepository; 


    @GetMapping("/api/InventaireRessource")
    public List<InventaireRessource> InventaireRessource(Principal principal){
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        return inventaireRessourceRepository.findByPersonnage(personnage);
    }

    @Autowired
    InventaireObjetRepository inventaireObjetRepository;

    @GetMapping("/api/InventaireObjet")
    public List<InventaireObjet> InventaireObjet(Principal principal){
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        return inventaireObjetRepository.findByPersonnage(personnage);
    }
}
