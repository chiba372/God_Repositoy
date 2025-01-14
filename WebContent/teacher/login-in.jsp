<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>ログイン</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }

        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }

        .input-container {
            margin: 10px 0;
            text-align: left;
        }

        label {
            display: block;
            font-size: 0.9em;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="password"] {
            padding: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <form action="login" method="post">
            <div class="input-container">
                <label for="login">教員ID</label>
                <input type="text" id="login" name="login" required>
            </div>
            <div class="input-container">
                <label for="password">パスワード</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-container">
                <input type="submit" value="ログイン">
            </div>

            <!-- エラーメッセージを表示 -->
            <c:if test="${not empty errorMessage}">
                <p class="error-message">${errorMessage}</p>
            </c:if>
        </form>
    </div>
</body>
</html>
