package fil.rouge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fil.rouge.dto.PersonnageDto;


@Controller
public class DeconnexionController {


	@PostMapping("/accueil_connexion")
	public String newGame(Model model, @ModelAttribute PersonnageDto personnage) throws Exception {
		personnage = new PersonnageDto();
		model.addAttribute("personnage", personnage);
		return "/home";
	}

}
