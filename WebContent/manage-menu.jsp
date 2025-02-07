<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>管理メニュー</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
			box-sizing: border-box;
		}
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
		.user-info {
			display: flex;
			align-items: center;
		}
		.nav-menu {
			display: flex;
			width: 100%;
			margin: 20px 0;
		}
		.nav-menu a {
			display: block;
			padding: 15px;
			text-decoration: none;
			color: #333;
			border: 1px solid #ddd;
			margin: 0;
			text-align: center;
			width: 100%;
			box-sizing: border-box;
		}
		.nav-menu a:hover {
			background-color: #f0f0f0;
		}
		.content {
			padding: 20px;
			text-align: center;
			max-width: 8000px;
			margin: 0 auto;
		}
		.footer {
			display: flex;
			justify-content: flex-start;
			align-items: center;
			padding: 20px;
			background-color: #f8f9fa;
		}
		.footer button {
			padding: 10px 20px;
			border: 1px solid #ccc;
			background-color: #ffffff;
			cursor: pointer;
			border-radius: 4px;
		}
		.footer button:hover {
			background-color: #e2e6ea;
		}
		.login-btn {
			padding: 10px 20px;
			background-color: #007bff;
			color: white;
			border: none;
			cursor: pointer;
			border-radius: 4px;
		}
		.login-btn:hover {
			background-color: #0056b3;
		}
	</style>
</head>

<body>

    <div class="header">
        <h1>管理メニュー</h1>
                <a href="/Team-E/teacher/post" class="login-btn">教員メニューへ</a>
	</div>

	<div class="nav-menu">
		<a href="/Team-E/manage/calendar">カレンダー</a>
		<a href="/Team-E/manage/class-list">クラス</a>
		<a href="/Team-E/manage/teacher-manage">先生</a>
	</div>

	<div class="content">
		<p>${ param.content }</p>
	</div>


</body>
</html>
