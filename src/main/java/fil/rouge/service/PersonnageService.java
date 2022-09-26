package fil.rouge.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.Exceptions.OutilException;
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
    List<Personnage> perso = pRepository.findByMail(mail);
    if(perso.get(0).getMail() == mail){
      pRepository.delete(perso.get(0));
      return true;
    }
    else{
      throw new EntityNotFoundException("Compte non trouvé");
    }
  }

  // Connexion à la partie
  public boolean connexionPartie(String mail, String password) throws IllegalAccessException{
    List<Personnage> perso = pRepository.findByMailAndPassword(mail, password);
    if(perso.get(0).getMail() == mail && perso.get(0).getPassword() == password){
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

  public void equiperOutil(int idPersonnage, Outil outilAEquiper) throws OutilException{
    Optional<Personnage> personnage = pRepository.findById(idPersonnage);
    Set<InventaireObjet> inventaireObjet = personnage.get().getInventaireObjet();

    boolean outilPresent = false; 
    for(InventaireObjet invObjet : inventaireObjet){
      if(invObjet.getObjet().getId() == outilAEquiper.getId()){
        outilPresent = true;
      }
    }
    if (!outilPresent)
      throw new OutilException("Vous ne disposez pas de cette outil dans votre inventaire");
      // si il est déjà équipé de l'outil à équiper
      if(personnage.get().getOutil()!= null && personnage.get().getOutil().getId() == outilAEquiper.getId())
        throw new OutilException("Vous êtes déjà equipé de cet outil");
      // si il est équipé d'un outil différent de celui à équiper
      if(personnage.get().getOutil() != null && personnage.get().getOutil().getId() != outilAEquiper.getId()){
        // ajouter l'outil qu'il avait en main dans son inventaire Objet
        serviceInventaireObjet.ajouterObjet(idPersonnage, personnage.get().getOutil().getId(), 1);
        // retirer l'outil dont il souhaite s'équiper de l'inventaire Objet
        serviceInventaireObjet.retirerObjet(outilAEquiper.getId(), 1, idPersonnage);
        // l'équiper de l'outil à équiper
        personnage.get().setOutil(outilAEquiper);
      }
      // // si il est déjà équipé de l'outil à équiper
      // else if(personnage.get().getOutil() != null && personnage.get().getOutil().getId() == outilAEquiper.getId()){
      //   throw new OutilAbsentException("Vous êtes déjà equipé de cet outil");
      // }
      // else{
      //   // retirer l'outil de son inventaire Objet et l'en équiper
      //   try{
      //   serviceInventaireObjet.retirerObjet(idPersonnage, personnage.get().getOutil().getId(), 1);
      //     personnage.get().setOutil(outilAEquiper);
      //   }catch(IllegalArgumentException ex){
      //     ex.printStackTrace();
      //   }
      // }
  }

  public void rangerOutil(int idPersonnage, Outil outilEnMain) throws OutilException{
    Optional<Personnage> personnage = pRepository.findById(idPersonnage);
    boolean aUnOutilEnMain = false;
      if(personnage.get().getOutil()!= null){
        aUnOutilEnMain = true;
      }
      if (!aUnOutilEnMain)
      // si il n'a aucun outil en main
      throw new OutilException("Vous n'avez pas d'outil en main");
      if (aUnOutilEnMain == true){
        // nous ajoutons l'outil dont il est équipé dans son inventaire Objet puis nous le retirons de sa main
        serviceInventaireObjet.ajouterObjet(idPersonnage, outilEnMain.getId(), 1);
        personnage.get().setOutil(null);
      }
  }
}

