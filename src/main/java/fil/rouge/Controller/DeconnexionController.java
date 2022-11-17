package fil.rouge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fil.rouge.dto.PersonnageDto;


@Controller
public class DeconnexionController {


	@PostMapping(value= "/accueil_connexion", consumes = "application/json",  produces = "application/json")
	@ResponseBody
	public String newGame(Model model, @RequestBody PersonnageDto personnage) throws Exception {
		personnage = new PersonnageDto();
		model.addAttribute("personnage", personnage);
		return "/home";
	}

}
