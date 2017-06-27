package br.edu.utfpr.pb.aulaswing.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class DatabaseConnection {
    private static DatabaseConnection dbConnection;
    private EntityManagerFactory emf;
    private Connection conn;
    
    private DatabaseConnection(){
        this.emf = Persistence
                .createEntityManagerFactory("AulaSwingPU");
        
        Session session = getEntityManager()
                        .unwrap(Session.class);
        SessionFactoryImplementor 
                sessionFactoryImplementation = 
                    (SessionFactoryImplementor) 
                        session.getSessionFactory();
        ConnectionProvider connectionProvider = 
               sessionFactoryImplementation
                       .getConnectionProvider();
        try {
            this.conn = connectionProvider.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance(){
        if (dbConnection == null){
            dbConnection = new DatabaseConnection();
        }
        return dbConnection;
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public Connection getConnection(){
        return conn;
    }
}


