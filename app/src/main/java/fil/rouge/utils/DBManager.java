package fil.rouge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class DBManager {
    public static Connection conn = null;
    private static String user = "demidieux";
    private static String password = "m#5Da$52gn";
    private static String server = "51.68.227.19";
    private static String database = "demidieux_filrouge";


    //initialise la connexion à la base de données
    public static void init() {
        try {
            DBManager.conn = DriverManager.getConnection("jdbc:mysql://" + DBManager.server + "/" + database + "?",
                    user, password);
        // url uniform ressource locator sous protocol jdbc via protocol mysql =
        // "jdbc:mysql://"


        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
        }
    }

    //retourne un PreparedStatement à partir d'un update sql
    public static PreparedStatement update(String sql) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt;
        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
            return null;
        }
    }

    //retourne le résultat d'une requête sql
    public static ResultSet query(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultat = stmt.executeQuery(sql);
            return resultat;
        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
            return null;
        }
    }

    public static PreparedStatement preparedStatement(String sql) {
      try {
        return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // on permet la connection avec la bdd pour
                                                                            // faire des requêtes de type prepared statement et obtenir la clé primaire générée
      } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
      }
      return null;
    }


    //ferme la connexion à la base de données
    public static void close() {
        try {
            DBManager.conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException : " + ex.getMessage());
            System.out.println("SQLState : " + ex.getSQLState());
            System.out.println("VendorError : " + ex.getErrorCode());
        }
    }

    //crée un point de sauvegarde dans la base de données
    public static Savepoint setSavePoint() {
        Savepoint save = null;
        try {
            save = conn.setSavepoint();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return save;
    }

    //effectue un rollback de la base de données au point de sauvegarde précédemment créé
    public static void rollback(Savepoint save) {
        try {
            conn.rollback(save);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //permet de modifier l'option d'autocommit de la base de données
    public static void setAutoCommit(boolean autocommit) {
        try {
            conn.setAutoCommit(autocommit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
