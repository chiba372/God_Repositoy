<!-- つかわないかも -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        table th {
            background-color: #f0f0f0;
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
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }
        .confirm-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <main class="container">
        <a href="payment.html" class="back-link">&raquo; 戻る</a>

        <div class="title">購入確認</div>

        <div class="section">
            <p>下記内容でよろしければ右下の「購入確定」を押してください。</p>
        </div>

        <div class="section">
            <table>
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>商品名</th>
                        <th>金額</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>キュート習字セット</td>
                        <td>3,800円</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>ハイパー墨汁</td>
                        <td>900円</td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" style="text-align: right;">合計</td>
                        <td>4,700円</td>
                    </tr>
                </tfoot>
            </table>
        </div>

        <div class="section">
            <p>[クレジットカード情報]</p>
            <table>
                <tbody>
                    <tr>
                        <th>クレジットカード番号</th>
                        <td>1234 5678 9012 3456</td>
                    </tr>
                    <tr>
                        <th>有効期限</th>
                        <td>7月2027年</td>
                    </tr>
                    <tr>
                        <th>カード名義</th>
                        <td>KASAMA IORI</td>
                    </tr>
                    <tr>
                        <th>セキュリティコード</th>
                        <td>000</td>
                    </tr>
                </tbody>
            </table>

			<form action="buy-success.jsp" method="post">
			    <button class="confirm-button">購入確定</button>
			</form>
        </div>
    </main>

    <script>
        function confirmPurchase() {
            // 購入確認セクションを非表示にして購入確定セクションを表示
            document.getElementById('confirmation-section').classList.remove('active');
            document.getElementById('success-section').classList.add('active');
        }
    </script>
</body>
</html>
