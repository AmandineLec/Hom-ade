package fil.rouge.controller;

import java.util.List;
import java.util.Optional;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fil.rouge.dao.DecorationRepository;
import fil.rouge.dao.MeubleRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.OutilRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.ReceiptsException;
import fil.rouge.model.Decoration;
import fil.rouge.model.Meuble;
import fil.rouge.model.Objet;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;
import fil.rouge.service.RecetteService;

@RestController
public class CreationController {
       //Faire un controller qui nous retourne les différentes recettes triées par type
       //Le return est une modal (?)
    @Autowired
    OutilRepository outilRepository; 

    @Autowired
    PersonnageRepository pRepository; 

    @Autowired
    MeubleRepository meubleRepository;

    @Autowired
    DecorationRepository decorationRepository; 


    @Autowired
    ObjetRepository objetRepository;


    @Autowired
    RecetteService recetteService;


    @GetMapping("/api/recette") 
    public Optional<Objet> Recette(@RequestParam Integer id) throws JsonProcessingException {
    return objetRepository.findById(id);
    }

    @GetMapping("/api/recettes") 
    public List<Objet> Recettes() throws JsonProcessingException {
    return objetRepository.findAll();
    }

    @GetMapping("/api/recetteOutils") 
    public List<Outil> RecetteOutils() throws JsonProcessingException {
    return outilRepository.findAll();  
    }

    @GetMapping("/api/recetteMeubles") 
    public     List<Meuble> RecetteMeubles() throws JsonProcessingException {
    return meubleRepository.findAll(); 
    }
    
    @GetMapping("/api/recetteDecos") 
    public String RecetteDecos() throws JsonProcessingException {
    List<Decoration> decos = decorationRepository.findAll(); 
    String serialized = new ObjectMapper().writeValueAsString(decos);
    return serialized; 
    }

    @GetMapping("/api/creation")
    public Boolean AddInventaire(Principal principal, @RequestParam Integer id) throws ReceiptsException{
        Personnage personnage = pRepository.findByMail(principal.getName()).get();
        recetteService.fusionnerRessource(id, personnage);
        return true;
    }
}



