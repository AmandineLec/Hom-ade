package fil.rouge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.rouge.model.Personnage;

@RestController
@RequestMapping(value = "/personnage")
public class UtilisateurController {
    
    @GetMapping("/test")
    public String showPersonnage(){
        return "test";
    }
}

