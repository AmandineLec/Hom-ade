/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package fil.rouge;

import java.util.HashMap;

public class App {
public static HashMap<Integer, Integer> accesPieces = new HashMap<Integer, Integer>(); // Integer = niveau maison, Integer = "id" piece


    public static void main(String[] args) {

    }

    public static void creerPerso(){
        Joueur joueur = new Joueur("Jean", 1);
        joueur.sauvegarderJoueur();

    }

    // si joueur a les ressources et si niveau = 2 alors :
    // Pieces piece1 = new Piece() 
    // maison.levelUp(Piece)

    //Faire une méthode qui va définir selon le niveau de la maison quelle ressource il faut pour levelUp
}
