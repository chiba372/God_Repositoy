<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>体温報告</title>
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
            justify-content: center;
            min-height: 100vh;
        }
        .container {
            flex: 1;
            padding: 20px;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 100%;
            max-width: 1600px;
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
        }
        label {
            font-size: 18px;
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="number"], textarea {
            width: 70%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="checkbox"] {
            width: 20px;
            height: 20px;
            margin-right: 10px;
            vertical-align: middle;
        }
        #note {
            width: 95%;
            height: 150px;
            resize: none;
        }
        .checkbox-group {
            display: flex;
            align-items: center;
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
        <!-- フォーム -->
        <div class="form-wrapper" id="form-container">
            <a href="javascript:history.back()" class="btn-back">戻る</a>
            <h2>体温報告</h2>
            <form id="temperature-form">
                <div class="form-group">
                    <label for="date">日付</label>
                    <input type="text" id="date" name="date" readonly>
                </div>
                <div class="form-group">
                    <label for="temperature">体温</label>
                    <input type="number" id="temperature" name="temperature" step="0.1" required> 度
                </div>
                <div class="form-group checkbox-group">
                    <input type="checkbox" id="absent" name="status" value="absent">
                    <label for="absent">見学する (症状あり)</label>
                </div>
                <div class="form-group">
                    <label for="note">備考 (症状など)</label>
                    <textarea id="note" name="note"></textarea>
                </div>
                <div style="text-align: center;">
                    <button type="submit" class="btn">送信</button>
                </div>
            </form>
        </div>

        <!-- 送信完了メッセージ -->
        <div id="success-message" class="success-message">
            <h1>送信が完了しました！</h1>
            <p>体温報告の送信が完了しました。</p>
            <a href="top.jsp" class="btn">戻る</a>
        </div>
    </main>

    <script>
        // 現在の日付を設定
        document.addEventListener('DOMContentLoaded', () => {
            const dateField = document.getElementById('date');
            const today = new Date();
            const options = { year: 'numeric', month: 'long', day: 'numeric', weekday: 'long' };
            dateField.value = today.toLocaleDateString('ja-JP', options);
        });

        // フォーム送信のハンドリング
        document.getElementById('temperature-form').addEventListener('submit', (event) => {
            event.preventDefault();

            // フォームの内容を確認して送信完了メッセージを表示
            document.getElementById('form-container').style.display = 'none';
            document.getElementById('success-message').style.display = 'block';
        });
    </script>
</body>
</html>
