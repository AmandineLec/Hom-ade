package fil.rouge.controller;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.exception.OutilException;
import fil.rouge.model.Outil;
import fil.rouge.service.ObjetService;

@Controller
@SessionAttributes("personnage")
public class ObjetController {

    @Autowired
    ObjetService objetService;

    @PostMapping("")
    public String EquiperOutil(@RequestParam Integer id, Outil outil) throws OutilException{
        objetService.equiperOutil(id, outil);
        return ("/Equiper");
    }
}
