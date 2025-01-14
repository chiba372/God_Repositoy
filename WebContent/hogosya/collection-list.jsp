<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>集金一覧</title>
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

        .collection-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
            transition: background-color 0.2s, box-shadow 0.2s;
            text-decoration: none;
            color: #333;
        }

        .collection-item:hover {
            background-color: #e9ecef;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .collection-item span {
            font-size: 16px;
        }
    </style>
</head>
<body>
    <header class="header">
        <a href="#" class="menu-icon">☰</a>
        <h1>集金</h1>
        <a href="logout.html" class="logout-icon">🚪</a>
    </header>

    <div class="container">
        <a href="calligraphy.html" class="collection-item">
            <span>書道セット</span>
            <span>購入可能期限：2025/01/15</span>
        </a>
        <a href="sewing.html" class="collection-item">
            <span>裁縫セット</span>
            <span>購入可能期限：2025/02/10</span>
        </a>
        <a href="art.html" class="collection-item">
            <span>絵の具セット</span>
            <span>購入可能期限：2025/03/05</span>
        </a>
    </div>
</body>
</html>
