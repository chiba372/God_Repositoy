<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Product" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>カタログ詳細</title>
    <style>
        .product-list {
            padding: 0;
        }
        .product-item {
            list-style: none;
            padding: 5px 0;
        }
    </style>
</head>
<body>
    <h2>商品一覧</h2>
    <form action="<%= request.getContextPath() %>/CreditServlet" method="post">
        <div class="product-list">
            <%
                List<Product> productList = (List<Product>) request.getAttribute("productList");
                if (productList != null && !productList.isEmpty()) {
                    for (Product product : productList) {
            %>
            <div class="product-item">
                <input type="checkbox" name="productIds" value="<%= product.getId() %>">
                <%= product.getName() %> - ¥<%= product.getPrice() %>
            </div>
            <%
                    }
                } else {
            %>
            <p>このカタログには商品がありません。</p>
            <% } %>
        </div>
        <button type="submit">次へ進む</button>
    </form>
</body>
</html>
