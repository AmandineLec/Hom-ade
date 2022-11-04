package fil.rouge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import fil.rouge.dao.DecorationRepository;
import fil.rouge.dao.MeubleRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.OutilRepository;
import fil.rouge.exception.ReceiptsException;
import fil.rouge.model.Decoration;
import fil.rouge.model.Meuble;
import fil.rouge.model.Objet;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;
import fil.rouge.service.RecetteService;

@Controller
@SessionAttributes("personnage")
public class CreationController {
       //Faire un controller qui nous retourne les différentes recettes triées par type
       //Le return est une modal (?)
    @Autowired
    OutilRepository outilRepository; 

    @GetMapping("/recetteOutils")
    public String RecetteOutils(Personnage personnage, Model model){
        List<Outil> outils = outilRepository.findAll();
        model.addAttribute("outils", outils);
        return "/jeu ::recetteOutils";
    }

    // @GetMapping("recetteOuils")
    // public List<Outil> RcetteOutilsJson(){
    //     List<Outil> outils = outilRepository.findAll();
    //     return outils; 
    // }
    @Autowired
    MeubleRepository meubleRepository;

    @GetMapping("/recetteMeubles")
    public String RecetteMeuble(Personnage personnage, Model model){
        List<Meuble> meubles = meubleRepository.findAll();
        model.addAttribute("meubles", meubles);
        return "/jeu ::recetteMeubles";
    }

    @Autowired
    DecorationRepository decorationRepository; 

    @GetMapping("/recetteDecos")
    public String RecetteDeco(Personnage personnage, Model model){
        List<Decoration> decorations = decorationRepository.findAll(); 
        model.addAttribute("decorations", decorations);
        return "/jeu ::recetteDecos";
    }

    @Autowired
    ObjetRepository objetRepository;

    @GetMapping("/singleRecette")
    public String SingleRecette(@RequestParam Integer id, Model model){
        Objet objet = objetRepository.findById(id).get();
        model.addAttribute("objet", objet);
        return "/singleRecette";
    }

    @Autowired
    RecetteService recetteService;

    @PostMapping("/AddInventaire")
    public String AddInventaire(@RequestParam Integer id, @ModelAttribute Personnage personnage) throws ReceiptsException{
        recetteService.fusionnerRessource(id, personnage);
        return ("/AddInventaire");
    }

    @GetMapping("/AddInventaire")
    public String AddInventaireSucces(){
        return ("/AddInventaire");
    }
}



