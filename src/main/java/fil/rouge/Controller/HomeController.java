package fil.rouge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
    

	@GetMapping("/home") // Accede via l'url /inscription...
	public String inscription(Model model){
		return "/home"; // ...A la page inscription.html
	}

	@PostMapping("/go_home")
	public String home(Model model) throws Exception {
		return "/home";
	}
	
	@PostMapping("/go_home2")
	public String home2(Model model) throws Exception {
		return "/home";
	}	
	
	@PostMapping("/go_home3")
	public String home3(Model model) throws Exception {
		return "/home";
	}	
	
	@PostMapping("/go_home4")
	public String home4(Model model) throws Exception {
		return "/home";
	}	
	
	@PostMapping("/go_home5")
	public String home5(Model model) throws Exception {
		return "/home";
	}

	@PostMapping("/go_home6")
	public String home6(Model model) throws Exception {
		return "/home";
	}
}
