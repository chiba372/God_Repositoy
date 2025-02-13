<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ page import="java.util.List, bean.Catalog" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カタログ一覧</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .catalog-list {
            list-style: none;
            padding: 0;
        }
        .catalog-item {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>カタログ一覧</h2>
        <div>
	        <%
	            List<Catalog> catalogList = (List<Catalog>) request.getAttribute("catalogList");
	            if (catalogList != null && !catalogList.isEmpty()) {
	                for (Catalog catalog : catalogList) {
	        %>
	        <li><a href="catalogDetail?id=<%= catalog.getId() %>"><%= catalog.getName() %></a></li>
	        <%
	                }
	            } else {
	        %>
	        <p>現在、購入可能な商品はありません。</p>
	        <% } %>
	    </div>
    </div>

</body>
</html>
