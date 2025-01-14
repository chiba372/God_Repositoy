<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>トップ画面</title>


<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            position: relative;
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
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 30px;
            padding: 20px;
            max-width: 1200px;
            margin: 20px auto;
            box-sizing: border-box;
        }
        .card {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-decoration: none;
            color: #333;
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .card img {
            width: 60px;
            height: 60px;
            margin-bottom: 10px;
        }
        .card p {
            margin: 0;
            font-size: 18px;
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
        <a href="calendar.html" class="card">
            <img src="https://via.placeholder.com/60" alt="カレンダー">
            <p>カレンダー</p>
        </a>
        <a href="important.html" class="card">
            <img src="https://via.placeholder.com/60" alt="重要連絡">
            <p>重要連絡</p>
        </a>
        <a href="payment.html" class="card">
            <img src="https://via.placeholder.com/60" alt="集金">
            <p>集金</p>
        </a>
        <a href="temperature.html" class="card">
            <img src="https://via.placeholder.com/60" alt="体温報告">
            <p>体温報告</p>
        </a>
        <a href="contact.html" class="card">
            <img src="https://via.placeholder.com/60" alt="ご連絡の場合">
            <p>ご連絡の場合</p>
        </a>
        <a href="profile.html" class="card">
            <img src="https://via.placeholder.com/60" alt="プロフィール設定">
            <p>プロフィール設定</p>
        </a>
    </main>
    <script>
        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active');
        }
    </script>
</body>
</html>
