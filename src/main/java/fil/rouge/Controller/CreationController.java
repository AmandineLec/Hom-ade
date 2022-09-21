package fil.rouge.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.model.Objet;

@Controller
public class CreationController {
        
    @Autowired 
    private ObjetRepository objetRepository;

    @GetMapping("/jeu")
    public String jeu(Model model) {
        Optional<Objet> objet = objetRepository.findById(3);
        
        model.addAttribute("objet", objet.get());
        return "jeu";
    }
}
