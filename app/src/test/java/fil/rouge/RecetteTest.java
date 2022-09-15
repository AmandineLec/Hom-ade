// package fil.rouge;
// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;
// import java.sql.Savepoint;

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;

// import fil.rouge.utils.DBManager;

// public class RecetteTest {
//     static Savepoint save;

//     @BeforeAll
//     static void setup() {
//         DBManager.init();
//         DBManager.setAutoCommit(false);
//     }

//     @BeforeEach
//     void init() {
//         save = DBManager.setSavePoint();
//     }

//     @Test
//     public void Testrecette(){
//         Recettes recette = new Recettes("Hache rudimentaire", 4);
//         assertTrue(recette.getQuantite().containsKey(7));
//         assertTrue(recette.getQuantite().containsKey(3));
//     }


//     @Test
//     public void TestCreerItem(){

//         Outils canneapeche = new Outils(1);

//         Maison maison = new Maison();
//         maison.setNiveau(1);

//         Ressource bois = new Ressource(2);
//         Ressource lin = new Ressource(5);
//         Ressource roseau = new Ressource(4);

//         Joueur joueur = new Joueur("joueur", 1);
//         joueur.getInventoryressource().put(bois.getId(), 7);
//         joueur.getInventoryressource().put(lin.getId(),8);
//         joueur.getInventoryressource().put(roseau.getId(), 2);
//         joueur.getInventoryressource();
//         joueur.setMaison(maison);

//         Recettes recette = new Recettes(1);
//         recette.getQuantite().put(bois.getId(), 5);
//         recette.getQuantite().put(lin.getId(), 6);
//         recette.getQuantite();
//         recette.setNiveau_requis(1);

//         recette.fusionnerRessource(joueur, canneapeche);
//         assertTrue(joueur.getInventoryobjet().containsKey(canneapeche.getId()));
//     }

//     @AfterEach
//     void done() {
//         DBManager.rollback(save);
//     }

//     @AfterAll
//     static void teardown() {
//         DBManager.close();
//     }

// }
