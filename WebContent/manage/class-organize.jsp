<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/manage-menu.jsp">

<c:param name="title">クラス</c:param>

<c:param name="content">
<style>
	.table_box{
	  overflow-y: auto;
	  -webkit-overflow-scrolling: touch;
	}
	table {
	  border-collapse: collapse;
	  border-spacing: 0;
	  width: 100%;
	}
	th, td {
	  vertical-align: middle;
	  padding: 20px;
	  border: 1px solid #000;
	  color: #000;
	  font-size: 14px;
	  text-align: center;
	  white-space: nowrap;
	}
	th {
	  background: #000;
	}
	td {
	  background: #fff;
	}
	.sticky {
	  position: sticky;
	  top: 0;
	  left: 0;
	  border-top: none;
	}
	.sticky::before {
	  content: "";
	  position: absolute;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  border-top: 1px solid #000;
	  border-bottom: 1px solid #000;
	  background: #ccc;
	  z-index: -1;
	}
</style>

<div style="display:flex; justify-content:space-between;">
	<h1>${grade}年生の先生</h1>
</div>

<form action="class-organize" method="post">
	<div style="display:flex; justify-content:space-around;">
		<h2>担任の設定</h2>
		<input type="hidden" name="number" value="${number}">

		<c:forEach begin="1" end="${number}" varStatus="i">
		<div>
			<label>${i.count}組</label>

			<select name="teacher" style="width:10em; height:4em;">
				<c:forEach var="p" items="${tlist}">
				<option value="${p.id}">${p.name}</option>
				</c:forEach>
			</select>

		</div>
		</c:forEach>

	</div>

	<div>
		<h2>児童の設定</h2>
		<div class="table_box">
		<table>
			<tr>
				<th class="sticky">ID</th>
				<th class="sticky">名前</th>
				<c:forEach begin="1" end="${number}" varStatus="i">
				<th class="sticky">${i.count}組</th>
				</c:forEach>
				<th class="sticky">在籍無し</th>
			</tr>

			<c:forEach var="p" items="${slist}" varStatus="status">
			<tr>
				<td>${p.id}<input type="hidden" name="student" value="${p.id}"></td>
				<td>${p.name}</td>

				<c:forEach begin="1" end="${number}" varStatus="i">
				<td><input type="radio" name="class_no[${status.index}]" value="${i.count}" style="transform: scale(2.5);"></td>
				</c:forEach>
				<td><input type="radio" name="class_no[${status.index}]" value="0" style="transform: scale(2.5);"></td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</div>

	<input type="submit" value="送信" style="width:10em; height:4em;">
</form>



</c:param>

</c:import>