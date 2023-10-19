package model.repository;

import java.util.List;
import javax.persistence.TypedQuery;
import model.configuration.Connection;
import model.domain.Product;

public class ProductRepository {
    
    private final Connection connection;
    
    public ProductRepository() {
        this.connection = new Connection();
    }
    
    public List<Product> findAll() {
        String JPQLQuery = "SELECT p FROM Product p";
        TypedQuery<Product> query = this.connection.getConnection().createQuery(JPQLQuery, Product.class);
        return query.getResultList();
    }
    
    public void save(Product newProduct) throws Exception {
        this.connection.getConnection().getTransaction().begin();
        this.connection.getConnection().persist(newProduct);
        this.connection.getConnection().getTransaction().commit();
    }
    
}
