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

        try {
            // DAOをインスタンス化
            AllpostDAO dao = new AllpostDAO();

            // 日付、件名、内容をクエリパラメータで受け取る
            String dateParam = req.getParameter("date");
            String nameParam = req.getParameter("name");
            String contentParam = req.getParameter("content");

            // 削除処理
            String deleteDateParam = req.getParameter("deleteDate");
            String deleteNameParam = req.getParameter("deleteName");
            if (deleteDateParam != null && deleteNameParam != null) {
                Date deleteDate = new SimpleDateFormat("yyyy-MM-dd").parse(deleteDateParam);
                dao.deletePostByNameAndDate(deleteNameParam, deleteDate);
                resp.sendRedirect("/Team-E/teacher/post");
                return;
            }

            // ヘッダー部分
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
            out.println(".nav-menu { display: flex; width: 100%; margin: 20px 0; }");
            out.println(".nav-menu a { display: block; padding: 15px; text-decoration: none; color: #333; border: 1px solid #ddd; margin: 0; text-align: center; width: 100%; box-sizing: border-box; }");
            out.println(".nav-menu a:hover { background-color: #f0f0f0; }");
            out.println(".content { padding: 20px; text-align: center; max-width: 1200px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }");
            out.println(".footer { text-align: center; padding: 20px; background-color: #f8f9fa; }");
            out.println(".footer a { padding: 10px 20px; border: 1px solid #ccc; background-color: #ffffff; cursor: pointer; border-radius: 4px; text-decoration: none; color: #333; }");
            out.println(".footer a:hover { background-color: #e2e6ea; }");
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th, td { padding: 12px 15px; border: 1px solid #ddd; text-align: left; }");
            out.println("th { background-color: #f4f4f4; font-weight: bold; }");
            out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
            out.println("tr:hover { background-color: #f1f1f1; }");

            // 詳細表示のスタイル
            out.println(".detail-container { background-color: #f9f9f9; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); max-width: 800px; margin: 20px auto; }");
            out.println(".detail-container h3 { font-size: 24px; margin-bottom: 10px; color: #333; }");
            out.println(".detail-container h4 { font-size: 20px; color: #555; margin-bottom: 15px; }");
            out.println(".detail-container p { font-size: 18px; line-height: 1.6; color: #444; }");

            // 投稿フォームのスタイル
            out.println(".form-container { background-color: #f9f9f9; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); max-width: 800px; margin: 20px auto; }");
            out.println(".form-container h3 { font-size: 24px; margin-bottom: 10px; color: #333; }");
            out.println(".form-container label { font-size: 18px; margin-bottom: 10px; color: #555; display: block; }");
            out.println(".form-container input[type='text'], .form-container textarea { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; font-size: 16px; box-sizing: border-box; }");
            out.println(".form-container input[type='submit'] { padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; font-size: 18px; cursor: pointer; }");
            out.println(".form-container input[type='submit']:hover { background-color: #45a049; }");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // ヘッダー部分の表示
            out.println("<div class='header'>");
            out.println("<h1>投稿一覧</h1>");
            out.println("<div class='user-info'>");

            // ログインユーザー情報を取得
            HttpSession session = req.getSession();
            Teacher teacher = (Teacher) session.getAttribute("session_teacher"); // セッションからTeacherオブジェクトを取得

            // ログインしている場合、教師の名前を表示
            if (teacher != null) {
                out.println( teacher.getName());
            }

            // ログアウトボタンと担当ページへのリンク
            out.println("<form action='/Team-E/menu.jsp' method='post' style='display:inline;'>");
            out.println("<input type='submit' value='ログアウト' />");
            out.println("</form>");
            out.println("<a href='/Team-E/teacher/yourpage.jsp' style='margin-left: 20px;'>担当ページへ</a>");
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

            // 投稿詳細の表示
            if (dateParam != null && nameParam != null && contentParam != null) {
                // 詳細情報を表示
                out.println("<div class='content detail-container'>");
                out.println("<h3>日付: " + dateParam + "</h3>");
                out.println("<h4>件名: " + nameParam + "</h4>");
                out.println("<p><strong>内容:</strong><br>" + contentParam + "</p>");
                out.println("</div>");
            } else {
                // 投稿一覧の表示
                List<Allpost> allPosts = dao.all();

                out.println("<div class='content'>");
                out.println("<table>");
                out.println("<thead>");
                out.println("<tr><th>日付</th><th>件名</th><th>詳細</th><th>削除</th></tr>");
                out.println("</thead>");
                out.println("<tbody>");

                for (Allpost post : allPosts) {
                    Date postDate = post.getDate();
                    String postName = post.getName();
                    String postContent = post.getContent();

                    out.println("<tr>");
                    out.println("<td>" + postDate + "</td>");
                    out.println("<td>" + postName + "</td>");
                    out.println("<td><a href='/Team-E/teacher/post?date=" + postDate + "&name=" + postName + "&content=" + postContent + "'>詳細</a></td>");
                    out.println("<td><a href='/Team-E/teacher/post?deleteDate=" + postDate + "&deleteName=" + postName + "'>削除</a></td>");
                    out.println("</tr>");
                }

                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
            }

            // 投稿フォームの表示
            out.println("<div class='form-container'>");
            out.println("<h3>新規投稿</h3>");
            out.println("<form action='/Team-E/teacher/post' method='post'>");
            out.println("<label for='name'>件名:</label>");
            out.println("<input type='text' id='name' name='name' required>");

            out.println("<label for='content'>内容:</label>");
            out.println("<textarea id='content' name='content' rows='4' required></textarea>");

            out.println("<input type='submit' value='投稿する'>");
            out.println("</form>");
            out.println("</div>");

            // フッター部分

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>エラーが発生しました</h2>");
        }
    }
}