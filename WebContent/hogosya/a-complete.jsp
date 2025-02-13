<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bean.Product" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>購入完了</title>
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
            text-align: center;
        }
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .product-list {
            list-style: none;
            padding: 0;
            text-align: left;
        }
        .product-item {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 18px;
            color: #ffffff;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <main class="container">
        <div class="title">購入完了</div>
        <p>ご購入ありがとうございました！</p>

        <h3>購入商品一覧</h3>
        <ul class="product-list">
            <%
                List<Product> purchasedProducts = (List<Product>) session.getAttribute("selectedProducts");
                if (purchasedProducts != null && !purchasedProducts.isEmpty()) {
                    for (Product product : purchasedProducts) {
            %>
                <li class="product-item"><%= product.getName() %> - ¥<%= product.getPrice() %></li>
            <%
                    }
                } else {
            %>
                <p>購入した商品が見つかりません。</p>
            <% } %>
        </ul>

        <a href="catalog.jsp" class="button">トップページへ戻る</a>
        <a href="purchaseHistory.jsp" class="button">購入履歴を見る</a>
    </main>
</body>
</html>
