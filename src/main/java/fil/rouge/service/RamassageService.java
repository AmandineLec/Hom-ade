package fil.rouge.service;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.InventaireRessourceRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dao.RessourceRepository;
import fil.rouge.dao.RessourcesRecolteesRepository;
import fil.rouge.model.InventaireRessource;
import fil.rouge.model.Personnage;
import fil.rouge.model.Ressource;
import fil.rouge.model.RessourcesRecoltees;

@Service
public class RamassageService {

  @Autowired
  PersonnageRepository personnageRepository;

  @Autowired
  RessourceRepository ressourceRepository;

  @Autowired
  RessourcesRecolteesRepository ressourcesRecolteesRepository;

  @Autowired
  InventaireRessourceRepository inventaireRessourceRepository;

  public boolean ajoutRessourceInventaire(Personnage personnage, int ressourceId, int quantite) {
    
    Ressource ressource = ressourceRepository.findById(ressourceId).get();

    Iterator<InventaireRessource> it = personnage.getInventaireRessource().iterator();
    while (it.hasNext()) {
      InventaireRessource invRes = it.next();
      if (invRes.getRessource().getId() == ressourceId) {
        invRes.setQuantite(invRes.getQuantite() + quantite);
        return true;
      }
    }
    InventaireRessource invRes = new InventaireRessource(personnage, ressource, quantite);
    return personnage.addInventaireRessource(invRes);
      

  }

  public List<RessourcesRecoltees> listeRessourcesRamassees(int objetRecoltableId) {
   
    List<RessourcesRecoltees> listeResRec = ressourcesRecolteesRepository.findById_IdElementRecoltable(objetRecoltableId);
    
    return listeResRec;
  }
}
