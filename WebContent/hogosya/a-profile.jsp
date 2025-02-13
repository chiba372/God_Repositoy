<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer - トップ</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            position: relative;
        }
        .container {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 30px;
            padding: 20px;
            max-width: 1200px;
            margin: 20px auto;
            box-sizing: border-box;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>トップページのコンテンツ</h2>
    </div>

</body>
</html>
