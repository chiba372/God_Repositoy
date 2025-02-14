package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Allpost;
import bean.Teacher;
import dao.AllpostDAO;

@WebServlet(urlPatterns = { "/teacher/post" })
public class AllPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("session_teacher");

        try {
            AllpostDAO dao = new AllpostDAO();

            String deleteName = req.getParameter("deleteName");
            String deleteDate = req.getParameter("deleteDate");

            if (deleteName != null && deleteDate != null) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(deleteDate);
                dao.deletePostByNameAndDate(deleteName, date);
                resp.sendRedirect("/Team-E/teacher/post");
                return;
            }

            List<Allpost> allPosts = dao.all();

            out.println("<!DOCTYPE html>");
            out.println("<html lang='ja'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>投稿一覧</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; box-sizing: border-box; }");
            out.println(".header { display: flex; justify-content: space-between; align-items: center; padding: 15px 30px; background-color: #f4f4f4; border-bottom: 1px solid #ddd; }");
            out.println(".header h1 { margin: 0; font-size: 24px; }");
            out.println(".header .user-info { display: flex; align-items: center; gap: 15px; }");
            out.println(".header .user-info span { font-size: 16px; color: #555; }");
            out.println(".nav-menu { display: flex; width: 100%; margin: 20px 0; }");
            out.println(".nav-menu a { display: block; padding: 15px; text-decoration: none; color: #333; border: 1px solid #ddd; text-align: center; width: 100%; box-sizing: border-box; }");
            out.println(".content { padding: 20px; text-align: center; max-width: 800px; margin: 0 auto; }");
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th, td { padding: 12px 15px; border: 1px solid #ddd; text-align: left; }");
            out.println("th { background-color: #f4f4f4; font-weight: bold; }");
            out.println("footer { text-align: center; background-color: #f4f4f4; border-top: 1px solid #ddd; padding: 10px; width: 100%; margin-top: 20px; box-sizing: border-box; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='header'>");
            out.println("<h1>投稿一覧</h1>");
            out.println("<div class='user-info'>");

            // ログインユーザー名を表示
            if (teacher != null) {
                out.println(teacher.getName()); // Teacherオブジェクトから名前を表示
            }

            // ログアウトリンクのリンク
            out.println("<a href='/Team-E/menu.jsp' class='footer'>ログアウト</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='nav-menu'>");
            out.println("<a href='/Team-E/teacher/calendar'>カレンダー</a>");
            out.println("<a href='/Team-E/teacher/post'>連絡</a>");
            out.println("<a href='/Team-E/teacher/money'>集金</a>");
            out.println("<a href='/Team-E/teacher/temperature'>体温</a>");
            out.println("<a href='/Team-E/teacher/children'>児童</a>");
            out.println("</div>");

            out.println("<div class='content'>");
            out.println("<table>");
            out.println("<tr><th>日付</th><th>件名</th><th>詳細</th><th>削除</th></tr>");
            for (Allpost post : allPosts) {
                String postDate = new SimpleDateFormat("yyyy-MM-dd").format(post.getDate());
                out.println("<tr>");
                out.println("<td>" + postDate + "</td>");
                out.println("<td>" + post.getName() + "</td>");
                out.println("<td><a href='/Team-E/teacher/post?detailDate=" + postDate + "&detailName=" + post.getName() + "'>詳細</a></td>");
                out.println("<td><a href='/Team-E/teacher/post?deleteDate=" + postDate + "&deleteName=" + post.getName() + "' onclick=\"return confirm('削除しますか？');\">削除</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");

            // 投稿フォーム
            out.println("<h3>新規投稿</h3>");
            out.println("<form action='/Team-E/teacher/post' method='post'>");
            out.println("件名: <input type='text' name='name' required><br>");
            out.println("内容: <textarea name='content' required></textarea><br>");
            out.println("<input type='submit' value='投稿する'>");
            out.println("</form>");

            // 投稿詳細表示
            String detailName = req.getParameter("detailName");
            String detailDate = req.getParameter("detailDate");

            if (detailName != null && detailDate != null) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(detailDate);
                Allpost postDetail = dao.getPostByNameAndDate(detailName, date);

                if (postDetail != null) {
                    out.println("<h2>投稿詳細</h2>");
                    out.println("<p><strong>日付:</strong> " + detailDate + "</p>");
                    out.println("<p><strong>件名:</strong> " + postDetail.getName() + "</p>");
                    out.println("<p><strong>内容:</strong> " + postDetail.getContent() + "</p>");
                    out.println("<p><a href='/Team-E/teacher/post?deleteDate=" + detailDate + "&deleteName=" + detailName + "' onclick=\"return confirm('この投稿を削除しますか？');\">この投稿を削除</a></p>");
                } else {
                    out.println("<p>該当する投稿が見つかりませんでした。</p>");
                }
            }

            out.println("</div>");
            out.println("<footer><p>© 2025 School Organizer</p></footer>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            String name = req.getParameter("name");
            String content = req.getParameter("content");
            Date date = new Date();

            Allpost post = new Allpost();
            post.setDate(date);
            post.setName(name);
            post.setContent(content);

            AllpostDAO dao = new AllpostDAO();
            dao.insertPost(post);

            resp.sendRedirect("/Team-E/teacher/post");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
