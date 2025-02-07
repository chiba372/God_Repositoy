<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="index.jsp">

<c:param name="title">クラス</c:param>

<c:param name="content">
<div style="display:flex; justify-content:space-between;">
	<h1>クラス一覧</h1>

	<button onclick="location.href='/Team-E/manage/class-select'" style="width:10em; height:4em;">クラス編集</button>
</div>

<div>
	<c:forEach begin="1" end="6" varStatus="i">
	<div style="display:inline-block; width:250px; height:350px;
		margin:15px 20px; padding:10px; margin-bottom:10px; border:1px solid #333333; border-radius:10px;">
		<h4 style="margin:30px">${i.count}年生</h4>

		<c:forEach begin="1" end="4" varStatus="n">
		<c:forEach var="p" items="${list}">
		<c:if test="${p.class_no == n.count}">
		<div style="height:50px;;">${p.class_no}組　${p.name}</div>
		</c:if>
		</c:forEach>
		</c:forEach>

	</div>
	</c:forEach>
</div>
</c:param>

</c:import>