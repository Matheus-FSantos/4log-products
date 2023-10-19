package model.service;

import model.domain.Product;
import model.repository.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class ProductService {
    
    private final ProductRepository productRepository;
    
    public ProductService() {
        this.productRepository = new ProductRepository();
    }
    
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
    
    public void save(HttpServletRequest request) throws Exception {
        String productName = request.getParameter("name-input");
        String productBrand = request.getParameter("brand-input");
        Double productPrice = Double.valueOf(request.getParameter("price-input"));
        Product newProduct = new Product(UUID.randomUUID().toString(), productName, productBrand, productPrice, new Date());
        
        this.productRepository.save(newProduct);
    }
}
