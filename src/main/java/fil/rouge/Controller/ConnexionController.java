package fil.rouge.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;


import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.PersonnageDto;
import fil.rouge.service.PersonnageService;

@Controller


public class ConnexionController {
	@Autowired
	public PersonnageService pService;

	@Autowired
	public PersonnageRepository pRepo;


	@PostMapping(value= "/connection", consumes = "application/json",  produces = "application/json") // via cet url, récupere les infos du joueur -> bouton "c'est parti" page connexion.html
	@ResponseBody
	public PersonnageDto getPartie(@RequestBody  PersonnageDto personnage, Model model) throws Exception {
		
		model.addAttribute("personnage", personnage);
		pService.connexionPartie(personnage.getMail(), personnage.getPassword());
		return personnage; // Affiche la page partie.html
	}	
}