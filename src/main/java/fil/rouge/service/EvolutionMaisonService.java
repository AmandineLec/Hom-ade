package fil.rouge.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import fil.rouge.Exceptions.ObjetMaisonException;
import fil.rouge.dao.InventaireMaisonRepository;
import fil.rouge.dao.ObjetRepository;
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.EquipementMaison;
import fil.rouge.model.InventaireObjet;
import fil.rouge.model.Maison;
import fil.rouge.model.Objet;
import fil.rouge.model.Personnage;

public class EvolutionMaisonService {
    @Autowired
    PersonnageRepository personnageRepository;

    @Autowired
    InventaireMaisonRepository inventaireMaisonRepository;

    @Autowired
    InventaireObjetService serviceInventaireObjet;

    @Autowired
    ObjetRepository objetRepository;


    public void placerObjet(Integer idPersonnage, Integer idObjet, int typeObjet, int quantiteObjet) throws ObjetMaisonException{
        Optional<Personnage> personnage = personnageRepository.findById(idPersonnage); // j'accède au personnage
        Optional<Objet> objet = objetRepository.findById(idObjet); // j'accède à l'objet 
        Maison maisonDuPersonnage = personnage.get().getMaison(); // j'accède à sa maison
        List<EquipementMaison> inventaireDeLaMaison = objetsMaisonDuPersonnage(maisonDuPersonnage); // j'accède à ce qui est placé dans la maison
        Set<InventaireObjet> inventairePersonnage = personnage.get().getInventaireObjet(); // j'accède à l'inventaire des objets du personnage
        boolean disposeDeLObjet = false;
        for(InventaireObjet inventaireObjet:inventairePersonnage){ // je parcours l'inventaire des objets du personnage 
            if(inventaireObjet.getObjet().getId() == idObjet ){ // pour vérifier si il dispose de l'objet à ajouter dans sa maison
                disposeDeLObjet = true;
            }
        }
        if (disposeDeLObjet == false)
        // si il ne dispose pas de l'objet
        throw new ObjetMaisonException("Vous ne disposez pas de cet objet");
        if(disposeDeLObjet == true){ // si il dispose de l'objet à placer dans la maison
            serviceInventaireObjet.retirerObjet(idObjet, quantiteObjet, idPersonnage); // je retire l'objet de l'inventaire du personnage
            for(EquipementMaison objets: inventaireDeLaMaison){ // je parcours les objets placés dans la maison
                if(objets.getObjet().getId() == idObjet){ // si il y a déja l'objet
                    objets.ajouterObjet(quantiteObjet); // j'augmente sa quantité
                }
                else{
                    // si l'objet n'est pas present
                    EquipementMaison objetAajouter = new EquipementMaison(maisonDuPersonnage,objet.get(), quantiteObjet, typeObjet); // je place l'objet dans la maison
                    inventaireMaisonRepository.save(objetAajouter); // je le sauvegarde dans la bdd
                } 
            }
        }
    }

    public List<EquipementMaison> objetsMaisonDuPersonnage(Maison maisonPerso){ // méthode pour accéder aux objets placés dans la maison grâce au repository InventaireMaisonRepository 
        return inventaireMaisonRepository.findByMaison(maisonPerso);
    }

    public boolean retirerObjet(Integer idPersonnage, int idObjetARetirer, int quantiteObjetARetirer) throws ObjetMaisonException{
        Optional<Personnage> personnage = personnageRepository.findById(idPersonnage);
        Optional<Objet> objet = objetRepository.findById(idObjetARetirer);

        Maison maisonDuPersonnage = personnage.get().getMaison();
        List<EquipementMaison> objetsPlacesMaison = objetsMaisonDuPersonnage(maisonDuPersonnage);
        for(EquipementMaison equipementMaison : objetsPlacesMaison ){
            if(equipementMaison.getObjet().getId() == objet.get().getId()){ // si l'objet est placé dans la maison
               // vérifier si l'objet est placé et si la quantité placé >= quantité à retirer
                if(equipementMaison.getQuantite() >= quantiteObjetARetirer){
                    serviceInventaireObjet.ajouterObjet(idPersonnage, idObjetARetirer, quantiteObjetARetirer);
                    return true;
                }
                else{
                    throw new ObjetMaisonException("Vous ne pouvez retirer plus d'objet qu'il n y a d'objet placé");
                }
            }
        }
        throw new ObjetMaisonException("L'objet que vous souhaitez retirer n'est pas placé dans la maison");
    }


    
    
    
}
