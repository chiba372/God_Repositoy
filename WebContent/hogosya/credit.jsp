<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Product, bean.CreditInfo" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>クレジットカード入力</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
    <style>
        /* ページ全体のスタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }

        /* コンテンツのコンテナ */
        .container {
            padding: 20px;
            max-width: 800px;
            margin: 20px auto;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        /* タイトルのスタイル */
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        /* 入力フォームのスタイル */
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-size: 18px;
            margin-bottom: 5px;
        }
        .form-group input {
            width: calc(100% - 10px);
            padding: 8px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* 有効期限入力のスタイル */
        .form-inline {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .form-inline input {
            flex: 1;
        }

        /* 送信ボタンのスタイル */
        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 18px;
            color: #ffffff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }
        .submit-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <main class="container">
        <div class="title">クレジットカード入力</div>

        <!-- クレジットカード情報入力フォーム -->
        <form action="completeOrder" method="post">

            <div class="form-group">
                <label for="card-number">クレジットカード番号</label>
                <input type="text" id="card-number" name="cardNumber" placeholder="1234 5678 9012 3456" required>
            </div>

            <div class="form-group">
                <label for="expiry">有効期限</label>
                <div class="form-inline">
                    <input type="number" id="expiry-month" name="expiryMonth" placeholder="月" min="1" max="12" required>
                    <span>月</span>
                    <input type="number" id="expiry-year" name="expiryYear" placeholder="年" min="2024" max="2030" required>
                    <span>年</span>
                </div>
            </div>

            <div class="form-group">
                <label for="card-name">カード名義</label>
                <input type="text" id="card-name" name="cardName" placeholder="KASAMA IORI" required>
            </div>

            <div class="form-group">
                <label for="security-code">セキュリティコード</label>
                <input type="number" id="security-code" name="securityCode" placeholder="000" required>
            </div>

            <button type="submit" class="submit-button">確認する</button>
        </form>
    </main>
</body>
</html>
