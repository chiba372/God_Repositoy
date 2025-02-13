<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>体温報告メニュー</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            display: flex;
            flex: 1;
            justify-content: center;
            align-items: center;
            gap: 50px;
            padding: 20px;
            flex-wrap: wrap;
            box-sizing: border-box;
        }
        .menu-button {
            display: inline-flex;
            justify-content: center;
            align-items: center;
            width: 250px;
            height: 150px;
            font-size: 24px;
            color: #333;
            background-color: #ffffff;
            border: 2px solid #333;
            border-radius: 15px;
            text-decoration: none;
            transition: background-color 0.2s, color 0.2s, transform 0.2s;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .menu-button:hover {
            background-color: #007bff;
            color: #ffffff;
            transform: translateY(-5px);
        }
    </style>
</head>
<body>
    <main class="container">
        <a href="taion-houkoku.jsp" class="menu-button">体温報告</a>
        <a href="heinetu.jsp" class="menu-button">平熱設定</a>
    </main>
</body>
</html>
