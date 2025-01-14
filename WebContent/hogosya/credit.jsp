<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer - クレジットカード入力</title>
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
        .form-inline {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .form-inline input {
            flex: 1;
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
        <a href="supplies.html" class="back-link">&raquo; 戻る</a>

        <div class="title">クレジットカード入力</div>

        <form action="confirmation.html">
            <div class="form-group">
                <label for="card-number">クレジットカード番号</label>
                <input type="number" id="card-number" name="card-number" placeholder="1234 5678 9012 3456" inputmode="numeric">
            </div>

            <div class="form-group">
                <label for="expiry">有効期限</label>
                <div class="form-inline">
                    <input type="number" id="expiry-month" name="expiry-month" placeholder="月" min="1" max="12">
                    <span>月</span>
                    <input type="number" id="expiry-year" name="expiry-year" placeholder="年" min="2023" max="2030">
                    <span>年</span>
                </div>
            </div>

            <div class="form-group">
                <label for="card-name">カード名義</label>
                <input type="text" id="card-name" name="card-name" placeholder="KASAMA IORI">
            </div>

            <div class="form-group">
                <label for="security-code">セキュリティコード</label>
                <input type="number" id="security-code" name="security-code" placeholder="000" inputmode="numeric">
            </div>

            <button type="submit" class="submit-button">確認する</button>
        </form>
    </main>

    <script>
        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active');
        }
    </script>
</body>
</html>
