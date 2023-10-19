<%@page import="model.domain.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>4Log Products - Admin Panel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="./CSS/global.css"/>
        <link rel="stylesheet" href="./CSS/index.css"/>
        
        <link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/6947/6947559.png"/>
    </head>
    <body>
        <div class="container">
            <h1>4LOG Products.</h1>
               
            <main>
                <form name="new-product" method="POST" action="/website/products">
                    <h2>Save a product</h2>

                    <div>
                        <label for="name-input">Name</label>
                        <input type="text" name="name-input" id="name-input" placeholder="Insert a product name" minlength="1" maxlength="50" required="true"/>
                    </div>

                    <div>
                        <label for="brand-input">Brand</label>
                        <input type="text" name="brand-input" id="brand-input" placeholder="Insert a product name" minlength="1" maxlength="50" required="true"/>
                    </div>

                    <div>
                        <label for="price-input">Price</label>
                        <input type="number" min="1" step="any" name="price-input" id="price-input" placeholder="Insert a product price" required="true">
                    </div>

                    <input type="submit" value="Add" name="submit-btn" />
                </form>
                
                <form name="find-all" id="findAllTB" method="GET" action="/website/products">
                            <%
                                List<Product> productList = (List<Product>) request.getAttribute("products");
                            
                                if(productList == null) {
                            %>
                                <div>
                                    <button type="submit">Fill table...</button>
                                </div>
                                
                                <p>Fill table to see all products...</p>
                            <%
                                } else {
                            %>
                                <div>
                                    <button type="submit">Update table...</button>
                                </div>
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
                </form>
            </main>
        </div>

        <div class="footer">
            <p>Development by <a href="github.com/Matheus-FSantos" target="_blank">Matheus Ferreira Santos</a>.</p>
        </div>
    </body>
</html>

