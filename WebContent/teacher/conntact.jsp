<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/menu.jsp">

<c:param name="title">連絡一覧</c:param>

   <c:param name="content">

   <tt>連絡一覧</tt>
   <tt>投稿</tt>

		 <table border=1>

			<c:forEach var="student" items="${ students }">
				<tr>
					<td>運動会</td>
				</tr>
				<tt>編集</tt>
				<tt>削除</tt>

			</c:forEach>
		</table>
		<div class="footer">
        <button onclick="location.href='home.jsp'">戻る</button>
    </div>

	</c:param>

</c:import>