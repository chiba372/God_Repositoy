<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
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
        .login-container {
            width: 400px;
            padding: 20px;
            border: 1px solid #000;
            border-radius: 8px;
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .login-container h1 {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
            position: relative;
        }
        .form-group label {
            display: block;
            font-size: 16px;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #000;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }
        .form-group a {
            display: block;
            margin-top: 5px;
            font-size: 14px;
            color: #007bff;
            text-decoration: none;
            text-align: right;
        }
        .form-group a:hover {
            text-decoration: underline;
        }
        .toggle-password {
            position: absolute;
            right: 10px;
            top: 38px;
            background: none;
            border: none;
            cursor: pointer;
            font-size: 14px;
        }
        .login-button {
            width: 100%;
            padding: 10px;
            background-color: #add8e6;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            color: #000;
        }
        .login-button:hover {
            background-color: #90c1d4;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>ログイン</h1>
        <form action="dashboard.html" method="post">
            <div class="form-group">
                <label for="student-id">学生番号</label>
                <input type="text" id="student-id" name="student-id" placeholder="0123456" required>
            </div>
            <div class="form-group">
                <label for="password">パスワード</label>
                <input type="password" id="password" name="password" placeholder="" required>
                <button type="button" class="toggle-password" onclick="togglePassword()">表示</button>
            </div>
            <div class="form-group">
                <a href="forgot-password.html">パスワードを忘れた場合はこちら</a>
            </div>
            <button type="submit" class="login-button">ログイン</button>
        </form>
    </div>
    <script>
        function togglePassword() {
            const passwordInput = document.getElementById('password');
            const toggleButton = document.querySelector('.toggle-password');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleButton.textContent = '非表示';
            } else {
                passwordInput.type = 'password';
                toggleButton.textContent = '表示';
            }
        }
    </script>
</body>
</html>
