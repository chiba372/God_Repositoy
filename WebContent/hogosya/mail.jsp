<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>パスワード変更</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f9f9f9;
        }

        .container {
            width: 400px;
            padding: 20px;
            border: 1px solid #000;
            border-radius: 8px;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        label {
            display: block;
            font-size: 16px;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #000;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        input[type="text"].error {
            border-color: red;
        }

        .error-message {
            color: red;
            font-size: 14px;
            margin-top: -15px;
            margin-bottom: 20px;
            display: none;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
        }

        button {
            width: 100px;
            padding: 10px;
            background-color: #add8e6;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            color: #000;
        }

        button:hover {
            background-color: #90c1d4;
        }

        .back-button {
            background-color: #f0f0f0;
        }

        .back-button:hover {
            background-color: #d6d6d6;
        }

        .return-button {
            width: 200px;
            padding: 10px;
            background-color: #add8e6;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            color: #000;
        }

        .return-button:hover {
            background-color: #90c1d4;
        }
    </style>
</head>
<body>
    <div class="container">
    <form action="${pageContext.request.contextPath}/hogosya/mail" method="post">
        <label for="email">メールアドレス</label>
        <input type="text" id="email" name="email" placeholder="example@example.com">
        <p id="error-message" class="error-message">このフィールドを入力してください。</p>
        <div class="buttons">
            <button type="button" class="back-button" onclick="goBack()">戻る</button>
            <button type="submit" class="send-button">送信</button>
        </div>
    </form>
    </div>
    <script>
        function goBack() {
            window.history.back();
        }

        function sendEmail() {
            const emailInput = document.getElementById('email');
            const errorMessage = document.getElementById('error-message');

            if (emailInput.value.trim() === '') {
                emailInput.classList.add('error');
                errorMessage.style.display = 'block';
            } else {
                emailInput.classList.remove('error');
                errorMessage.style.display = 'none';
                document.body.innerHTML = `<div style='text-align: center; padding: 50px;'>
                    <h1>メール送信完了</h1>
                    <p>メールのURLからパスワード変更を行ってください。</p>
                    <button class='return-button' onclick='window.location.reload()'>ログインへ戻る</button>
                </div>`;
            }
        }
    </script>
</body>
</html>


