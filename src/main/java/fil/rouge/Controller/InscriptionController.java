package fil.rouge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import fil.rouge.dto.PersonnageDto;
import fil.rouge.service.PersonnageService;




@RestController  
public class InscriptionController {

	@Autowired
	public PersonnageService pService;

	@GetMapping("/inscription") // Accede via l'url /inscription...
	public String inscription(Model model) throws Exception {
		PersonnageDto personnage = new PersonnageDto();
		model.addAttribute("personnage", personnage);
		return "inscription"; // ...A la page inscription.html
	}

	@PostMapping(
		value ="/inscription", consumes = "application/json",  produces = "application/json") // Accede via l'url /partie et via les infos entrées dans le formulaire...
	@ResponseBody // The @ResponseBody annotation tells a controller that the object returned is automatically 
	//serialized into JSON and passed back into the HttpResponse object.
	public PersonnageDto startGame(@RequestBody PersonnageDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		System.out.println(personnage.getSexe());
		pService.inscription(personnage.getMail(), personnage.getPassword(), personnage.getName(), personnage.getSexe()); // Sauvegarde le perso en BDD
		return personnage; // ...renvoie vers la connexion
	}

	@PostMapping("/new_inscription") // Via l'url /connexion
	public String newInscription(Model model) throws Exception {
		PersonnageDto personnage = new PersonnageDto();
		model.addAttribute("personnage", personnage);
		return "inscription"; // Accede à la page connexion.html
	}

	@PostMapping("/first_inscription") // Via l'url /connexion
	public String firstInscription(Model model) throws Exception {
		return "inscription"; // Accede à la page connexion.html
	}

    @ModelAttribute
    public PersonnageDto personnage() {
        return new PersonnageDto();
    }

}
