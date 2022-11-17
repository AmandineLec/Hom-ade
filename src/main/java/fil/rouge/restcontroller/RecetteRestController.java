package fil.rouge.restcontroller;

import java.util.List;
import java.util.Optional;

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
import fil.rouge.model.Decoration;
import fil.rouge.model.Meuble;
import fil.rouge.model.Objet;
import fil.rouge.model.Outil;

@RestController
public class RecetteRestController {

    @Autowired
    OutilRepository outilRepository; 

    @Autowired
    ObjetRepository objetRepository; 

    @Autowired
    MeubleRepository meubleRepository; 

    @Autowired
    DecorationRepository decorationRepository; 

    @GetMapping("/api/recettes") 
    public Optional<Objet> Recettes(@RequestParam Integer id) throws JsonProcessingException {
    return objetRepository.findById(id);
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
}
