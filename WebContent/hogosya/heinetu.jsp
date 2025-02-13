<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>  <!-- JDBCを使用するためのインポート -->
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>平熱設定</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
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

    <main class="container">
        <!-- 平熱設定フォーム -->
        <div class="form-wrapper" id="form-container">
            <a href="javascript:history.back()" class="btn-back">戻る</a>
            <h2>平熱設定</h2>

            <!-- フォーム -->
            <form id="normal-temperature-form" action="<%= request.getContextPath() %>/heinetu-save" method="post">
                <div class="form-group">
                    <label for="normal-temperature">平熱</label>
                    <input type="number" id="normal-temperature" name="normal-temperature" step="0.1" required> 度
                </div>
                <div style="text-align: center;">
                    <button type="submit" class="btn">保存</button>
                </div>
            </form>

            <!-- エラーメッセージ表示 -->
            <% if (request.getParameter("error") != null) { %>
                <p class="error-message">保存に失敗しました。もう一度お試しください。</p>
            <% } %>

            <!-- 成功メッセージ表示 -->
            <% if ("true".equals(request.getParameter("success"))) { %>
                <p class="success-message">平熱が保存されました。</p>
            <% } %>
        </div>
    </main>

	<!-- これいるのかな？ -->
    <script>
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
