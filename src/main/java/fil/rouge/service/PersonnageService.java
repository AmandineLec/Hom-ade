package fil.rouge.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.Personnage;



@Service
public class PersonnageService {
    
  @Autowired
  private PersonnageRepository pRepository;

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

}


//