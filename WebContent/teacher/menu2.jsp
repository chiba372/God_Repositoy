<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.Teacher" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メニュー</title>
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
    </style>
</head>
<body>
    <!-- ヘッダー -->
    <div class="header">
        <h1>メニュー</h1>
        <div class="user-info">
            <%
                Teacher teacher = (Teacher) session.getAttribute("session_teacher");
                if (teacher != null) {
                    String teacherName = teacher.getName();
                    out.print(teacherName);
            %>
            <a href="/Team-E/logout.jsp">ログアウト</a>
            <%
                }
            %>
        </div>
    </div>

    <!-- ナビゲーションメニュー -->
    <div class="nav-menu">
        <a href="/Team-E/teacher/calendar.jsp">カレンダー</a>
        <a href="/Team-E/teacher/post">連絡</a>
        <a href="/Team-E/teacher/money">集金</a>
        <a href="/Team-E/teacher/temperature">体温一覧</a>
        <a href="/Team-E/teacher/children">児童</a>
    </div>
</body>
</html>
