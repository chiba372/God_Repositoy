<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/manage-menu.jsp">

<c:param name="title">クラス一覧</c:param>

<c:param name="content">
<div style="display:flex; justify-content:space-between;">
	<h1>どの学年を編集しますか</h1>
</div>

<c:forEach begin="1" end="6" varStatus="i">
<div style="display:inline-block; width:250px; height:100px;
	margin:15px 20px; padding:10px; margin-bottom:10px; border:1px solid #333333; border-radius:10px;">
	<h4 style="margin:30px">${i.count}年生</h4>
	<form action="class-select" method="post">
		<input type="hidden" name="grade" value="${i.count}">
		<input type="submit" value="編集" >
	</form>
</div>
</c:forEach>

</c:param>

</c:import>