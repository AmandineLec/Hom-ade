package fil.rouge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dto.PersonnageDto;
import fil.rouge.model.Personnage;
import fil.rouge.service.ObjetRecoltableService;
import fil.rouge.service.PersonnageService;

@RestController
public class PartieController {

    @Autowired
	public PersonnageService pService;

  @Autowired
	public PersonnageRepository pRepository;

  @Autowired
  public ObjetRecoltableService objetRecoltableService;

    @PostMapping("/gestion_compte") // Accede via l'url /partie et via les infos entrées dans le formulaire...
	public String gererCompte(@ModelAttribute PersonnageDto personnage, Model model) throws Exception {
		model.addAttribute("personnage", personnage);
		return "/compte"; // ...A la page partie.html
    }

    @PostMapping("/retour_compte")
    public String retourCompte(@ModelAttribute Principal principal, Model model){
      System.out.println(principal.getName());
      Personnage personnage = pRepository.findByMail(principal.getName()).get();
      model.addAttribute("personnage", personnage);
		return "/partie"; // ...A la page partie.html
    }

    @PostMapping("/retour_compte2")
    public String retourCompte2(Principal principal, Model model){
      Personnage personnage = pRepository.findByMail(principal.getName()).get();
      model.addAttribute("personnage", personnage);
		return "/partie"; // ...A la page partie.html
    }

    @GetMapping("/")
    public Personnage debutPartie(Principal principal){
      // System.out.println(principal.getName());
      // Personnage personnage =
      // model.addAttribute("personnage", personnage);

      return pRepository.findByMail(principal.getName()).get();
    }

    @PostMapping("/play_game") // Accede via l'url /partie et via les infos entrées dans le formulaire...
    public String jouer(Principal principal, Model model) throws Exception {
      Personnage personnage = pRepository.findByMail(principal.getName()).get();
      model.addAttribute("personnage", personnage);
      return "/jeu"; // ...A la page jeu.html
      }
}
