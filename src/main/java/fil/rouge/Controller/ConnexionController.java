package fil.rouge.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.PersonnageDto;
import fil.rouge.service.PersonnageService;

@RestController // que ce soit en rest ou non id non reconnu pour la connection. Lundi tester via le controlleur /new_connexion" ?
@SessionAttributes("personnage") // seulement dans la 1ere page qui initialise perso

public class ConnexionController {
	@Autowired
	public PersonnageService pService;

	@Autowired
	public PersonnageRepository pRepo;

	




	@PostMapping("/first_connexion") // via cet url, récupere les infos du joueur -> bouton "c'est parti" page connexion.html
	public String firstConnexion(Model model){
		return "/login"; // Affiche la page partie.html
	}

	@PostMapping("/new_connexion") // Via l'url /connexion -> bouton connexion page inscription.html
	public String continuePartie(Model model, @ModelAttribute PersonnageDto personnage) throws Exception {
		model.addAttribute("personnage", personnage);
		return "/login"; // Accede à la page connexion.html
	}

	/*@GetMapping("/login") // Affiche la page de connexion via cet url
	public String connexion(Model model) throws Exception {
		return "/login"; // page connexion.html
	}*/

	@PostMapping(value= "/login", consumes = "application/json",  produces = "application/json") // via cet url, récupere les infos du joueur -> bouton "c'est parti" page connexion.html
	@ResponseBody
	public PersonnageDto getPartie(@RequestBody  PersonnageDto personnage, Model model) throws Exception {
		
		model.addAttribute("personnage", personnage);
		System.out.println(personnage.getMail());
		System.out.println(personnage.getPassword());
		pService.connexionPartie(personnage.getMail(), personnage.getPassword());
		return personnage; // Affiche la page partie.html
		// https://www.tutorialspoint.com/how-to-write-create-a-json-file-using-java#:~:text=write(jsonObject.,into%20a%20file%20named%20output.
	}	// https://www.baeldung.com/spring-mvc-set-json-content-type

/*
@RequestMapping(
	path = "/connection", 
	method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	produces = {
	MediaType.APPLICATION_ATOM_XML_VALUE, 
	MediaType.APPLICATION_JSON_VALUE
	})
	public  @ResponseBody PersonnageDto  getPartie(@ModelAttribute PersonnageDto personnage, Model model){
		model.addAttribute("personnage", personnage);
		System.out.println(personnage.getMail());
		System.out.println(personnage.getPassword());
		pService.connexionPartie(personnage.getMail(), personnage.getPassword());
		return personnage; // Affiche la page partie.html
	}
	/* */
}