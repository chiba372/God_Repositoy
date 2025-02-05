package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Allpost;
import dao.AllpostDAO;

@WebServlet(urlPatterns = { "/teacher/postDetail" })
public class PostDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            String name = req.getParameter("name");
            String dateStr = req.getParameter("date");

            if (name == null || dateStr == null) {
                out.println("<h2>不正なリクエストです</h2>");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);

            AllpostDAO dao = new AllpostDAO();
            Allpost post = dao.getPostByNameAndDate(name, date);

            if (post == null) {
                out.println("<h2>該当する投稿が見つかりません</h2>");
                return;
            }

            out.println("<!DOCTYPE html>");
            out.println("<html lang='ja'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>投稿詳細</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>投稿詳細</h1>");
            out.println("<p><strong>日付:</strong> " + post.getDate() + "</p>");
            out.println("<p><strong>件名:</strong> " + post.getName() + "</p>");
            out.println("<p><strong>内容:</strong></p>");
            out.println("<p>" + post.getContent() + "</p>");
            out.println("<a href='/teacher/post'>一覧に戻る</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>エラーが発生しました</h2>");
        }
    }
}