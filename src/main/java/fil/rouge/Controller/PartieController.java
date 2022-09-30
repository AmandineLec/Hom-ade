package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dto.InscriptionDto;
import fil.rouge.service.PersonnageService;

@Controller
@SessionAttributes("personnage") // seulement dans la 1ere page qui initialise perso
public class PartieController {

    @Autowired
	public PersonnageService pService;

    @PostMapping("/gestion_compte") // Accede via l'url /partie et via les infos entrées dans le formulaire...
	public String gererCompte(@ModelAttribute InscriptionDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		return "compte"; // ...A la page partie.html
    }

    @PostMapping("/retour_compte")
    public String retourCompte(@ModelAttribute InscriptionDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		return "partie"; // ...A la page partie.html
    }
}
