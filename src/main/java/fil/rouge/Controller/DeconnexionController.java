package fil.rouge.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fil.rouge.dto.InscriptionDto;


@Controller
public class DeconnexionController {


	@PostMapping("/accueil_inscription")
	public String newGame(Model model, @ModelAttribute InscriptionDto personnage) throws Exception {
		model.addAttribute("personnage", personnage);
		return "inscription";
	}

}
