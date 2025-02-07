<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/manage-menu.jsp">

<c:param name="title">クラス</c:param>

<c:param name="content">
<div style="display:flex; justify-content:space-between;">
	<h1>クラス一覧</h1>

	<button onclick="location.href='/Team-E/manage/class-select'" style="width:10em; height:4em;">クラス編集</button>
</div>

<div>
	<c:forEach var="list" items="${lists}" varStatus="i">
	<div style="display:inline-block; width:250px;
		margin:15px 20px; padding:10px; margin-bottom:10px; border:1px solid #333333; border-radius:10px;">
		<h4 style="margin:30px">${i.count}年生</h4>

		<c:forEach var="s" items="${list}">
			<p>${s.class_no}組 ${s.name}</p>
		</c:forEach>

	</div>
	</c:forEach>
</div>
</c:param>

</c:import>