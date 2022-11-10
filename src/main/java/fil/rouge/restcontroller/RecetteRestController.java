package fil.rouge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fil.rouge.dao.DecorationRepository;
import fil.rouge.dao.MeubleRepository;
import fil.rouge.dao.OutilRepository;
import fil.rouge.model.Decoration;
import fil.rouge.model.Meuble;
import fil.rouge.model.Outil;

@RestController
public class RecetteRestController {

    @Autowired
    OutilRepository outilRepository; 

    @Autowired
    MeubleRepository meubleRepository; 

    @Autowired
    DecorationRepository decorationRepository; 

    @GetMapping("/api/recetteOutils") 
    public List<Outil> RecetteOutils() throws JsonProcessingException {
    return outilRepository.findAll(); 
    }

    @GetMapping("/api/recetteMeubles") 
    public String RecetteMeubles() throws JsonProcessingException {
    List<Meuble> meubles = meubleRepository.findAll(); 
    // Iterable<Recette>  recettes = recetteRepository.findAll();
    String serialized = new ObjectMapper().writeValueAsString(meubles);
    return serialized; 
    }
    
    @GetMapping("/api/recetteDecos") 
    public String RecetteDecos() throws JsonProcessingException {
    List<Decoration> decos = decorationRepository.findAll(); 
    // Iterable<Recette>  recettes = recetteRepository.findAll();
    String serialized = new ObjectMapper().writeValueAsString(decos);
    return serialized; 
    }
}
