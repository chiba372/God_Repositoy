<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page import="java.util.List, bean.Product, bean.CreditInfo" %>

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
        .section {
            margin-bottom: 20px;
        }
        .confirm-button {
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
        .confirm-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <main class="container">
        <div class="title">購入確認</div>

        <div class="section">
            <h3>注文内容</h3>
            <ul>
                <%
                    List<Product> selectedProducts = (List<Product>) session.getAttribute("selectedProducts");
                    if (selectedProducts != null && !selectedProducts.isEmpty()) {
                        for (Product product : selectedProducts) {
                %>
                    <li><%= product.getName() %> - ¥<%= product.getPrice() %></li>
                <%
                        }
                    } else {
                %>
                    <p>選択された商品がありません。</p>
                <% } %>
            </ul>
        </div>

        <div class="section">
            <h3>クレジットカード情報</h3>
            <%
                CreditInfo creditInfo = (CreditInfo) session.getAttribute("creditInfo");
                if (creditInfo != null) {
            %>
                <p>カード名義: <%= creditInfo.getCardName() %></p>
                <p>カード番号: **** **** **** <%= creditInfo.getMaskedCardNumber() %></p>
                <p>有効期限: <%= creditInfo.getExpiryMonth() %> / <%= creditInfo.getExpiryYear() %></p>
            <%
                } else {
            %>
                <p>クレジットカード情報がありません。</p>
            <% } %>
        </div>

        <form action="orderComplete" method="post">
            <button type="submit" class="confirm-button">購入確定</button>
        </form>
    </main>
</body>
</html>
