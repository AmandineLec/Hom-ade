package fil.rouge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObjetTest {
    @Test
    public void testequiper(){
        Joueur joueur = new Joueur("joueur", true);
        Hache hache = new Hache("hache");
        joueur.add(hache); //On ajoute l'hache dans l'inventaire avant de pouvoir l'équiper

        hache.equiper(joueur); //On équipe l'hache, qui doit s'enlever de l'inventaire. 

        assertTrue(joueur.getOutils()==hache);//Doit renvoyer vrai si la hache du joueur est bien renvoyé en get
    }

    @Test
    public void testdesequipper(){
        Joueur joueur = new Joueur("joueur", true);
        Detecteur detecteur = new Detecteur("detecteur");
        joueur.setOutils(detecteur);//On équipe le joueur du détecteur

        detecteur.desequipper(joueur);//On déséquippe le joueur

        assertFalse(joueur.getOutils()==detecteur);//On nous renvoie faux si le joueur n'est pas équiper du détecteur
    }


}
