package hogosya;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.MailDAO;

@WebServlet("/hogosya/mail")
public class MailServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/javad/teamE/SchoolOrganizer";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
	private static final String NAME = null;
	private static final String EMAIL = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
			req.getRequestDispatcher("./mail.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}; // GETでアクセスされたらログインページへリダイレクト
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String token = generateResetToken();  // トークン生成
        String resetLink = "http://localhost:8080/Team-E/pass-reset.jsp?token=" + token;
        //http://localhost:8080/Team-E/hogosya/pass-reset.jspを開きたい↑

        // DAO を使用してユーザーを検索
        MailDAO dao = new MailDAO();
        Student hogosya = null;
		try {
			hogosya = dao.search(email);
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

       if(hogosya!=null){
                    sendResetEmail(email,hogosya.getName(), resetLink);

                }

       resp.getWriter().write("メールが送信されました。");
    }

    private void sendResetEmail(String to,String name, String resetLink) throws ServletException {
        final String from = "your_email@gmail.com";
        //
        System.out.println("📩 メール送信内容 📩");
        System.out.println("----------------------");
        System.out.println("To: " + to);
        System.out.println("Subject: パスワードリセットのお知らせ");
        System.out.println("こんにちは " + name + " さん、");
        System.out.println("以下のリンクからパスワードをリセットしてください。\n\n" + resetLink);
        System.out.println("----------------------");
    }

    private String generateResetToken() {
        return java.util.UUID.randomUUID().toString();
    }
}
