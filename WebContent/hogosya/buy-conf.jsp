<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer - 購入確認</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .header {
            width: 100%;
            max-width: 1600px;
            background-color: #ffffff;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 20px 40px;
            border-bottom: 1px solid #ccc;
            box-sizing: border-box;
            position: relative;
            z-index: 2;
        }
        .header a {
            text-decoration: none;
            color: #333;
            font-size: 28px;
            cursor: pointer;
            transition: color 0.2s;
        }
        .header a:hover {
            color: #007bff;
        }
        .header h1 {
            margin: 0;
            font-size: 32px;
        }
        .menu {
            display: none;
            position: absolute;
            top: 80px;
            left: 0;
            width: 100%;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            z-index: 1;
        }
        .menu.active {
            display: block;
        }
        .menu ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }
        .menu ul li {
            padding: 15px 20px;
            border-bottom: 1px solid #ccc;
        }
        .menu ul li a {
            text-decoration: none;
            color: #333;
            font-size: 18px;
            transition: color 0.2s;
        }
        .menu ul li a:hover {
            color: #007bff;
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
    <header class="header">
        <!-- ハンバーガーメニュー -->
        <a href="#" class="menu-icon" onclick="toggleMenu()">☰</a>

        <!-- 中央のタイトル -->
        <a href="home.html">
            <h1>SchoolOrganizer</h1>
        </a>

        <!-- 右上の扉アイコン -->
        <a href="logout.html" class="logout-icon">🚪</a>
    </header>

    <!-- メニュー -->
    <nav class="menu" id="menu">
        <ul>
            <li><a href="logout.html">> ログアウト</a></li>
            <li><a href="calendar.html">> カレンダー</a></li>
            <li><a href="important.html">> 重要連絡</a></li>
            <li><a href="supplies.html">> 学用品購入</a></li>
            <li><a href="temperature.html">> 体温報告</a></li>
            <li><a href="contact.html">> ご連絡の場合</a></li>
            <li><a href="profile.html">> プロフィール設定</a></li>
        </ul>
    </nav>

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
        </div>

        <button class="confirm-button" onclick="confirmPurchase()">購入確定</button>
    </main>

    <script>
        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active');
        }

        function confirmPurchase() {
            window.location.href = "success.html";
        }
    </script>
</body>
</html>
