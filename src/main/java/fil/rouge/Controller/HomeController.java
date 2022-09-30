package fil.rouge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    

	@GetMapping("/home") // Accede via l'url /inscription...
	public String inscription(Model model){
		return "/home"; // ...A la page inscription.html
	}

}
