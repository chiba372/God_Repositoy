<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.Teacher" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カレンダー</title>
    <style>
        /* 全体の基本スタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-color: #f9f9f9;
        }

        /* ヘッダーのデザイン */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 30px;
            background-color: #f4f4f4;
            border-bottom: 1px solid #ddd;
        }
        .header h1 {
            margin: 0;
            font-size: 24px;
        }
        .user-info {
            display: flex;
            align-items: center;
        }

        /* ナビゲーションメニュー */
        .nav-menu {
            display: flex;
            width: 100%;
            margin: 20px 0;
        }
        .nav-menu a {
            display: block;
            padding: 15px;
            text-decoration: none;
            color: #333;
            border: 1px solid #ddd;
            text-align: center;
            width: 100%;
            box-sizing: border-box;
        }
        .nav-menu a:hover {
            background-color: #f0f0f0;
        }

        /* メインコンテンツエリア */
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
            border-collapse: collapse;
            table-layout: fixed;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 5px;
            text-align: left;
            vertical-align: top;
            height: 60px;
            width: 14.28%;
            box-sizing: border-box;
        }

        th {
            background-color: #f0f0f0;
            text-align: center;
            vertical-align: middle;
            padding: 10px;
        }

        td {
            text-align: left;
            vertical-align: top;
        }

        .scrollable {
            max-height: 400px;
            overflow-y: auto;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>カレンダー</h1>
        <div class="user-info">
            <%
                Teacher teacher = (Teacher) session.getAttribute("session_teacher");
                if (teacher != null) {
                    String teacherName = teacher.getName();
                    out.print(teacherName);
            %>
            <a href="/Team-E/logout.jsp">ログアウト</a>
            <%
                }
            %>
        </div>
    </div>

    <div class="nav-menu">
        <a href="/Team-E/teacher/calendar.jsp">カレンダー</a>
        <a href="/Team-E/teacher/post">連絡</a>
        <a href="/Team-E/teacher/money">集金</a>
        <a href="/Team-E/teacher/temperature">体温</a>
        <a href="/Team-E/teacher/children">児童</a>
    </div>

    <div class="calendar-container">
        <div class="calendar-navigation">
            <a href="#" onclick="previousMonth()">&lt; 戻る</a>
            <h2 id="calendar-title">2025年1月</h2>
            <a href="#" onclick="nextMonth()">翌月 &gt;</a>
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
        let currentMonth = today.getMonth() + 1;

        function updateCalendar(year, month) {
            const title = document.getElementById('calendar-title');
            const tableBody = document.querySelector('#calendar-table tbody');

            title.textContent = ${year}年${month}月;

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

        updateCalendar(currentYear, currentMonth);
    </script>
</body>
</html>