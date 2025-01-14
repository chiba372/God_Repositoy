<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/menu.jsp">

	<c:param name="title">児童一覧</c:param>

	<c:param name="content">

	<tt>児童</tt>

		<table border=1>
			<tr>
				<th>学番</th>
				<th>出席番号</th>
				<th>名前</th>
			</tr>
			<c:forEach var="student" items="${ students }">
				<tr>
					<td>${ student.student_id }</td>
					<td>${ student.student_name }</td>
					<td>${ student.course_name }コース</td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer">
        <button onclick="location.href='home.jsp'">戻る</button>
    </div>

	</c:param>

</c:import>