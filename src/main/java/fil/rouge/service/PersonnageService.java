package fil.rouge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fil.rouge.dao.MaisonRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.dao.RoleRepository;
import fil.rouge.exception.MailAlreadyUsedException;
import fil.rouge.exception.NeedAMailToRegisterException;
import fil.rouge.exception.NeedAPasswordToRegisterException;
import fil.rouge.model.Maison;
import fil.rouge.model.Personnage;
import fil.rouge.model.Roles;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;



@Service
public class PersonnageService {
    
  @Autowired
  private PersonnageRepository pRepository;

  @Autowired
  private MaisonRepository mrepository;

  @Autowired
  private RoleRepository rRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
	public DaoAuthenticationProvider manager;


  // Inscription au jeu
  public boolean inscription(String mail, String password, String name, int sexe) throws Exception {
    List<Personnage> persos = pRepository.findAll();
    for(Personnage perso : persos){
      if(perso.getMail().equals(mail)){
        throw new MailAlreadyUsedException("Ce mail est déjà utilisé");
      }
    }

    if(mail == null || mail.isEmpty()){
      throw new NeedAMailToRegisterException("Vous devez entrer un mail valide pour vous inscrire");
    }

    if(password == null || password.isEmpty()){
      throw new NeedAPasswordToRegisterException("Vous devez entrer un mot de passe valide pour vous inscrire");
    }

    Roles role = rRepository.findByName("user").get();
    List<Roles> roles = new ArrayList<Roles>();
    roles.add(role);
    //System.out.println(password);
    password = passwordEncoder.encode(password);
    //System.out.println(password);
    Personnage personnage = new Personnage(name, sexe, mail, password, true);
    personnage.setRoles(roles);
    Maison maison = new Maison();
    mrepository.save(maison);
    personnage.setMaison(maison);
    pRepository.save(personnage);
    return true;
  }

  // Suppression du compte
  public boolean suppressionPartie(String mail, String password) throws NoSuchElementException{
    Optional<Personnage> personnage = pRepository.findByMailAndPassword(mail, password);
    if(!personnage.isEmpty()){
      pRepository.delete(personnage.get());
      return true;
      }

    throw new NoSuchElementException("Compte non trouvé");
  }

  // Connexion à la partie
  public Personnage connexionPartie(String mail, String password) throws NoSuchElementException{
    //String passwordhash = passwordEncoder.encode(password);
    //System.out.println(passwordhash);
    //System.out.println(password);
    manager.authenticate(new UsernamePasswordAuthenticationToken(mail, password));
    Optional<Personnage> personnage = pRepository.findByMail(mail);
    if(!personnage.isEmpty()){
      //System.out.println(personnage.get().getName());
      return personnage.get();
    }
    throw new NoSuchElementException("Identifiants incorrects");
  }

  // Modifier les infos du compte

  //Mail
  public boolean modificationMail(Personnage personnage, String mail, String password, String newMail) throws NoSuchElementException{
    Optional<Personnage> perso = pRepository.findByMailAndPassword(mail, password);
    if(!perso.isEmpty()){
      perso.get().setMail(newMail);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new NoSuchElementException("Personnage inexistant");
    }
  }

  //Password
  public boolean modificationPassword(Personnage personnage, String password, String mail, String newPassword) throws Exception{
    Optional<Personnage> perso = pRepository.findByMailAndPassword(mail, password);
    if(!perso.isEmpty()){
      perso.get().setPassword(newPassword);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

  // Modifier les infos du perso

  //Nom
  public boolean modificationNomPerso(Personnage personnage, String name, String password, String mail, String newName) throws Exception{
    Optional<Personnage> perso = pRepository.findByMailAndPassword(mail, password);
    if(!perso.isEmpty()){
      perso.get().setName(newName);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

  //Sexe
  public boolean modificationSexePerso(Personnage personnage, int sexe, String password, String mail, int newSex) throws Exception{
    Optional<Personnage> perso = pRepository.findByMailAndPassword(mail, password);
    if(!perso.isEmpty()){
      perso.get().setSexe(newSex);
      pRepository.save(perso.get());
      return true;
    }
    else{
      throw new Exception("Personnage inexistant");
    }
  }

    public Personnage getPersonnage(int PersonnageId) throws EntityNotFoundException {
      return ServiceUtils.getEntity(pRepository, PersonnageId);
  }
}

