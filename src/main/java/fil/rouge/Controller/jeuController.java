package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.ObjetRepository;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;


// @Controller
// @SessionAttributes("personnage")
// public class jeuController {

//     @Autowired
//     ObjetRepository objetRepository;
    
//      @GetMapping("/jeu")
//     public String jeu(@ModelAttribute Personnage personnage, Model model) {
        
//         personnage.setName("toto");
//         Outil outil = (Outil)objetRepository.findById(3).get();
        
//         personnage.setOutil(outil);
//         return "jeu";
//     }

//     @ModelAttribute
//     public Personnage personnage() {
//         return new Personnage();
//     }
// }
