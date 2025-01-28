package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Health;
import dao.HealthDAO;

@WebServlet(urlPatterns = { "/teacher/temperature" })
public class AllTempreture extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        try {
            // DAOをインスタンス化
            HealthDAO dao = new HealthDAO();

            // 全体の健康データ（日付リスト）を取得
            List<Health> healthList = dao.all();

            // ヘッダー部分
            out.println("<!DOCTYPE html>");
            out.println("<html lang='ja'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>体温一覧</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; box-sizing: border-box; }");
            out.println(".header { display: flex; justify-content: space-between; align-items: center; padding: 15px 30px; background-color: #f4f4f4; border-bottom: 1px solid #ddd; }");
            out.println(".header h1 { margin: 0; font-size: 24px; }");
            out.println(".nav-menu { display: flex; width: 100%; margin: 20px 0; }");
            out.println(".nav-menu a { display: block; padding: 15px; text-decoration: none; color: #333; border: 1px solid #ddd; margin: 0; text-align: center; width: 100%; box-sizing: border-box; }");
            out.println(".nav-menu a:hover { background-color: #f0f0f0; }");
            out.println(".content { padding: 20px; text-align: center; max-width: 8000px; margin: 0 auto; }");
            out.println(".footer { display: flex; justify-content: flex-start; align-items: center; padding: 20px; background-color: #f8f9fa; }");
            out.println(".footer button { padding: 10px 20px; border: 1px solid #ccc; background-color: #ffffff; cursor: pointer; border-radius: 4px; }");
            out.println(".footer button:hover { background-color: #e2e6ea; }");

            // テーブルのスタイル
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th, td { padding: 12px 15px; border: 1px solid #ddd; text-align: left; }");
            out.println("th { background-color: #f4f4f4; font-weight: bold; }");

            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // ヘッダー部分の表示
            out.println("<div class='header'>");
            out.println("<h1>体温一覧</h1>");
            out.println("<div class='user-info'>");

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
            out.println("<a href='/Team-E/teacher/oney'>集金</a>");
            out.println("<a href='/Team-E/teacher/temperature'>体温</a>");
            out.println("<a href='/Team-E/teacher/children'>児童</a>");
            out.println("</div>");

            // 日付一覧を表示
            out.println("<div class='content'>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>日付</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");

            // すでに表示された日付を追跡するセット
            Set<String> displayedDates = new HashSet<>();

            // 健康データから日付一覧を表示
            for (Health health : healthList) {
                String date = health.getDate().toString();
                // 日付が表示されていなければ表示する
                if (!displayedDates.contains(date)) {
                    out.println("<tr>");
                    out.println("<td><a href='/Team-E/teacher/temperature?date=" + date + "'>" + date + "</a></td>");
                    out.println("</tr>");
                    displayedDates.add(date); // 表示した日付を記録
                }
            }

            out.println("</tbody>");
            out.println("</table>");

            // 日付パラメータが指定されていた場合
            String dateParam = req.getParameter("date");
            if (dateParam != null) {
                // 日付に関連するデータを取得
                List<Health> healthDetails = dao.getHealthDataByDate(dateParam);

                if (!healthDetails.isEmpty()) {
                    out.println("<h3>詳細情報 - " + dateParam + "</h3>");
                    out.println("<table>");
                    out.println("<thead>");
                    out.println("<tr><th>名前</th><th>通常体温</th><th>今日の体温</th><th>欠席</th><th>備考</th></tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (Health health : healthDetails) {
                        out.println("<tr>");
                        out.println("<td>" + health.getName() + "</td>");
                        out.println("<td>" + health.getNormal_Temp() + "</td>");
                        out.println("<td>" + health.getToday_Temp() + "</td>");
                        out.println("<td>" + (health.getExcuse() ? "はい" : "いいえ") + "</td>");
                        out.println("<td>" + health.getNotes() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                } else {
                    out.println("<p>選択された日付にはデータがありません。</p>");
                }

                // 「戻る」ボタンを日付一覧画面にリンクさせる
                out.println("<div class='footer'>");
                out.println("<a href='/Team-E/teacher/temperature' style='padding: 10px 20px; border: 1px solid #ccc; background-color: #ffffff; cursor: pointer; border-radius: 4px;'>戻る</a>");
                out.println("</div>");
            }

            out.println("</div>"); // content

            // HTML終了タグ
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
