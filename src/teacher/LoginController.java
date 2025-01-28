package teacher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.CustomerDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns={"/teacher/login"})
public class LoginController extends CommonServlet {

    @Override
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("login-in.jsp").forward(req, resp);
    }

    @Override
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        CustomerDAO dao = new CustomerDAO();
        Teacher teacher = dao.search(name, password);

        // 認証できた場合
        if (teacher != null) {
            // セッションにユーザー情報を保存
            session.setAttribute("session_teacher", teacher);
            // ログイン後のページにリダイレクト
            resp.sendRedirect("/Team-E/menu2.jsp");
            return;
        }

        // 認証できなかった場合はログインページを表示
        req.setAttribute("errorMessage", "ログイン名またはパスワードが違います");
        req.getRequestDispatcher("login-in.jsp").forward(req, resp);
    }
}