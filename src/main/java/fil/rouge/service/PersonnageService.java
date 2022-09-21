package fil.rouge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.Personnage;




@Service
public class PersonnageService {
    
  @Autowired
  private PersonnageRepository pRepository;


  // Méthode pour créer un compte => choix perso + info connexion

  public Personnage create(String mail, String password, String name, int sexe){

    Personnage personnage = new Personnage();
    return personnage;
  }



  // Méthode pour gérer son compte => modifier mail, mdp, nom perso, sexe, etc

  // Methode pour se connecter => aller chercher la partie en BDD

  // Methode pour supprimer => retirer tout ce qui est lié à l'id personnage


}


//