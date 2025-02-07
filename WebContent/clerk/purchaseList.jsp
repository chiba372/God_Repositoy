<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List, bean.PurchaseInfo" %>
<%
	Integer selectedGrade = (Integer) request.getAttribute("selectedGrade");
	Integer selectedClassNo = (Integer) request.getAttribute("selectedClassNo");
	List<Integer> classNumbers = (List<Integer>) request.getAttribute("classNumbers");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<%@ include file="./../menu3.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>購入リスト</title>
	<script>
		function updateClassSelect() {
			var grade = document.getElementById("grade").value;
			var classNo = document.getElementById("classNo").value;
			window.location.href = "purchaseList?grade=" + grade + "&classNo=" + classNo;
		}
	</script>
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

        .serch {
        	margin-top: 20px;
        	margin-bottom: 10px;
        	margin-left: 20px;
        }

        .count-container {
        	display: flex;
        	justify-content: space-between;
        	align-items: center;
        }

        .result-count {
        	font-weight: bold;
        	margin-right: 10px;
    	}

		table {
			width: 100%;
			border-collapse: collapse;
			margin-bottom: 80px;
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

		/* プルダウンリストの設定 */
		select {
			width: 100px;
			height: 25px;
			cursor: pointer;
		}

		/* ボタンのスタイル設定 */
		button {
			padding: 10px 20px;
			font-size: 16px;
			border: none;
			border-radius: 5px;
			background-color: #0059ff;
			color: white;
			cursor: pointer;
			margin-left: 20px;
			margin-top: 20px;
			margin-bottom: 10px;
		}

		button:hover {
			background-color: #0020c2;
		}

	</style>
</head>
<body>
	<div class="container">
	<div class="title">
		<h1>購入リスト</h1>
	</div>
	<div class="serch">
		<form action="purchaseList" method="get">
			<!-- 学年選択 -->
			<label for="grade">学年を選択　</label>
			<select id="grade" name="grade">
				<option value="">全学年</option>
				<option value="1" ${ selectedGrade == 1 ? "selected" : "" }>1年生</option>
				<option value="2" ${ selectedGrade == 2 ? "selected" : "" }>2年生</option>
				<option value="3" ${ selectedGrade == 3 ? "selected" : "" }>3年生</option>
				<option value="4" ${ selectedGrade == 4 ? "selected" : "" }>4年生</option>
				<option value="5" ${ selectedGrade == 5 ? "selected" : "" }>5年生</option>
				<option value="6" ${ selectedGrade == 6 ? "selected" : "" }>6年生</option>
			</select>
			<!-- クラスを選択 -->
			<label for="classNo">　クラスを選択　</label>
			<select name="classNo" id="classNo">
				<option value="">全クラス</option>
				<%
					if (classNumbers != null) {
						for (Integer classNo : classNumbers) {
				%>
				<option value="<%= classNo %>" <%= (selectedClassNo != null && selectedClassNo == classNo) ? "selected" : ""%>><%= classNo %>組</option>
				<%
						}
					}
				%>
			</select>

			<button type="submit">検索</button>
	</div>
	<div class="count-container">
		<div></div>
		<p class="result-count">検索結果 : ${purchaseCount}件</p>
	</div>
	<!-- 購入リスト -->
		<table>
			<tr>
				<th>児童番号</th>
				<th>名前</th>
				<th>学年</th>
				<th>クラス</th>
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
				<td><%= purchase.getGrade() %>年</td>
				<td><%= purchase.getClassNo() %>組</td>
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
				<td colspan="8">データがありません</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

<%@ include file="./../footer.html" %>

</body>
</html>