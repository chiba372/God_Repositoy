<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>カレンダー</title>
	<style>
	    body {
	        font-family: Arial, sans-serif;
	        margin: 0;
	        padding: 0;
	        background-color: #f9f9f9;
	    }

	    .header {
	        width: 100%;
	        max-width: 1600px;
	        background-color: #ffffff;
	        display: flex;
	        align-items: center;
	        justify-content: space-between;
	        padding: 20px 40px;
	        border-bottom: 1px solid #ccc;
	        box-sizing: border-box;
	        position: relative;
	        z-index: 2;
	    }

	    .header a {
	        text-decoration: none;
	        color: #333;
	        font-size: 28px;
	        cursor: pointer;
	        transition: color 0.2s;
	    }

	    .header a:hover {
	        color: #007bff;
	    }

	    .header h1 {
	        margin: 0;
	        font-size: 32px;
	    }

	    .menu {
	        display: none;
	        position: absolute;
	        top: 80px;
	        left: 0;
	        width: 100%;
	        background-color: #ffffff;
	        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	        z-index: 1;
	    }

	    .menu.active {
	        display: block;
	    }

	    .menu ul {
	        list-style: none;
	        margin: 0;
	        padding: 0;
	    }

	    .menu ul li {
	        padding: 15px 20px;
	        border-bottom: 1px solid #ccc;
	    }

	    .menu ul li a {
	        text-decoration: none;
	        color: #333;
	        font-size: 18px;
	        transition: color 0.2s;
	    }

	    .menu ul li a:hover {
	        color: #007bff;
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
    <header class="header">
        <!-- ハンバーガーメニュー -->
        <a href="#" class="menu-icon" onclick="toggleMenu()">☰</a>

        <!-- 中央のタイトル -->
        <a href="home.html">
            <h1>SchoolOrganizer</h1>
        </a>

        <!-- 右上の扉アイコン -->
        <a href="logout.html" class="logout-icon">🚪</a>
    </header>
