<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- 共通ヘッダーを読み込む -->
<%@ page import="bean.Student" %>

<%--
    // セッションからユーザー情報を取得
    Student student = (Student) session.getAttribute("session_student");
    String studentName = (student != null) ? student.getName() : "ゲスト";
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

    <!-- ヘッダー部分 -->
    <!-- <div class="header">
        <p>ようこそ <strong><%-- = studentName --%></strong> さん！</p>
    </div>
     -->

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
        <a href="<%= request.getContextPath() %>/catalog" class="card">
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
    </main>

</body>
</html>
