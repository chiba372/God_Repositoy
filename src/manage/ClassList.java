package manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher2;
import dao.TeacherDAO;

@WebServlet(urlPatterns = { "/class-list" })
	public class ClassList extends HttpServlet {


		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// DAOをインスタンス化
			TeacherDAO dao = new TeacherDAO();
			List<Teacher2> list=dao.all();

			req.setAttribute("list", list);

			req.getRequestDispatcher("/manage/class-list.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
}