package manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;

@WebServlet(urlPatterns = { "/manage/manage-menu" })
public class ManageMenu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

        Teacher teacher = (Teacher) session.getAttribute("session_teacher");
		session.setAttribute("session_teacher", teacher);

		req.getRequestDispatcher("/manage-menu.jsp").forward(req, resp);
	}
}