package fil.rouge.controller;

import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fil.rouge.dto.InscriptionDto;
import fil.rouge.service.PersonnageService;

@Controller
public class ConnexionController {
	@Autowired
	public PersonnageService pService;

	@PostMapping("/new_connexion") // Via l'url /connexion -> bouton connexion page inscription.html
	public String continuePartie(Model model, @ModelAttribute InscriptionDto personnage) throws Exception {
		model.addAttribute("personnage", personnage);
		return "connexion"; // Accede à la page connexion.html
	}

	@GetMapping("/connexion") // Affiche la page de connexion via cet url
	public String connexion(Model model, @SessionAttribute InscriptionDto personnage) throws Exception {
		personnage = new InscriptionDto();
		model.addAttribute("personnage", personnage);
		return "connexion"; // page connexion.html
	}

	@PostMapping("/se_connecter") // via cet url, récupere les infos du joueur -> bouton "c'est parti" page connexion.html
	public String getPartie(@ModelAttribute InscriptionDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		pService.connexionPartie(personnage.getMail(), personnage.getPassword());
		return "partie"; // Affiche la page partie.html
	}
	

}