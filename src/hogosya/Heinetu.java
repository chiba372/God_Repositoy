package hogosya;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/heinetu-save")
public class Heinetu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // セッションから student_id を取得
        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("studentId"); // セッションに studentId があることを想定

        if (studentId == null) {
            response.sendRedirect("login.jsp"); // セッション切れの場合はログイン画面へ
            return;
        }

        // フォームから平熱を取得
        String normalTempStr = request.getParameter("normal-temperature");
        if (normalTempStr == null || normalTempStr.isEmpty()) {
            response.sendRedirect("heinetu.jsp?error=invalid");
            return;
        }

        double normalTemp = Double.parseDouble(normalTempStr);

        // データベース接続情報（適宜変更してください）
        String jdbcUrl = "jdbc:h2:tcp://localhost/~/javad/teamE/SchoolOrganizer";
        String dbUser = "";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // SQL文を準備
            String sql = "UPDATE HEALTH SET NORMAL_TEMP = ? WHERE STUDENT_ID = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, normalTemp);
                stmt.setString(2, studentId);

                int rowsUpdated = stmt.executeUpdate();

                if (rowsUpdated == 0) {
                    // データがない場合は新規挿入
                    sql = "INSERT INTO HEALTH (STUDENT_ID, DATE, NORMAL_TEMP) VALUES (?, CURDATE(), ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                        insertStmt.setString(1, studentId);
                        insertStmt.setDouble(2, normalTemp);
                        insertStmt.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("heinetu.jsp?error=db");
            return;
        }

        // 成功時にリダイレクト
        response.sendRedirect("heinetu.jsp?success=true");
    }
}
