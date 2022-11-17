package fil.rouge.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/personnage")
public class UtilisateurController {
    
    @GetMapping("/test")
    public String showPersonnage(){
        return "test";
    }
}

// POST => entity personnage