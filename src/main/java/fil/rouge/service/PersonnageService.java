package fil.rouge.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Outil;
import fil.rouge.model.Personnage;



@Service
public class PersonnageService {
    
  @Autowired
  private PersonnageRepository pRepository;

  @Autowired
  private InventaireObjetService serviceInventaireObjet;


  // Inscription au jeu
  public boolean inscription(String mail, String password, String name, int sexe) throws Exception {
    List<Personnage> persos = pRepository.findAll();
    for(Personnage perso : persos){
      if(perso.getMail() == mail){
        throw new Exception("Ce mail est déjà utilisé");
      }
    }
    Personnage personnage = new Personnage(name, sexe, mail, password);
    pRepository.save(personnage);
    return true;
  }

  // Suppression du compte
  public boolean suppressionPartie(String mail) throws EntityNotFoundException{
    Optional<Personnage> perso = pRepository.findByMail(mail);
    if(perso.get().getMail() == mail){
      pRepository.delete(perso.get());
      return true;
    }
    else{
      throw new EntityNotFoundException("Compte non trouvé");
    }
  }

  // Connexion à la partie
  public boolean connexionPartie(String mail, String password) throws IllegalAccessException{
    Optional<Personnage> perso = pRepository.findByMailAndPassword(mail, password);
    if(perso.get().getMail() == mail && perso.get().getPassword() == password){
      return true;
    }
    else{
      throw new IllegalAccessException("Identifiants incorrects");
    }
  }

  // Modifier les infos du compte

  //Mail
  public boolean modificationMail(Personnage personnage, String mail) throws Exception{
    Optional<Personnage> perso = pRepository.findById(personnage.getIdPersonnage());
    if(perso.get() != null){
      perso.get().setMail(mail);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

  //Password
  public boolean modificationPassword(Personnage personnage, String password) throws Exception{
    Optional<Personnage> perso = pRepository.findById(personnage.getIdPersonnage());
    if(perso.get() != null){
      perso.get().setMail(password);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

  // Modifier les infos du perso

  //Nom
  public boolean modificationNomPerso(Personnage personnage, String name) throws Exception{
    Optional<Personnage> perso = pRepository.findById(personnage.getIdPersonnage());
    if(perso.get() != null){
      perso.get().setName(name);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

  //Sexe
  public boolean modificationSexePerso(Personnage personnage, int sexe) throws Exception{
    Optional<Personnage> perso = pRepository.findById(personnage.getIdPersonnage());
    if(perso.get() != null){
      perso.get().setSexe(sexe);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

  public void equiperOutil(int idPersonnage, Outil outilAEquiper) throws Exception{
    Optional<Personnage> personnage = pRepository.findById(idPersonnage);
    Set<InventaireObjet> inventaireObjet = personnage.get().getInventaireObjets();
    boolean outilPresent = false; 
    for(InventaireObjet invObjet : inventaireObjet){
      if(invObjet.getObjet().getId() == outilAEquiper.getId()){
        outilPresent = true;
      }
      else{
        outilPresent = false;
      }
    }

    if(outilPresent == true){
      if(personnage.get().getOutil() != null && personnage.get().getOutil().getId() != outilAEquiper.getId() ){
        // retirer l'outil de l'inventaire des ressources
        serviceInventaireObjet.retirerObjet(outilAEquiper.getId(), 1, idPersonnage);
        // ajouter l'outil qu'il avait en main
        serviceInventaireObjet.ajouterObjet(idPersonnage, personnage.get().getOutil().getId(), 1);
        personnage.get().setOutil(outilAEquiper);
        
      }
      else if(personnage.get().getOutil() != null && personnage.get().getOutil().getId() == outilAEquiper.getId()){
        throw new Exception("Vous êtes déjà equipé de cet outil");
      }
      else{
        serviceInventaireObjet.retirerObjet(idPersonnage, personnage.get().getOutil().getId(), 1);
        personnage.get().setOutil(outilAEquiper);
      }
    }
    else {
      throw new Exception("Vous ne disposez pas de cette outil dans votre inventaire");
    }
  }



}


//