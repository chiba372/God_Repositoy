<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="index.jsp">

<c:param name="title">教員管理</c:param>

<c:param name="content">
<div style="display:flex; justify-content:space-between;">
	<h1>教員管理</h1>
</div>

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

<form action="teacher-manage" method="post">
<div>
	<table id="tbl" style="width:100%;border-collapse:separate;border-spacing:20px;">
		<tr>
			<th>氏名</th>
			<th>教員ID</th>
			<th>PASS</th>
			<th>管理アクセス権限</th>
		</tr>

		<c:forEach var="p" items="${list}" varStatus="status">
		<tr>
			<td><input type="text" name="name" value="${p.name}"></td>
			<td><input type="text" name="id" value="${p.id}"></td>
			<td><input type="text" name="password" value="${p.password}"></td>
			<td><input type="checkbox" name="manager[${status.index}]" value=True
				<c:if test="${p.is_master}">checked</c:if> style="transform: scale(2.5);"></td>
		</tr>
		</c:forEach>
	</table>
</div>

<input type="submit" value="保存" style="width:10em; height:4em;">
</form>
<button onclick="add()" style="display:flex; padding:10px 20px;">+</button>

<script>
var tbl = document.getElementById('tbl');

function add(){
	//追加する要素を作成
	var tr = document.createElement('tr');
	tr.innerHTML = `
		<td><input type="text" name="name"></td>
		<td><input type="text" name="id"></td>
		<td><input type="text" name="password"></td>
		<td><input type="checkbox" name="manager" value=True style="transform: scale(2.5);"></td>
	`;

	//末尾に追加
	tbl.appendChild(tr);
}
</script>


</c:param>

</c:import>