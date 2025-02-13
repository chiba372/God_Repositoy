package hogosya;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CreditInfo;
import bean.Product;
import util.DbUtil;

@WebServlet("/orderComplete")
public class OrderCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Product> selectedProducts = (List<Product>) session.getAttribute("selectedProducts");
        CreditInfo creditInfo = (CreditInfo) session.getAttribute("creditInfo");
        Integer studentId = (Integer) session.getAttribute("STUDENT_ID"); // セッションから取得

        if (selectedProducts == null || selectedProducts.isEmpty() || creditInfo == null || studentId == null) {
            resp.sendRedirect("catalogDetail"); // 商品選択またはカード情報がない場合、カタログページへリダイレクト
            return;
        }

        try (Connection conn = DbUtil.getConnection()) {
            String sql = "INSERT INTO PURCHASE (STUDENT_ID, PRODUCT_ID, PRO_QUA) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (Product product : selectedProducts) {
                    pstmt.setInt(1, studentId);
                    pstmt.setInt(2, product.getId());
                    pstmt.setInt(3, 1); // 初期値として1を設定（必要に応じて修正）
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "注文処理中にエラーが発生しました。");
            req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
            return;
        }

        // セッション情報をクリア
        session.removeAttribute("selectedProducts");
        session.removeAttribute("creditInfo");

        // 購入完了ページへリダイレクト
        resp.sendRedirect("orderComplete.jsp");
    }
}
