package fil.rouge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.RessourceRepository;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;

@Controller
@SessionAttributes("personnage")
public class jeuController {
    
    @Autowired 
    private RessourceRepository ressourceRepository;

    @GetMapping("/jeu")
    public String jeu(@ModelAttribute Personnage personnage, Model model) {
        Optional<Ressource> ressource = ressourceRepository.findById(4);
        
        model.addAttribute("ressource", ressource.get());
        personnage.setName("toto");
        return "jeu";
    }

    @ModelAttribute
    public Personnage personnage() {
        return new Personnage();
    }
}
