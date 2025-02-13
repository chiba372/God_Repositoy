<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SchoolOrganizer - パスワード変更</title>
</head>
<body>
<form action="ResetPasswordServlet" method="post">
    <input type="hidden" name="token" value="<%= request.getParameter("token") %>">
    <label>新しいパスワード</label>
    <input type="password" name="newPassword" required>
    <button type="submit">変更</button>
</form>

</body>
</html>