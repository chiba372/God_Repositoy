package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CatalogDAO;

@WebServlet(urlPatterns = { "/teacher/money" })
public class Allmoney extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=UTF-8");

        try {
            String nameParam = req.getParameter("name");
            CatalogDAO catalogDAO = new CatalogDAO();

            // 教材名が指定されていた場合、その教材に関連するSTUDENT_CLASSとNUMBERを表示
            if (nameParam != null) {
                List<String[]> classAndNumberList = catalogDAO.getClassAndNumberByName(nameParam);

                // HTML出力
                out.println("<!DOCTYPE html>");
                out.println("<html lang='ja'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>集金</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; box-sizing: border-box; }");
                out.println(".header { background-color: #f4f4f4; padding: 20px; text-align: center; }");
                out.println(".header h1 { margin: 0; font-size: 24px; }");
                out.println(".content { padding: 20px; max-width: 800px; margin: 0 auto; }");
                out.println(".catalog-list { list-style-type: none; padding: 0; }");
                out.println(".catalog-list li { padding: 10px; background-color: #f9f9f9; margin-bottom: 8px; border: 1px solid #ddd; border-radius: 4px; }");
                out.println(".catalog-list li:hover { background-color: #f1f1f1; }");
                out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
                out.println("th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='header'><h1>集金</h1></div>");

                out.println("<div class='content'>");
                out.println("<h2>" + nameParam + "のSTUDENT_CLASSとNUMBER</h2>");
                out.println("<table>");
                out.println("<thead><tr><th>STUDENT_CLASS</th><th>NUMBER</th></tr></thead>");
                out.println("<tbody>");

                for (String[] classAndNumber : classAndNumberList) {
                    out.println("<tr>");
                    out.println("<td>" + classAndNumber[0] + "</td>");
                    out.println("<td>" + classAndNumber[1] + "</td>");
                    out.println("</tr>");
                }

                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>"); // content

                out.println("</body>");
                out.println("</html>");
            } else {
                // 教材名が指定されていない場合、リストを表示
                List<String> catalogNames = catalogDAO.getAllCatalogNames();

                // HTML出力
                out.println("<!DOCTYPE html>");
                out.println("<html lang='ja'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>集金</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; box-sizing: border-box; }");
                out.println(".header { background-color: #f4f4f4; padding: 20px; text-align: center; }");
                out.println(".header h1 { margin: 0; font-size: 24px; }");
                out.println(".content { padding: 20px; max-width: 800px; margin: 0 auto; }");
                out.println(".catalog-list { list-style-type: none; padding: 0; }");
                out.println(".catalog-list li { padding: 10px; background-color: #f9f9f9; margin-bottom: 8px; border: 1px solid #ddd; border-radius: 4px; }");
                out.println(".catalog-list li:hover { background-color: #f1f1f1; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='header'><h1>集金</h1></div>");

                out.println("<div class='content'>");
                out.println("<h2>教材一覧</h2>");
                out.println("<ul class='catalog-list'>");

                for (String name : catalogNames) {
                    out.println("<li><a href='/Team-E/teacher/money?name=" + name + "'>" + name + "</a></li>");
                }

                out.println("</ul>");
                out.println("</div>"); // content

                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
