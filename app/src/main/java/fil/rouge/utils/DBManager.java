package fil.rouge.utils;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Savepoint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

public class DBManager {
    public static Session session;
    private Savepoint savepoint;

    public static Connection conn = null;
    

    //Ouvre la connexion à la base de données
    public static void open() {
        Configuration configuration = new Configuration().configure();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    //ferme la connexion à la base de données
    public static void close() {
        session.close();
    }

    
    //crée un point de sauvegarde dans la base de données
    public Savepoint setSavepoint(final String savePoint) {
        
        session.doWork(new Work() {
        @Override
        public void execute(Connection connection) throws SQLException      {
            savepoint = connection.setSavepoint(savePoint);
          }
        });
      return savepoint;
    }

    //effectue un rollback de la base de données au point de sauvegarde précédemment créé
    public void rollbackSavepoint(final Savepoint savepoint) {
        session.doWork(new Work() {
        @Override
        public void execute(Connection connection) throws SQLException     {
            connection.rollback(savepoint);
        }
      });
    }

   
}
