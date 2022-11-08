package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fil.rouge.dto.PersonnageDto;
import fil.rouge.model.Personnage;
import fil.rouge.service.PersonnageService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ConnexionController {
	@Autowired
	public PersonnageService pService;

	@PostMapping("/new_connexion") // Via l'url /connexion -> bouton connexion page inscription.html
	public String continuePartie(Model model, @ModelAttribute PersonnageDto personnage) throws Exception {
		model.addAttribute("personnage", personnage);
		return "/login"; // Accede à la page connexion.html
	}

	@GetMapping("/login") // Affiche la page de connexion via cet url
	public String connexion(Model model) throws Exception {
		return "/login"; // page connexion.html
	}

	@PostMapping("/se_connecter") // via cet url, récupere les infos du joueur -> bouton "c'est parti" page connexion.html
	public String getPartie(@ModelAttribute Personnage personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		pService.connexionPartie(personnage.getMail(), personnage.getPassword());
		return "/partie"; // Affiche la page partie.html
	}

	@PostMapping("/first_connexion") // via cet url, récupere les infos du joueur -> bouton "c'est parti" page connexion.html
	public String firstConnexion(Model model){
		return "/login"; // Affiche la page partie.html
	}
}