<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<title>ご連絡の場合</title>


<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SchoolOrganizer</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f8f8f8;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .info {
            margin-top: 10px;
            padding: 10px;
            background: #eef;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>ご連絡の場合</h1>
        <div class="info">
            <p><strong>学校名：</strong>○○小学校</p>
            <p><strong>住所：</strong>〒123-4567 東京都〇〇区〇〇町1-2-3</p>
            <p><strong>電話番号：</strong>03-1234-5678</p>
            <p><strong>FAX：</strong>03-1234-5679</p>
            <p><strong>メール：</strong>info@example-school.jp</p>
        </div>
        <div class="info">
            <h3>お問い合わせ時間</h3>
            <p>平日 8:30 ～ 17:00</p>
            <p>※ 土日・祝日はお休みです。</p>
        </div>
        <div class="info">
            <h3>緊急時の連絡について</h3>
            <p>学校閉鎖時や災害時の緊急連絡は、保護者の方へメールまたは学校公式ウェブサイトでお知らせします。</p>
        </div>
    </div>
</body>
</html>
