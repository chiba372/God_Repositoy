<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer - 平熱設定</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
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
            flex: 1;
            padding: 20px;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 100%;
            max-width: 1600px;
            margin-top: 20px;
        }
        .form-wrapper {
            background-color: #ffffff;
            padding: 30px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            box-sizing: border-box;
            position: relative;
        }
        .form-group {
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }
        label {
            font-size: 18px;
            margin-right: 10px;
            white-space: nowrap;
        }
        input[type="text"], input[type="number"] {
            width: auto;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .btn {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            font-size: 18px;
            padding: 10px 60px;
            text-align: center;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.2s;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .btn-back {
            color: #007bff;
            font-size: 18px;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .btn-back::before {
            content: '»';
            margin-right: 5px;
        }
        .btn-back:hover {
            text-decoration: underline;
        }
        .success-message {
            display: none;
            text-align: center;
        }
        .success-message .btn {
            text-decoration: none;
            margin-top: 20px;
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
        <!-- 平熱設定フォーム -->
        <div class="form-wrapper" id="form-container">
            <a href="javascript:history.back()" class="btn-back">戻る</a>
            <h2>平熱設定</h2>
            <form id="normal-temperature-form">
                <div class="form-group">
                    <label for="normal-temperature">平熱</label>
                    <input type="number" id="normal-temperature" name="normal-temperature" step="0.1" value="" required> 度
                </div>
                <div style="text-align: center;">
                    <button type="submit" class="btn">保存</button>
                </div>
            </form>
        </div>

        <!-- 保存完了メッセージ -->
        <div id="success-message" class="success-message">
            <h1>保存が完了しました！</h1>
            <p>平熱の設定が保存されました。</p>
            <a href="top.jsp" class="btn">戻る</a>
        </div>
    </main>

    <script>
        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active');
        }

        // 平熱設定フォームの送信処理
        document.getElementById('normal-temperature-form').addEventListener('submit', (event) => {
            event.preventDefault();

            const temperature = document.getElementById('normal-temperature').value;

            // ローカルストレージまたはサーバーに保存する処理をここに記述可能
            console.log(`平熱設定: ${temperature}度が保存されました。`);

            // 保存完了メッセージを表示
            document.getElementById('form-container').style.display = 'none';
            document.getElementById('success-message').style.display = 'block';
        });
    </script>
</body>
</html>
