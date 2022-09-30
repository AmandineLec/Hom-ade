package fil.rouge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fil.rouge.dto.InscriptionDto;


@Controller
public class DeconnexionController {


	@PostMapping("/accueil_connexion")
	public String newGame(Model model, @ModelAttribute InscriptionDto personnage) throws Exception {
		personnage = new InscriptionDto();
		model.addAttribute("personnage", personnage);
		return "connexion";
	}

}
