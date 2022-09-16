package fil.rouge.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fil.rouge.Repository.RessourceRepository;
import fil.rouge.model.Ressource;

@Controller
public class jeuController {
    
    @Autowired 
    private RessourceRepository ressourceRepository;

    @GetMapping("/jeu")
    public String jeu(Model model) {
        Optional<Ressource> ressource = ressourceRepository.findById(4);
        System.out.println(ressource.get().getNom());
        model.addAttribute("ressource", ressource.get());
        return "jeu";
    }
}
