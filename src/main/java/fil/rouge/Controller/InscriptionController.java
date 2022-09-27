package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dto.InscriptionDto;
import fil.rouge.model.Personnage;
import fil.rouge.service.PersonnageService;




@Controller
@SessionAttributes("personnage") // seulement dans la 1ere page qui initialise perso
public class InscriptionController {

	@Autowired
	public PersonnageService pService;

	@GetMapping("/inscription") // Accede via l'url /inscription...
	public String inscription(Model model) throws Exception {
		InscriptionDto personnage = new InscriptionDto();
		model.addAttribute("personnage", personnage);
		return "inscription"; // ...A la page inscription.html
	}

	@PostMapping("/partie") // Accede via l'url /partie et via les infos entrées dans le formulaire...
	public String startGame(@ModelAttribute InscriptionDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		pService.inscription(personnage.getMail(), personnage.getPassword(), personnage.getName(), personnage.getSexe());
		return "partie"; // ...A la page partie.html
	}

	@PostMapping("/new_inscription") // Via l'url /connexion
	public String continuePartie(Model model) throws Exception {
		InscriptionDto personnage = new InscriptionDto();
		model.addAttribute("personnage", personnage);
		return "inscription"; // Accede à la page connexion.html
	}

    @ModelAttribute
    public Personnage personnage() {
        return new Personnage();
    }

}
