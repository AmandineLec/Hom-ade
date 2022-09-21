package fil.rouge.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// https://www.digitalocean.com/community/tutorials/spring-service-annotation
import fil.rouge.dao.PersonnageRepository;
import fil.rouge.model.Maison;
import fil.rouge.model.Personnage;
import fil.rouge.model.Piece;

@Service
public class DeplacementMaison {

    @Autowired // pour importer le repository de Personnage
    private PersonnageRepository personnageRepository;
    public Piece entrerDansLaMaison(int idPersonnage){
        // requête pour aller récupérer l'id de la maison(le même que celui du perso)
        // requête pour aller chercher la pièce située à l'index 0 de l'attribut pieces de la maison
        // c'est le resultat du select
        // @Controller
        // @PostMapping("hoome)
        // return "";
        Optional<Personnage> personnage = personnageRepository.findById(idPersonnage);
        Maison personnageMaison = personnage.get().getMaison();
        ArrayList <Piece> piecesFromMaisonPersonnage = personnageMaison.getPieces();
        Piece piecePrincipale = piecesFromMaisonPersonnage.get(0);
        return piecePrincipale; // resultat attendu
    }
        

    public Piece changerDepiece(int idMaison, ArrayList<Piece> pieces){
        // lié à la composition de la map de la pièce principale
        // si le personnage est dans la pièce principale, il peut aller 
        return pieces.get(0); // retournera l'index de la pièce en fonction de l'endroit où il est et celui où il peut aller

    }

    public void sortir(){

    }



    
}
