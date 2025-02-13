<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>集金</title>
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
        .back-link {
            text-decoration: none;
            color: #007bff;
            font-size: 18px;
            display: inline-block;
            margin-bottom: 20px;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .photo-upload {
            text-align: center;
            margin-bottom: 20px;
        }
        .photo-upload img {
		    width: 700px; /* 幅 */
		    height: 350px; /* 高さ */
		    border: 1px solid #ccc; /* 枠線 */
		    border-radius: 8px; /* 角丸 */
		    object-fit: cover; /* 画像の調整方法 */
		}

        .items {
            margin-bottom: 20px;
        }
        .items label {
            display: flex;
            align-items: center;
            font-size: 18px;
            margin-bottom: 10px;
        }
        .items input[type="checkbox"] {
            margin-right: 10px;
            transform: scale(1.2);
        }
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
        <a href="supplies.html" class="back-link">&raquo; 戻る</a>

        <div class="title">書道セット</div>

        <div class="photo-upload">
            <img src="https://via.placeholder.com/200x150" alt="写真">
        </div>

        <div class="items">
            <label><input type="checkbox"> ドラゴン習字セット (3,800円)</label>
            <label><input type="checkbox"> キュート習字セット (3,600円)</label>
            <label><input type="checkbox"> スーパー筆 (1,200円)</label>
            <label><input type="checkbox"> ハイパー墨汁 (900円)</label>
        </div>
        <a href="credit.jsp" style="text-decoration: none;">
        	<button class="submit-button" onclick="goToPayment()">お支払いへ</button>
    	</a>
    </main>

    <script>
        function goToPayment() {
            window.location.href = "payment.html";
        }
    </script>
</body>
</html>

