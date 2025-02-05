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

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;

@WebServlet(urlPatterns = { "/teacher/children" })
public class AllController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        // セッションからTeacherオブジェクトを取得
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("session_teacher"); // セッションからログイン情報を取得

        try {
            // 学生をすべて取得
            List<Student> list = new StudentDAO().all();

            // ヘッダー部分
            out.println("<!DOCTYPE html>");
            out.println("<html lang='ja'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>教員</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; box-sizing: border-box; }");
            out.println(".header { display: flex; justify-content: space-between; align-items: center; padding: 15px 30px; background-color: #f4f4f4; border-bottom: 1px solid #ddd; }");
            out.println(".header h1 { margin: 0; font-size: 24px; }");
            out.println(".header .user-info { display: flex; align-items: center; gap: 15px; }");
            out.println(".header .user-info span { font-size: 16px; color: #555; }");
            out.println(".nav-menu { display: flex; width: 100%; margin: 20px 0; }");
            out.println(".nav-menu a { display: block; padding: 15px; text-decoration: none; color: #333; border: 1px solid #ddd; margin: 0; text-align: center; width: 100%; box-sizing: border-box; }");
            out.println(".nav-menu a:hover { background-color: #f0f0f0; }");
            out.println(".content { padding: 20px; text-align: center; max-width: 8000px; margin: 0 auto; }");
            out.println(".footer { display: flex; justify-content: flex-start; align-items: center; padding: 20px; background-color: #f8f9fa; }");
            out.println(".footer a { padding: 10px 20px; border: 1px solid #ccc; background-color: #ffffff; cursor: pointer; border-radius: 4px; text-decoration: none; }");
            out.println(".footer a:hover { background-color: #e2e6ea; }");

            // テーブルのスタイル
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th, td { padding: 12px 15px; border: 1px solid #ddd; text-align: left; }");
            out.println("th { background-color: #f4f4f4; font-weight: bold; }");

            out.println("footer { text-align: center; background-color: #f4f4f4; border-top: 1px solid #ddd; padding: 10px; width: 100%; margin-top: 20px; box-sizing: border-box; }");
            out.println("footer p { margin: 0, 0, 7, 0; color: #333; font-size: 11px; }");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // ヘッダー部分の表示
            out.println("<div class='header'>");
            out.println("<h1>学生一覧</h1>");
            out.println("<div class='user-info'>");

            // ログインユーザー名を表示
            if (teacher != null) {
                out.println(teacher.getName()); // Teacherオブジェクトから名前を表示
            }

            // ログアウトリンクのリンク
            out.println("<a href='/Team-E/menu.jsp' class='footer'>ログアウト</a>");
            out.println("</div>");
            out.println("</div>");

            // ナビゲーションメニュー
            out.println("<div class='nav-menu'>");
            out.println("<a href='/Team-E/teacher/calendar.jsp'>カレンダー</a>");
            out.println("<a href='/Team-E/teacher/post'>連絡</a>");
            out.println("<a href='/Team-E/teacher/money'>集金</a>");
            out.println("<a href='/Team-E/teacher/temperature'>体温</a>");
            out.println("<a href='/Team-E/teacher/children'>児童</a>");
            out.println("</div>");

            // コンテンツ部分（学生一覧）
            out.println("<div class='content'>");
            out.println("<table>");
            out.println("<tr><th>学生番号</th><th>学生名</th></tr>");
            for (Student s : list) {
                out.println("<tr>");
                out.println("<td>" + s.getId() + "</td>");
                out.println("<td>" + s.getName() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</div>");

            // フッター部分追加
            out.println("<footer>");
            out.println("<p>© 2025</p>");
            out.println("<p>School Organizer</p>");
            out.println("</footer>");

            // HTML終了タグ
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
