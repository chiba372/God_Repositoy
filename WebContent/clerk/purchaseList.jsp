<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List, bean.PurchaseInfo" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<%@ include file="./../menu3.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
		body {
			font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
		}

		.title h1 {
            font-size: 22px;
            margin-top: 50px;
            margin-left: 30px;
        }

        /* コンテナのスタイル設定 */
        .container {
            width: 90%;
			margin-left: 60px;
        }

		table {
			width: 100%;
			border-collapse: collapse;
			margin-bottom: 100px;
		}

		table th, table td {
			border: 1px solid #ddd;
			padding: 10px;
			text-align: left;
		}

		table th {
			background-color: #f4f4f4;
		}

		table tfoot td {
			font-weight: bold;
		}

		.button-container button {
			padding: 10px 20px;
			font-size: 16px;
			border: 2px solid #333;
			border-radius: 5px;
			background-color: white;
			cursor: pointer;
			margin-left: 965px;
			margin-top: 10px;
			margin-bottom: 20px;
		}

		.button-container button:hover {
			background-color: #f0f0f0;
		}

	</style>
</head>
<body>
	<div class="container">
	<div class="title">
		<h1>購入リスト</h1>
	</div>
	<!-- 購入リスト -->
		<table>
			<tr>
				<th>児童番号</th>
				<th>名前</th>
				<th>カタログ名</th>
				<th>商品番号</th>
				<th>個数</th>
				<th>金額</th>
			</tr>
			<%
				List<PurchaseInfo> purchaseList = (List<PurchaseInfo>) request.getAttribute("purchaseList");
				if (purchaseList != null && !purchaseList.isEmpty()) {
					for (PurchaseInfo purchase : purchaseList) {
			%>
			<tr>
				<td><%= purchase.getStudentId() %></td>
				<td><%= purchase.getStudentName() %></td>
				<td><%= purchase.getProductName() %></td>
				<td><%= purchase.getProductId() %></td>
				<td><%= purchase.getProQua() %></td>
				<td><%= purchase.getTotal() %>円</td>
			</tr>
			<%
					}
				} else {
			%>
			<tr>
				<td colspan="6">データがありません</td>
			</tr>
			<% } %>
		</table>
	</div>

<%@ include file="./../footer.html" %>

</body>
</html>