package fil.rouge.model;

public class Ingredients {

    private int idRessource;
    private int quantiteRessource;


    public int getIdRessource() {
        return idRessource;
    }
    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }
    public int getQuantiteRessource() {
        return quantiteRessource;
    }
    public void setQuantiteRessource(int quantiteRessource) {
        this.quantiteRessource = quantiteRessource;
    }

    public Ingredients(){
        
    }

    public Ingredients(int idRessource, int quantiteressource){
        this.idRessource = idRessource;
        this.quantiteRessource = quantiteressource;
    }

// Niveau 1 à 2 => 2 roseaux, 2 silex, 2 mares, 2 plombs, 2 bois morts_
// Niveau 2 à 3 => 3 roseaux, 3 silex, 3 mares, 3 plombs, 3 bois morts
// Niveau 3 à 4 => 4 roseaux, 4 brique, 4 pluies, 4 fer, 4 champignons
// Niveau 4 à 5 => 5 bambous, 5 brique, 5 pluies, 5 fer, 5 coton
// Niveau 5 à 6 => 6 bambous, 6 brique, 6 pluies, 6 fer, 6 coton
// Niveau 6 à 7 => 7 bambous, 7 brique, 7 pluies, 7 fer, 7 coton
// Niveau 7 à 8 => 4 chênes, 4 granit, 4 rivières, 4 cuivre, 4 lin
// Niveau 8 à 9 => 5 chênes, 5 granit, 5 rivières, 5 cuivre, 5 lin
// Niveau 9 à 10 => 6 chênes, 6 granit, 6 rivières, 6 cuivre, 6 lin
// Niveau 10 à 11 => 5 ebene, 5 marbre, 5 sources, 5 argent, 5 lins
// Niveau 11 à 12 =>  6 ebène, 6 marbre, 6 sources, 6 argent, 6 lins
// Niveau 12 à 13 => 7 ébène, 7 schiste, 7 sources, 7 or, 7 chanvre
    
    
}
