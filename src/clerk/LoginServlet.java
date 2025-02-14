package clerk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Clerk;
import dao.ClerkloginDAO;

// @WebServletアノテーションで、URLパターン"/login"にマッピングされたサーブレットクラス
@WebServlet(urlPatterns={"/clerk/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doGetメソッドはHTTP GETリクエストを処理する
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GETリクエストが来た場合、ログインページにリダイレクト
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }
    // doPostメソッドはHTTP POSTリクエストを処理する
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストの文字エンコーディングをUTF-8に設定
        request.setCharacterEncoding("UTF-8");


        // リクエストパラメータからIDとパスワードを取得
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");

        try {
            // TeacherloginDAOのインスタンスを作成

        	ClerkloginDAO dao = new ClerkloginDAO();
            // DAOのauthenticateメソッドを使用して、IDとパスワードで認証を行う
            Clerk clerk = dao.authenticate(id, password);

            // 認証に成功した場合
            if (clerk != null) {

                // セッションにschool_cdをセット
                HttpSession session = request.getSession();
                session.setAttribute("clerk_name", clerk.getName());
                session.setAttribute("loginUser", clerk);
                // purchaseList.jspにとぶ
                response.sendRedirect("./purchaseList");
            } else {
                // 認証に失敗した場合
                // エラーメッセージをリクエストに設定し、ログインページにフォワード
                request.setAttribute("errorMessage", "認証エラー: IDまたはパスワードが間違っています。");
                request.getRequestDispatcher("./login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 例外が発生した場合、ServletExceptionをスロー
            throw new ServletException(e);
        }
    }
}
