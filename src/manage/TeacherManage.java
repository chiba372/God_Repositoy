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

import bean.Teacher;
import dao.TeacherDAO;;

@WebServlet(urlPatterns = { "/manage/teacher-manage" })
public class TeacherManage extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		try {
			// DAOをインスタンス化
			TeacherDAO dao = new TeacherDAO();
			List<Teacher> list=dao.all();

			req.setAttribute("list", list);

			req.getRequestDispatcher("teacher-manage.jsp").forward(req, resp);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
		try {
			TeacherDAO dao = new TeacherDAO();
			List<Teacher> list = new ArrayList<Teacher>();


			String[] names = req.getParameterValues("name");
			String[] ids = req.getParameterValues("id");
			String[] passwords = req.getParameterValues("password");

			for (int i = 0; i < names.length; i++) {
				Teacher t = new Teacher();
				t.setName(names[i]);
				t.setId(ids[i]);
				t.setPassword(passwords[i]);
				t.setIs_master(Boolean.parseBoolean(req.getParameter("manager["+i+"]")));

				list.add(t);
			}

			int a = dao.updateAndInsert(list);

			resp.sendRedirect("teacher-manage");

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}
}