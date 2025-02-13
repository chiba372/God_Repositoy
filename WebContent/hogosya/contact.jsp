<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ include file="/WEB-INF/views/header.jsp" %> <!-- ここで共通ヘッダーを読み込む -->
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>連絡</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/header.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .announcement {
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
            cursor: pointer;
        }
        .announcement-title {
            font-size: 18px;
            font-weight: bold;
            margin: 0;
        }
        .announcement-details {
            display: none;
            margin-top: 10px;
            font-size: 16px;
            color: #555;
        }
        .announcement-details.active {
            display: block;
        }
    </style>
</head>
<body>

    <div class="container">
        <%
            // JDBC接続情報
            String url = "jdbc:h2:tcp://localhost/~/javad/teamE/SchoolOrganizer";
            String user = "sa"; // ユーザー名 (デフォルトは 'sa')
            String password = ""; // パスワード (デフォルトは空)

            // データベース接続
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                // JDBCドライバをロード
                Class.forName("org.h2.Driver");

                // データベースに接続
                conn = DriverManager.getConnection(url, user, password);

                // SQLクエリの準備
                String sql = "SELECT DATE, NAME, CONTENT, WHOM FROM CONTACT ORDER BY DATE DESC";
                pstmt = conn.prepareStatement(sql);

                // クエリを実行
                rs = pstmt.executeQuery();

                // データを表示
                while (rs.next()) {
                    String date = rs.getString("DATE");
                    String name = rs.getString("NAME");
                    String content = rs.getString("CONTENT");
                    String whom = rs.getString("WHOM");
        %>
                    <div class="announcement" onclick="toggleDetails(this)">
                        <p class="announcement-title"><%= date %> 「<%= name %>」</p>
                        <div class="announcement-details">
                            <p>対象: <%= whom %></p>
                            <p>内容: <%= content %></p>
                        </div>
                    </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
    </div>

    <script>
        function toggleDetails(element) {
            const details = element.querySelector('.announcement-details');
            details.classList.toggle('active');
        }
    </script>

</body>
</html>
