<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理メニュー</title>
    <style>
        /* 全体の基本スタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* ヘッダーのデザイン */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: #f4f4f4;
            border-bottom: 1px solid #ddd;
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
        }
        .user-info {
            display: flex;
            align-items: center;
        }

        /* ナビゲーションメニュー */
        .nav-menu {
            display: flex;
            width: 100%;
            margin: 20px 0;
        }
        .nav-menu a {
            display: block;
            padding: 15px;
            text-decoration: none;
            color: #333;
            border: 1px solid #ddd;
            text-align: center;
            width: 100%; /* 横幅いっぱい */
            box-sizing: border-box;
        }
        .nav-menu a:hover {
            background-color: #f0f0f0;
        }

        /* メインコンテンツエリア */
        .content {
            padding: 20px;
            text-align: center;
            max-width: 1200px;
            margin: 0 auto;
        }

        /* フォームとボタンのデザイン */
        .tempoheader {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 15px;
            text-align: left;
        }

        .tempoform-group {
            margin-bottom: 20px;
        }

        .date-range {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .date-range input {
            width: calc(50% - 10px);
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .tempoform-buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        button {
            padding: 15px 30px; /* ボタンを大きくする */
            font-size: 16px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold; /* ボタンのテキストを太字に */
        }

        button:hover {
            background-color: #e2e2e2;
        }

        .btn-back {
            background-color: #f8d7da; /* 戻るボタンの色 */
            border-color: #f5c6cb;
        }

        .btn-back:hover {
            background-color: #f1b0b7;
        }

        .btn-submit {
            background-color: #d4edda; /* 投稿ボタンの色 */
            border-color: #c3e6cb;
        }

        .btn-submit:hover {
            background-color: #c3e6cb;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>管理メニュー</h1>
        <div class="user-info">
            <span>全体アカウントでログイン中</span>
            <a href="#">担当ページへ</a>
        </div>
    </div>

    <div class="nav-menu">
        <a href="/shop_comp/teacher/calendar.jsp">カレンダー</a>
        <a href="/shop_comp/teacher/contact.jsp">連絡</a>
        <a href="/shop_comp/teacher/Money.jsp">集金</a>
        <a href="/shop_comp/teacher/temperature.jsp">体温</a>
        <a href="/shop_comp/teacher/children.jsp">児童</a>
    </div>

    <div class="content">
        <p>${ param.content }</p>
    </div>

</body>
</html>
