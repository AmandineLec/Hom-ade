package fil.rouge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaisonTest {
    @Test
    public void levelUpTestAvecAjoutPiece(){
        Pieces piece = new Pieces("salon", 10);
        Maison maison = new Maison(1);
        maison.setNiveau(3);
        maison.levelUp(piece);
        assertTrue(maison.getNiveau()==4 && maison.getNb_pieces()==2);
    }

    @Test
    public void levelUpTestAvecAgrandissement(){
        Pieces piece = new Pieces("salon", 10);
        Maison maison = new Maison(1);
        maison.setNiveau(4);
        maison.levelUp(piece);
        assertTrue(maison.getNiveau()==5 && piece.getTaille()==11 && maison.nb_pieces==1);
    }


    @Test
    public void ajoutPieceTest(){
        Maison maison = new Maison(1);
        Pieces cuisine = new Pieces("cuisine");
        maison.ajoutPiece(cuisine);
        assertTrue(maison.getNb_pieces()==2 && maison.getPiece().getNom()=="cuisine");
    }
}

/*  levelUp : 
 si niveau >= 1 && <=3 = maison.ajoutpiece(piece);
 sinon si niveau >3 && niveau%2 == 0 = maison.ajouterpiece(piece)
 sinon piece.agrandir(5)
*/