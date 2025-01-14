package chapter24;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter24/login-out" })
public class LoginOutController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("login-out.jsp").forward(req, resp);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
