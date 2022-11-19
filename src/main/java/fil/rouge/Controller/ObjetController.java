package fil.rouge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.OutilException;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetService;

@Controller
public class ObjetController {

    @Autowired
    ObjetService objetService;

    @Autowired
    PersonnageRepository pRepository; 

    @PostMapping("/Equiper")
    public String EquiperOutil(@RequestParam Integer id, Principal principal) throws OutilException{
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        objetService.equiperOutil(personnage, id);
        return ("/Equiper");
    }

    @GetMapping("/api/equiper")
    public Boolean EquiperOutils(@RequestParam Integer id, Principal principal) throws OutilException{
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        objetService.equiperOutil(personnage, id);
        return true; 
    }
}
