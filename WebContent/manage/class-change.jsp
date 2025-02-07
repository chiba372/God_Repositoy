<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/manage-menu.jsp">

<c:param name="title">クラス</c:param>

<c:param name="content">
	<h1><span style="color:red;">${grade}年生</span>の編成をします</h1>

	<h3>現在<span style="color:red;">${number}クラス</span>の存在します</h3>
	<p>クラス数を選択してください</p>
	<form action="class-change" method="post">
		<input type="hidden" name="grade" value="${grade}">
		<input type="number" name="number" required="required" min="1" max="99" style="transform: scale(2.5);">

		<%--
		<select name="number" style="transform: scale(2.5);">
			<option value="1">１</option>
			<option value="2">２</option>
			<option value="3">３</option>
			<option value="4">４</option>
		</select>
		--%>

		<div style="margin:15px 20px; padding:10px;">
			<input type="submit" value="次へ" style="width:10em; height:4em;">
		</div>
	</form>

	<button onclick="location.href='class-select'" style="width:10em; height:4em;">学年選択へ</button>
</c:param>

</c:import>