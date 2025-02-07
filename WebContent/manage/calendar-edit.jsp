<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="index.jsp">

<c:param name="title">イベント追加</c:param>

<c:param name="content">
<div style="display:flex; justify-content:space-between;">
	<h1>イベント追加</h1>
</div>

<h2>${year}年${month}月${day}日</h2>

<style>
	th,td {
	    border: solid 1px;  /* 枠線指定 */
	    padding: 10px;      /* 余白指定 */
	    background-color:  #ddd;    /* 背景色指定 */

	}

	table {
	    border-collapse:  collapse; /* セルの線を重ねる */
	}
</style>

<form action="calendar-edit" method="post">
	<input type="hidden" name="year" value="${year}">
	<input type="hidden" name="month" value="${month}">
	<input type="hidden" name="day" value="${day}">

	<div>
		<table id="tbl" style="width:100%;border-collapse:separate;border-spacing:20px;">
			<tr>
				<th>イベントID</th>
				<th>イベント名</th>
				<th>内容</th>
			</tr>

			<c:forEach var="p" items="${list}" varStatus="status">
			<tr>
				<td><input type="text" name="id" value="${p.id}"></td>
				<td><input type="text" name="name" value="${p.name}"></td>
				<td><input type="text" name="content" value="${p.content}"></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<input type="submit" value="登録">
</form>

<button onclick="add()" style="display:flex; padding:10px 20px;">+</button>

<script>
var tbl = document.getElementById('tbl');

function add(){
	//追加する要素を作成
	var tr = document.createElement('tr');
	tr.innerHTML = `
		<td><input type="text" name="id"></td>
		<td><input type="text" name="name"></td>
		<td><input type="text" name="content"></td>
	`;

	//末尾に追加
	tbl.appendChild(tr);
}
</script>

</c:param>

</c:import>