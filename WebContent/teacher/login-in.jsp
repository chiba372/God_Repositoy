<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/menu.jsp">
    <c:param name="title">ログイン</c:param>
    <c:param name="content">
        <form action="login" method="post" class="login-form">
            <div class="form-group">
                <label for="name">idを入力:</label>
                <input type="text" id="name" name="id" required>
            </div>
            <div class="form-group">
                <label for="password">パスワードを入力:</label>
                <input type="password" name="password" id="password" required>
            </div>
            <div class="form-group">
                <label for="chk_d_ps">
                    <input type="checkbox" id="chk_d_ps" onclick="togglePasswordVisibility()">
                    パスワードを表示
                </label>
            </div>
            <div class="form-group">
                <input type="submit" value="ログイン">
            </div>
            <p class="error-message">${ errorMessage }</p>
        </form>
    </c:param>
</c:import>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #fff;
    }
    .login-form {
        width: 100%;
        max-width: 400px;
        margin: 100px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        box-sizing: border-box;
    }
    .form-group {
        margin-bottom: 20px;
    }
    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    .form-group input[type="text"],
    .form-group input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .form-group input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    .form-group input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .error-message {
        color: red;
        text-align: center;
        margin-top: 10px;
    }
</style>

<script>
    function togglePasswordVisibility() {
        var passwordField = document.getElementById("password");
        var checkbox = document.getElementById("chk_d_ps");
        if (checkbox.checked) {
            passwordField.type = "text";  // パスワードを表示
        } else {
            passwordField.type = "password";  // パスワードを非表示
        }
    }
</script>
