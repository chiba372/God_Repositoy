<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/header.css">
<header class="header">

    <!-- ハンバーガーメニュー -->
    <a href="#" class="menu-icon" onclick="toggleMenu()">☰</a>

    <!-- 中央のタイトル -->
    <a href="top.jsp">
        <h1>SchoolOrganizer</h1>
    </a>

    <!-- 右上の扉アイコン -->
    <a href="" class="logout-icon">🚪</a>

</header>

<!-- メニュー -->
<nav class="menu" id="menu">
    <ul>
        <li><a href="">> ログアウト</a></li>
        <li><a href="calendar.jsp">> カレンダー</a></li>
        <li><a href="contact.jsp">> 連絡</a></li>
        <li><a href="<%= request.getContextPath() %>/catalog">> 集金</a></li>
        <li><a href="taion-menu.jsp">> 体温報告</a></li>
        <li><a href="school.jsp">> ご連絡の場合</a></li>
    </ul>
</nav>

<script>
    function toggleMenu() {
        const menu = document.getElementById('menu');
        menu.classList.toggle('active');
    }
</script>
