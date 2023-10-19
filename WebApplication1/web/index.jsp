<%@page import="model.domain.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product List</h1>
        
        
        <!-- Formulário de cadastro de produto -->
        <form name="save-a-product" method="POST" action="/WebApplication1/products">
            <label for="name-input">Name</label>
            <input id="name-input" name="name-input" placeholder="Insert a product name" minlength="1" minlength="50" required="true"/>
            <br/>
            
            <label for="brand-input">Brand</label>
            <input id="brand-input" name="brand-input" placeholder="Insert a product brand" minlength="1" minlength="50" required="true"/>
            <br/>
            
            <label for="price-input">Price</label>
            <input type="number" min="1" step="any" id="price-input" name="price-input" placeholder="Insert a product price" required="true"/>
            <br/>
            
            <input type="submit" value="Submit" />
        </form>
        
        <!-- Tabela de listagem de produtos -->
        <%
            List<Product> productList = (List<Product>) request.getAttribute("products");
            
            if(productList == null) {
        %>
                <p>Fill table to see all products.</p>
                <form name="find-all" action="/WebApplication1/products">
                    <input type="submit" value="Fill table" />
                </form>
        <%
            } else {
        %>
                <form name="find-all" method="GET" action="/WebApplication1/products">
                    <input type="submit" value="Update table" />
                </form>
                <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Brand</th>
                        <th>Price</th>
                        <th>Created At</th>
                    </tr>
                </thead>
                <tbody>
        <%  
                for(Product product : productList) {  
        %>
                    <tr>
                        <td><%= product.getLgName() %></td>
                        <td><%= product.getLgBrand() %></td>
                        <td>$ <%= product.getLgPrice() %></td>
                        <td><%= product.getLgcreatedAt() %></td>
                    </tr>
        <%    
                }
        %>
                    </tbody>
                </table>
        <%
            }
        %>
    </body>
</html>
