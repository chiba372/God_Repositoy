<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- 共通ヘッダーを読み込む -->

<%--
    // セッションを取得（すでに作成されているセッションを取得し、なければ null を返す）
    HttpSession session = request.getSession(false);

    // セッションがない、またはユーザー情報がない場合はログインページへリダイレクト
    if (session == null || session.getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // ログインユーザー名を取得
    String userName = (String) session.getAttribute("userName");
--%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer - トップ</title>

    <!-- ヘッダーのスタイルを適用 -->
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">

    <style>
        /* 全体のページスタイル */
        body {
            font-family: Arial, sans-serif; /* フォントを設定 */
            margin: 0;
            padding: 0;
            background-color: #f9f9f9; /* 背景色を淡いグレーに */
            position: relative;
        }

        /* メインコンテンツのレイアウト */
        .container {
            display: grid; /* グリッドレイアウトを使用 */
            grid-template-columns: repeat(3, 1fr); /* 3列のレイアウト */
            gap: 30px; /* カード間の余白 */
            padding: 20px;
            max-width: 1200px;
            margin: 20px auto; /* ページの中央に配置 */
            box-sizing: border-box;
        }

        /* メニュー項目を表示するカードのスタイル */
        .card {
            display: flex;
            flex-direction: column; /* 縦方向に並べる */
            align-items: center; /* 中央揃え */
            justify-content: center;
            background-color: #ffffff; /* 背景色を白に */
            border: 1px solid #ccc; /* ボーダーを追加 */
            border-radius: 8px; /* 角を丸くする */
            padding: 20px;
            text-align: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 軽く影をつける */
            text-decoration: none;
            color: #333;
            transition: transform 0.2s, box-shadow 0.2s; /* ホバー時のアニメーション */
        }

        /* カードをホバーしたときの動作 */
        .card:hover {
            transform: translateY(-5px); /* 少し浮き上がる */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* カード内のアイコン画像 */
        .card img {
            width: 60px;
            height: 60px;
            margin-bottom: 10px;
        }

        /* カード内のテキスト */
        .card p {
            margin: 0;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <!-- ヘッダー -->
    <header class="header">
        <!-- ハンバーガーメニューアイコン -->
        <a href="#" class="menu-icon" onclick="toggleMenu()">☰</a>

        <!-- 中央のタイトル -->
        <a href="top.jsp">
            <h1>SchoolOrganizer</h1>
        </a>

        <!-- 右上にユーザー名を表示 -->
        <div class="user-info">
            ようこそ、<%--= userName --%> さん！
        </div>
    </header>

    <!-- ナビゲーションメニュー -->
    <nav class="menu" id="menu">
        <ul>
            <li><a href="Logout">> ログアウト</a></li>
            <li><a href="calendar.jsp">> カレンダー</a></li>
            <li><a href="contact.jsp">> 連絡</a></li>
            <li><a href="collection-list.jsp">> 学用品購入</a></li>
            <li><a href="taion-menu.jsp">> 体温報告</a></li>
            <li><a href="school.jsp">> ご連絡の場合</a></li>
            <li><a href="profile.jsp">> プロフィール設定</a></li>
        </ul>
    </nav>

    <!-- メインコンテンツ（機能選択のカード一覧） -->
    <main class="container">
        <a href="calendar.jsp" class="card">
            <img src="https://via.placeholder.com/60" alt="カレンダー">
            <p>カレンダー</p>
        </a>
        <a href="contact.jsp" class="card">
            <img src="https://via.placeholder.com/60" alt="連絡">
            <p>連絡</p>
        </a>
        <a href="pay-list.jsp" class="card">
            <img src="https://via.placeholder.com/60" alt="集金">
            <p>集金</p>
        </a>
        <a href="taion-menu.jsp" class="card">
            <img src="https://via.placeholder.com/60" alt="体温報告">
            <p>体温報告</p>
        </a>
        <a href="school.jsp" class="card">
            <img src="https://via.placeholder.com/60" alt="ご連絡の場合">
            <p>ご連絡の場合</p>
        </a>
        <a href="profile.jsp" class="card">
            <img src="https://via.placeholder.com/60" alt="プロフィール設定">
            <p>プロフィール設定</p>
        </a>
    </main>

    <!-- JavaScriptでハンバーガーメニューを制御 -->
    <script>
        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active'); // クラスをトグルしてメニューの表示/非表示を切り替え
        }
    </script>

</body>
</html>
