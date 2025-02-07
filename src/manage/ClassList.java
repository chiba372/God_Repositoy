package manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentJoinClass;
import dao.StudentJoinClassDAO;

@WebServlet(urlPatterns = { "/manage/class-list" })
	public class ClassList extends HttpServlet {


		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// DAOをインスタンス化
			StudentJoinClassDAO dao = new StudentJoinClassDAO();

			List<List<StudentJoinClass>> lists = new ArrayList<List<StudentJoinClass>>();


			for (int i = 1; i <= 6; i++) {
				List<StudentJoinClass> list=dao.gradeAllClassNoASC(i);
				lists.add(list);
			}
			req.setAttribute("lists", lists);

			req.getRequestDispatcher("class-list.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
}