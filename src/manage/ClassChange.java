package manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Student_ClassDAO2;;

@WebServlet(urlPatterns = { "/manage/class-change" })
public class ClassChange extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// DAOをインスタンス化
			Student_ClassDAO2 dao = new Student_ClassDAO2();
			int number=dao.maxClassNo();

			int grade = Integer.parseInt(req.getParameter("grade"));

			req.setAttribute("number", number);
			req.setAttribute("grade", grade);

			req.getRequestDispatcher("class-change.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int grade = Integer.parseInt(req.getParameter("grade"));
		int number = Integer.parseInt(req.getParameter("number"));

		resp.sendRedirect("class-organize?grade="+grade+"&number="+number);
	}
}