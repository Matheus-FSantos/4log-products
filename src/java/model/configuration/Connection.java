package model.configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    
    public Connection() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("websitePU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    
    public EntityManager getConnection() {
        return this.entityManager;
    }
    
}
