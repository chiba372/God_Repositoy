package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentClass;
import bean.Teacher;
import dao.CatalogDAO;
import dao.Student_ClassDAO;

@WebServlet(urlPatterns = { "/teacher/money" })
public class Allmoney extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        try {
            // セッションからログイン者情報を取得
            HttpSession session = req.getSession();
            Teacher teacher = (Teacher) session.getAttribute("session_teacher");

            // catalogテーブルから教材名を取得
            CatalogDAO catalogDAO = new CatalogDAO();
            List<String> catalogNames = catalogDAO.getAllCatalogNames();

            // 選択された教材名を取得
            String selectedCatalog = req.getParameter("catalog");
            List<StudentClass> studentClasses = null;
            if (selectedCatalog != null && !selectedCatalog.isEmpty()) {
                Student_ClassDAO studentClassDAO = new Student_ClassDAO();
                studentClasses = studentClassDAO.getStudentClasses();
            }

            // HTML出力
            out.println("<!DOCTYPE html>");
            out.println("<html lang='ja'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>集金</title>");
            out.println("<style>");
            out.println(".header { display: flex; justify-content: space-between; align-items: center; padding: 15px 30px; background-color: #f4f4f4; border-bottom: 1px solid #ddd; }");
            out.println(".header h1 { margin: 0; font-size: 24px; }");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; box-sizing: border-box; }");
            out.println(".user-info { display: flex; align-items: center; gap: 15px; }");
            out.println(".nav-menu { display: flex; width: 100%; margin: 20px 0; }");
            out.println(".nav-menu a { display: block; padding: 15px; text-decoration: none; color: #333; border: 1px solid #ddd; text-align: center; width: 100%; box-sizing: border-box; }");
            out.println(".nav-menu a:hover { background-color: #f0f0f0; }");
            out.println("footer { text-align: center; background-color: #f4f4f4; border-top: 1px solid #ddd; padding: 10px; width: 100%; margin-top: 20px; box-sizing: border-box; }");
            out.println("footer p { margin: 0, 0, 7, 0; color: #333; font-size: 11px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // ヘッダー部分
            out.println("<div class='header'>");
            out.println("<h1>集金</h1>");
            out.println("<div class='user-info'>");

            // ログインユーザー名を表示
            if (teacher != null) {
                out.println(teacher.getName());
            }

            // ログアウトリンク
            out.println("<a href='/Team-E/menu.jsp' class='footer'>ログアウト</a>");
            out.println("</div>");
            out.println("</div>");

            // ナビゲーションメニュー
            out.println("<div class='nav-menu'>");
            out.println("<a href='/Team-E/teacher/calendar'>カレンダー</a>");
            out.println("<a href='/Team-E/teacher/post'>連絡</a>");
            out.println("<a href='/Team-E/teacher/money'>集金</a>");
            out.println("<a href='/Team-E/teacher/temperature'>体温一覧</a>");
            out.println("<a href='/Team-E/teacher/children'>児童</a>");
            out.println("</div>");

            // メインコンテンツ
            out.println("<div class='content'>");
            out.println("<h2>教材一覧</h2>");
            out.println("<ul>");
            for (String name : catalogNames) {
                out.println("<li><a href='?catalog=" + name + "'>" + name + "</a></li>");
            }
            out.println("</ul>");

            if (studentClasses != null && !studentClasses.isEmpty()) {
                out.println("<h2>選択した教材のクラス情報</h2>");
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>NUMBER</th></tr>");
                for (StudentClass sc : studentClasses) {
                    out.println("<tr><td>" + sc.getClassId() + "</td><td>" + sc.getNumber() + "</td></tr>");
                }
                out.println("</table>");
            }
            out.println("</div>");

            // フッター部分追加
            out.println("<footer>");
            out.println("<p>© 2025</p>");
            out.println("<p>School Organizer</p>");
            out.println("</footer>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
