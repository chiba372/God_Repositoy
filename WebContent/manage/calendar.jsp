<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="manageIndex.jsp">

<c:param name="title">追加</c:param>

<c:param name="content">
<div style="display:flex; justify-content:space-between;">
	<h1>カレンダー</h1>
</div>
<style>
	.calendar-container {
		padding: 20px;
		max-width: 1200px;
		margin: 0 auto;
	}

	.calendar-navigation {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin-bottom: 10px;
	}

	.calendar-navigation a {
		text-decoration: none;
		font-size: 18px;
		color: #007bff;
		cursor: pointer;
	}

	.calendar-navigation a:hover {
		text-decoration: underline;
	}

	table {
		width: 100%;
		border-collapse: collapse; /* セル間の隙間をなくす */
		table-layout: fixed; /* セル幅を均等に固定 */
		margin-top: 20px;
	}

	th {
		background-color: #f0f0f0;
		text-align: center; /* 中央揃え */
		vertical-align: middle; /* 縦方向も中央揃え */
		padding: 10px;
	}

	td {
		border: 1px solid #ccc;
		padding: 5px; /* 余白を小さく設定 */
		text-align: left; /* 左寄せ */
		vertical-align: top; /* 上寄せ */
		height: 60px; /* セルの高さを統一 */
		width: 14.28%; /* カレンダー全体の幅を均等にする */
		box-sizing: border-box; /* パディングを含めて幅を計算 */
	}

	.scrollable {
		max-height: 400px;
		overflow-y: auto;
	}

	.modal {
	  display: none;
	  position: fixed;
	  z-index: 1;
	  left: 0;
	  top: 0;
	  height: 100%;
	  width: 100%;
	  overflow: auto;
	  background-color: rgba(0,0,0,0.5);
	}

	.modal-content {
	  background-color: #f4f4f4;
	  margin: 20% auto;
	  width: 50%;
	  box-shadow: 0 5px 8px 0 rgba(0,0,0,0.2),0 7px 20px 0 rgba(0,0,0,0.17);
	  animation-name: modalopen;
	  animation-duration: 1s;
	}

	@keyframes modalopen {
	  from {opacity: 0}
	  to {opacity: 1}
	}

	.modal-header h1 {
	  margin: 1rem 0;
	}

	.modal-header {
	  background: lightblue;
	  padding: 3px 15px;
	  display: flex;
	  justify-content: space-between;
	}

	.modalClose {
	  font-size: 2rem;
	}

	.modalClose:hover {
	  cursor: pointer;
	}

	.modal-body {
	  padding: 10px 20px;
	  color: black;
	}
</style>


<div class="calendar-container">
	<div class="calendar-navigation">
		<a href="#" onclick="previousMonth()">> 戻る</a>
		<h2 id="calendar-title">スクリプトエラー</h2>
		<a href="#" onclick="nextMonth()">➤ 翌月</a>
	</div>

	<div class="scrollable">
		<table id="calendar-table">
			<thead>
				<tr>
					<th>日</th>
					<th>月</th>
					<th>火</th>
					<th>水</th>
					<th>木</th>
					<th>金</th>
					<th>土</th>
				</tr>
			</thead>
			<tbody>
				<%-- Javascriptで動的に追加 --%>
			</tbody>
		</table>
	</div>
</div>

<div id="easyModal" class="modal">
	<div class="modal-content">
		<div class="modal-header">
			<h1 id="modalTitle"></h1>
			<span class="modalClose" onClick="modalClose()">×</span>
		</div>
		<div class="modal-body">

			<p>
			<c:forEach var="e" items="${list}">
				<h2>${e.name}</h2>
				<p>${e.content}</p>
			</c:forEach>
			</p>
			<form action="calendar" method="post">
				<input type="hidden" name="year" value="${year}">
				<input type="hidden" name="month" value="${month}">
				<input type="hidden" name="day" value="${day}">

				<input type="submit" value="イベント追加">
			</form>
		</div>
	</div>
</div>

<script>
	// URLパラメータ取得
	let params = new URLSearchParams(document.location.search);
	let currentYear = params.get("year")
	let currentMonth = params.get("month")
	let day = params.get("day")

	var monthList = "<%= request.getAttribute("monthList") %>";
	console.log(monthList);


	// カレンダー関連初期化
	let today = new Date();
	if (currentYear == null) {
		currentYear = today.getFullYear();
	}
	if (currentMonth == null) {
		currentMonth = today.getMonth() + 1; // 月は0始まりなので+1
	}

	// モーダルウィンドウ関連初期化
	var buttonOpen = document.getElementById('modalOpen');
	var modal = document.getElementById('easyModal');
	var modaltitle = document.getElementById('modalTitle');
	var buttonClose = document.getElementsByClassName('modalClose')[0];


	// カレンダー更新
	function updateCalendar(year, month) {
		const title = document.getElementById('calendar-title');
		const tableBody = document.querySelector('#calendar-table tbody');

		// 月のタイトル更新
		title.textContent = currentYear+'年'+currentMonth+'月';

		// カレンダー生成
		const firstDay = new Date(year, month - 1, 1).getDay();
		const daysInMonth = new Date(year, month, 0).getDate();

		let day = 1;
		tableBody.innerHTML = '';

		for (let i = 0; i < 6; i++) {
			const row = document.createElement('tr');

			for (let j = 0; j < 7; j++) {
				const cell = document.createElement('td');

				if (i === 0 && j < firstDay) {
					cell.textContent = '';
				} else if (day > daysInMonth) {
					cell.textContent = '';
				} else {
					var td = '';
					td += '<a style="font-size: 150%;" href="/Team-E/manage/calendar';
					td += '?year='+currentYear+'&month='+currentMonth+'&day='+day+'">'+day+'</a>';
					cell.innerHTML = td;

				    day++;
				}
				row.appendChild(cell);
			}
			tableBody.appendChild(row);

			if (day > daysInMonth) {
				break;
			}
		}
	}



	function previousMonth() {
	    currentMonth--;
	    if (currentMonth === 0) {
	        currentMonth = 12;
	        currentYear--;
	    }
	    updateCalendar(currentYear, currentMonth);
	}

	function nextMonth() {
		currentMonth++;
		if (currentMonth === 13) {
			currentMonth = 1;
			currentYear++;
		}
		updateCalendar(currentYear, currentMonth);
	}

	// 初期カレンダー表示
	updateCalendar(currentYear, currentMonth);

	// ボタンがクリックされた時
	function modalOpen(day) {
		modaltitle.textContent =currentMonth+"月"+day+"日";
		modal.style.display = 'block';
	}

	if (day != null) {
		modalOpen(day)
	}

	// バツ印がクリックされた時
	function modalClose() {
		modal.style.display = 'none';
	}

	// モーダルコンテンツ以外がクリックされた時
	addEventListener('click', outsideClose);
	function outsideClose(e) {
	  if (e.target == modal) {
	    modal.style.display = 'none';
	  }
	}


</script>
</c:param>

</c:import>