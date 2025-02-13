<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Product" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>購入確認</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .container {
            padding: 20px;
            max-width: 800px;
            margin: 20px auto;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .content {
            margin-bottom: 20px;
        }
        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 18px;
            color: #ffffff;
            background-color: #28a745;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }
        .submit-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <main class="container">
        <div class="title">購入確認</div>

        <h3>注文内容</h3>
        <ul>
            <%
                List<Product> selectedProducts = (List<Product>) session.getAttribute("selectedProducts");
                if (selectedProducts != null && !selectedProducts.isEmpty()) {
                    for (Product product : selectedProducts) { %>
                <li><%= product.getName() %> - ¥<%= product.getPrice() %></li>
            <%  }
                } else { %>
                <p>選択された商品がありません。</p>
            <% } %>
        </ul>

        <h3>クレジットカード情報</h3>
        <div class="content">
            <p>カード番号（下4桁）: **** **** **** <%= request.getAttribute("maskedCardNumber") %></p>
            <p>有効期限: <%= request.getAttribute("expiryMonth") %> / <%= request.getAttribute("expiryYear") %></p>
            <p>カード名義: <%= request.getAttribute("cardName") %></p>
        </div>

        <form action="completeOrder" method="post">
            <% if (selectedProducts != null) {
                for (Product product : selectedProducts) { %>
                <input type="hidden" name="selectedProducts" value="<%= product.getId() %>">
            <% } } %>

            <input type="hidden" name="cardNumber" value="<%= request.getAttribute("cardNumber") %>">
            <input type="hidden" name="expiryMonth" value="<%= request.getAttribute("expiryMonth") %>">
            <input type="hidden" name="expiryYear" value="<%= request.getAttribute("expiryYear") %>">
            <input type="hidden" name="cardName" value="<%= request.getAttribute("cardName") %>">

            <button type="submit" class="submit-button">注文を確定する</button>
        </form>
    </main>
</body>
</html>
