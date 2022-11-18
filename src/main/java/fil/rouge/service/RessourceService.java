package fil.rouge.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.dao.RessourcesRecolteesRepository;
import fil.rouge.dto.RessourceDTO;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;
import fil.rouge.model.RessourcesRecoltees;

@Service
public class RessourceService {

  @Autowired
  PersonnageRepository personnageRepository;

  @Autowired
  RessourceRepository ressourceRepository;

  @Autowired
  RessourcesRecolteesRepository ressourcesRecolteesRepository;

  @Autowired
  InventaireRessourceRepository inventaireRessourceRepository;

  @Autowired
    PersonnageRepository pRepository;  

  public Ressource getRessource(int ressourceId) throws EntityNotFoundException {
    return ServiceUtils.getEntity(ressourceRepository, ressourceId);
  }

  // Ajoute les ressources ramassées dans l'inventaire
  public boolean ajoutRessourceInventaire(String mail, int ressourceId, int quantite) {
    Personnage personnage = pRepository.findByMail(mail).get();
    Ressource ressource = ressourceRepository.findById(ressourceId).get();

    Iterator<InventaireRessource> it = personnage.getInventaireRessource().iterator();
    while (it.hasNext()) {
      InventaireRessource invRes = it.next();
      if (invRes.getRessource().getId() == ressourceId) {
        invRes.setQuantite(invRes.getQuantite() + quantite);        // Si la ressource est dans l'inventaire, modifie la quantité
        inventaireRessourceRepository.save(invRes);
        return true;
      }
    }
    InventaireRessource invRes = new InventaireRessource(personnage, ressource, quantite);
    inventaireRessourceRepository.save(invRes);
    return personnage.addInventaireRessource(invRes);               // Si la ressource n'est pas dans l'inventaire, l'ajoute dans l'inventaire
    
  }

  // Retourne la liste des ressources ramassées
  public List<RessourcesRecoltees> listeRessourcesRamassees(int objetRecoltableId) {
   
    List<RessourcesRecoltees> listeResRec = ressourcesRecolteesRepository.findById_IdElementRecoltable(objetRecoltableId);
    
    return listeResRec;
  }

  //Récupère tous les DTO des ressources
  public List<RessourceDTO> getAlRessources() {
    return ((List<Ressource>) ressourceRepository
            .findAll())
            .stream()
            .map(this::convertDataIntoDTO)
              .collect(Collectors.toList());
  }

  // Convertit les ressources en DTO
  private RessourceDTO convertDataIntoDTO(Ressource ressource) {
    RessourceDTO dto = new RessourceDTO();

    dto.setIdRessource(ressource.getId());
    dto.setNom(ressource.getNom());

    return dto;
  }
}

