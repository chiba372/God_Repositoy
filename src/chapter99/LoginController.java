package chapter99;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter99/login" })
public class LoginController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("login-in.jsp").forward(req, resp);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.login(login, password);
		// 認証できた場合
		if (customer != null) {
			// セッションにユーザー情報を保存
			session.setAttribute("session_customer", customer);
			// ログイン後のページにリダイレクト
			resp.sendRedirect("/shop_comp/chapter25/");
			return;
		}

		// 認証できなかった場合はログインページを表示
		req.setAttribute("errorMessage", "ログイン名またはパスワードが違います。");
		req.setAttribute("login", login);
		req.getRequestDispatcher("login-in.jsp").forward(req, resp);
	}

}
