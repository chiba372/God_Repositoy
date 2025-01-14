package chapter99;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.CustomerDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter99/customer-insert" })
public class CustomerInsertController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("customer-insert.jsp").forward(req, resp);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		// 送信されたログインIDとパスワードを取得
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		// 生パスワードをハッシュ値に変換
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String hashedPassword = bcpe.encode(password);

		// ログインIDとパスワードのハッシュ値をDBに登録
		new CustomerDAO().insert(login, hashedPassword);

		req.getRequestDispatcher("customer-insert-out.jsp").forward(req, resp);

	}

}
