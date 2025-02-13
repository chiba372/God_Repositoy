package hogosya;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.LoginDAO;

@WebServlet(urlPatterns={"/hogosya/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        // フォームのパラメータを取得
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        // 入力チェック（未入力の場合の処理）
        if (id == null || id.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("errorMessage", "児童IDとパスワードを入力してください。");
            try {
                req.getRequestDispatcher("./login.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.println(id);
        System.out.println(password);

        // DAO を使用してユーザーを検索
        LoginDAO dao = new LoginDAO();
        Student hogosya = null;
		try {
			hogosya = dao.search(id, password);
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

        if (hogosya != null) {
            // 認証成功 → セッションにユーザー情報を保存
            session.setAttribute("session_hogosya", hogosya);
            resp.sendRedirect("top.jsp"); // ログイン成功時に遷移
        } else {
            // 認証失敗 → エラーメッセージをセットして再表示
            req.setAttribute("errorMessage", "児童IDまたはパスワードが違います。");
            try {
                req.getRequestDispatcher("./login.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
			req.getRequestDispatcher("./login.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}; // GETでアクセスされたらログインページへリダイレクト
    }
}

