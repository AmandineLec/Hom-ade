package fil.rouge.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.MaisonRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.exception.MailAlreadyUsedException;
import fil.rouge.model.Maison;
import fil.rouge.model.Personnage;



@Service
public class PersonnageService {
    
  @Autowired
  private PersonnageRepository pRepository;

  @Autowired
  private MaisonRepository mrepository;

  // Inscription au jeu
  public boolean inscription(String mail, String password, String name, int sexe) throws MailAlreadyUsedException {
    List<Personnage> persos = pRepository.findAll();
    for(Personnage perso : persos){
      if(perso.getMail().equals(mail)){
        throw new MailAlreadyUsedException("Ce mail est déjà utilisé");
      }
    }
    Personnage personnage = new Personnage(name, sexe, mail, password);
    Maison maison = new Maison();
    mrepository.save(maison);
    personnage.setMaison(maison);
    pRepository.save(personnage);
    return true;
  }

  // Suppression du compte
  public boolean suppressionPartie(String mail) throws EntityNotFoundException{
    Optional<Personnage> personnage = pRepository.findByMail(mail);
    List<Personnage> persos = pRepository.findAll();
    for(Personnage perso : persos){
      if(perso.getMail() == personnage.get().getMail() && perso.getPassword() == personnage.get().getPassword()){
        pRepository.delete(personnage.get());
        return true;
        }
    }
    throw new EntityNotFoundException("Compte non trouvé");
  }

  // Connexion à la partie
  public Personnage connexionPartie(String mail, String password) throws NoSuchElementException{
    Optional<Personnage> personnage = pRepository.findByMailAndPassword(mail, password);
    List<Personnage> persos = pRepository.findAll();
    for(Personnage perso : persos){
      if(perso.getMail() == personnage.get().getMail() && perso.getPassword() == personnage.get().getPassword()){
        return personnage.get();
      }
    }
    throw new NoSuchElementException("Identifiants incorrects");

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