<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="bean.Clerk" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>事務職員メニュー</title>
    <style>
    	/* 全体の基本スタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* ヘッダーのデザイン */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: #f4f4f4;
            border-bottom: 1px solid #ddd;
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
        }
        .status {
        	text-align: right;
        	margin-left: 650px;
        	font-weight: bold;
        }
    </style>
</head>
<body>
	<div class="header">
        <h1>事務員</h1>
        <%
        	HttpSession sessionObj = request.getSession(false);
      		Object userObj = (sessionObj != null) ? sessionObj.getAttribute("loginUser") : null;
        	Clerk loginUser = (userObj instanceof Clerk) ? (Clerk) userObj : null;
        %>
        <%
        	if (loginUser != null) {
        %>
        	<p class="status">
        		ようこそ<%= loginUser.getName() %>さん。
        	</p>
			<form>
				<a href="./logout">ログアウトする</a>
	    	</form>
	    <%
        	} else {
	    %>
	    	<p class="status">現在ログインしていません。</p>
	    	<a href="./../login">ログイン画面へ</a>
	    <%
        	}
	    %>
    </div>
</body>
</html>