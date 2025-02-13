<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カレンダー</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
	<style>
	    body {
	        font-family: Arial, sans-serif;
	        margin: 0;
	        padding: 0;
	        background-color: #f9f9f9;
	    }

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

	    th, td {
	        border: 1px solid #ccc;
	        padding: 5px; /* 余白を小さく設定 */
	        text-align: left; /* 左寄せ */
	        vertical-align: top; /* 上寄せ */
	        height: 60px; /* セルの高さを統一 */
	        width: 14.28%; /* カレンダー全体の幅を均等にする */
	        box-sizing: border-box; /* パディングを含めて幅を計算 */
	    }

	    th {
	        background-color: #f0f0f0;
	    }

	    .event {
	        background-color: #ffffcc;
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
	</style>

</head>
<body>

    <div class="calendar-container">
        <div class="calendar-navigation">
            <a href="#" onclick="previousMonth()">> 戻る</a>
            <h2 id="calendar-title">2025年1月</h2>
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
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>6<br><span class="event">運動会</span></td>
                        <td>7</td>
                        <td>8</td>
                        <td>9</td>
                        <td>10</td>
                        <td>11</td>
                    </tr>
                    <tr>
                        <td>12</td>
                        <td>13</td>
                        <td>14</td>
                        <td>15</td>
                        <td>16</td>
                        <td>17</td>
                        <td>18</td>
                    </tr>
                    <tr>
                        <td>19</td>
                        <td>20</td>
                        <td>21</td>
                        <td>22</td>
                        <td>23</td>
                        <td>24</td>
                        <td>25</td>
                    </tr>
                    <tr>
                        <td>26</td>
                        <td>27</td>
                        <td>28</td>
                        <td>29</td>
                        <td>30</td>
                        <td>31</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <script>
        let today = new Date();
        let currentYear = today.getFullYear();
        let currentMonth = today.getMonth() + 1; // 月は0始まりなので+1

        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active');
        }

        function updateCalendar(year, month) {
            const title = document.getElementById('calendar-title');
            const tableBody = document.querySelector('#calendar-table tbody');

            // デバッグログで確認??
            console.log(`Year: ${year}, Month: ${month}`);

            // 月のタイトル更新
            title.textContent = `${year}年${month}月`;

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
                        cell.textContent = day;
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
    </script>
</body>
</html>
