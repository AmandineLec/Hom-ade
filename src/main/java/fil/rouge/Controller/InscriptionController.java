package fil.rouge.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.model.Personnage;

@Controller
@SessionAttributes("personnage") // seulement dans la 1ere page qui initialise perso
public class InscriptionController {
	@PostMapping("/inscription")
	public String getTemplate(@ModelAttribute Personnage personnage, Model model) {

		model.addAttribute("personnage", personnage);
		return "partie";
	}
	
	@GetMapping("/inscription")
	public String showForm(Model model) {
		Personnage personnage = new Personnage();
		model.addAttribute("personnage", personnage);
		return "inscription";
	}

    @ModelAttribute
    public Personnage personnage() {
        return new Personnage();
    }

}
