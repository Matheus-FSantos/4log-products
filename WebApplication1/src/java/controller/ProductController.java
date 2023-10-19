package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Product;
import model.service.ProductService;

@WebServlet(name = "ProductController", urlPatterns = {"/products"})
public class ProductController extends HttpServlet {

    private final ProductService productService = new ProductService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

        List<Product> productList = new ArrayList<>();
        
        try {
            productList = this.productService.findAll();
            request.setAttribute("products", productList);
            request.getRequestDispatcher("").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        
        try {
            this.productService.save(request);
            this.productService.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        response.sendRedirect("/WebApplication1/products"); /* Força uma renderização do banco de dados inteiro */
    }

    @Override
    public String getServletInfo() {
        return "Product controller";
    }

}
