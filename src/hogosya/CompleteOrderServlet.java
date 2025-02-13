package hogosya;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;

@WebServlet("/completeOrder")
public class CompleteOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // ログインしている学生のIDを取得（仮: セッションから取得）
        Integer studentId = (Integer) session.getAttribute("studentId");
        if (studentId == null) {
            // 学生IDがない場合はエラー画面にリダイレクト
            response.sendRedirect("error.jsp");
            return;
        }

        // 選択された商品のIDリストを取得
        String[] selectedProductIds = request.getParameterValues("selectedProducts");
        if (selectedProductIds == null || selectedProductIds.length == 0) {
            response.sendRedirect("error.jsp");
            return;
        }

        // 商品IDから商品情報を取得
        ProductDAO productDAO = new ProductDAO();
        List<Product> selectedProducts = new ArrayList<>();

        for (String productId : selectedProductIds) {
            int id = Integer.parseInt(productId);
            Product product = productDAO.getProductById(id);
            if (product != null) {
                selectedProducts.add(product);
            }
        }

        // 購入情報をDBに保存
        productDAO.saveOrder(studentId, selectedProducts);

        // セッションのカート情報をクリア
        session.removeAttribute("selectedProducts");

        // 購入完了ページへリダイレクト
        response.sendRedirect("orderComplete.jsp");
    }
}
