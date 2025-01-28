<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/menu.jsp">
    <c:param name="title">ログイン</c:param>
    <c:param name="content">
        <form action="login" method="post" class="login-form">
            <div class="form-group">
                <label for="name">教員名</label>
                <input type="text" name="name" id="name" required>
            </div>
            <div class="form-group">
                <label for="password">パスワード</label>
                <input type="password" name="password" id="password" required>
            </div>
            <div class="form-group">
                <input type="submit" value="ログイン">
            </div>
            <p>${ errorMessage }</p>
        </form>
    </c:param>
</c:import>

<style>
    /* フォームの横幅を制限 */
    .login-form {
        width: 100%; /* 親要素の幅を100%に設定 */
        max-width: 400px; /* 最大幅を400pxに設定 */
        margin: 0 auto; /* 中央寄せ */
        padding: 20px;
        box-sizing: border-box;
    }

    /* 各フォームグループ */
    .form-group {
        margin-bottom: 20px; /* 各フォームグループの間にスペースを空ける */
    }

    .form-group label {
        display: block; /* ラベルをブロック要素にして縦に並べる */
        margin-bottom: 5px; /* ラベルと入力フィールドの間にスペースを空ける */
        font-weight: bold; /* ラベルのテキストを太字に */
    }

    .form-group input[type="text"],
    .form-group input[type="password"] {
        width: 100%; /* 入力ボックスを親要素の幅に合わせる */
        padding: 10px; /* 入力ボックス内に余白を加える */
        border: 1px solid #ccc; /* ボーダーを追加 */
        border-radius: 4px; /* 角を丸くする */
        box-sizing: border-box; /* パディングとボーダーを含めて幅を計算 */
    }

    .form-group input[type="submit"] {
        width: 100%; /* ボタンを入力フィールドと同じ幅に */
        padding: 10px;
        background-color: #007BFF;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    .form-group input[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* エラーメッセージのスタイル */
    .error-message {
        color: red;
        margin-top: 10px;
    }
</style>
