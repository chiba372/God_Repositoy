<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/menu.jsp">

	<c:param name="title">児童一覧</c:param>

	<c:param name="content">

	<tt></tt>

		<table border=1>
			<tr>
				<th>完了</th>
			</tr>
			<c:forEach var="student" items="${ students }">
				<tr>
					<td>${ student.student_name }</td>
				</tr>
			</c:forEach>
		</table>
			<table border=2>
			<tr>
				<th>未完了</th>
			</tr>
		<c:forEach var="student" items="${ students }">
				<tr><td>${ student.student_name }</td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
        <button onclick="location.href='home.jsp'">戻る</button>
    </div>

	</c:param>

</c:import>