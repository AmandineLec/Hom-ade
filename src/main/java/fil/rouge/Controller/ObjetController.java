package fil.rouge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.exception.OutilException;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetService;

@Controller
@SessionAttributes("personnage")
public class ObjetController {

    @Autowired
    ObjetService objetService;


    @PostMapping("/Equiper")
    public String EquiperOutil(@RequestParam Integer id, @ModelAttribute Personnage personnage) throws OutilException{
        objetService.equiperOutil(personnage, id);
        return ("/Equiper");
    }
}
