<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>重要連絡</title>
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

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .announcement {
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
            cursor: pointer;
        }

        .announcement:last-child {
            border-bottom: none;
        }

        .announcement-title {
            font-size: 18px;
            font-weight: bold;
            margin: 0;
        }

        .announcement-details {
            display: none;
            margin-top: 10px;
            font-size: 16px;
            color: #555;
        }

        .announcement-details.active {
            display: block;
        }
    </style>
</head>
<body>
    <header class="header">
        <a href="#" class="menu-icon">☰</a>
        <h1>重要連絡</h1>
        <a href="logout.html" class="logout-icon">🚪</a>
    </header>

    <div class="container">
        <div class="announcement" onclick="toggleDetails(this)">
            <p class="announcement-title">9/17 「来月末の運動会について」</p>
            <div class="announcement-details">
                <p>対象: 全体</p>
                <p>掲載期間: 9/17 ~ 10/31</p>
                <p>内容: 運動会の詳細については追ってお知らせします。</p>
            </div>
        </div>
        <div class="announcement" onclick="toggleDetails(this)">
            <p class="announcement-title">9/1 「三者面談の日程について」</p>
            <div class="announcement-details">
                <p>対象: クラス</p>
                <p>掲載期間: 9/1 ~ 9/30</p>
                <p>内容: 各家庭への三者面談の日程は以下の通りです。</p>
            </div>
        </div>
    </div>

    <script>
        function toggleDetails(element) {
            const details = element.querySelector('.announcement-details');
            details.classList.toggle('active');
        }
    </script>
</body>
</html>
