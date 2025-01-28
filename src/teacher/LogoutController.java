package teacher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.CommonServlet;

@WebServlet(urlPatterns = { "/teacher/logout" })
public class LogoutController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		// ログインしている場合
		if (session.getAttribute("session_teacher") != null) {
			// セッションから除去してログアウト
			session.removeAttribute("session_teacher");
			// ログアウト完了ページを表示
			req.getRequestDispatcher("logout-out.jsp").forward(req, resp);
			return;
		}

		// ログインしていなかった場合ログアウトエラーページを表示
		req.getRequestDispatcher("logout-error.jsp").forward(req, resp);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
