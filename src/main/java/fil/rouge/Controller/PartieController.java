package fil.rouge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.PersonnageDto;
import fil.rouge.model.Personnage;
import fil.rouge.service.PersonnageService;

@Controller
@SessionAttributes("personnage") // seulement dans la 1ere page qui initialise perso
public class PartieController {

    @Autowired
	public PersonnageService pService;

  @Autowired
	public PersonnageRepository pRepository;

    @PostMapping("/gestion_compte") // Accede via l'url /partie et via les infos entrées dans le formulaire...
	public String gererCompte(@ModelAttribute PersonnageDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		return "/compte"; // ...A la page partie.html
    }

    @PostMapping("/retour_compte")
    public String retourCompte(Principal principal, Model model){
      Personnage personnage = pRepository.findByMail(principal.getName()).get();
      model.addAttribute("personnage", personnage);
		return "/partie"; // ...A la page partie.html
    }

    @GetMapping("/")
    public String debutPartie(Principal principal, Model model){
      Personnage personnage = pRepository.findByMail(principal.getName()).get();
      model.addAttribute("personnage", personnage);

      return "/partie";
    }

    @PostMapping("/play_game") // Accede via l'url /partie et via les infos entrées dans le formulaire...
    public String jouer(@ModelAttribute PersonnageDto personnage, Model model) throws Exception {
      model.addAttribute("personnage", personnage);
      return "/jeu"; // ...A la page partie.html
      }
    

}
