package model.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    
    public Connection() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("WebApplication1PU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    
    public EntityManager getConnection() {
        return this.entityManager;
    }
    
}
