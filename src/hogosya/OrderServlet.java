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

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // チェックされた商品のIDを取得
        String[] selectedProductIds = req.getParameterValues("productIds");

        // 選択された商品を取得
        List<Product> selectedProducts = new ArrayList<>();
        if (selectedProductIds != null) {
            ProductDAO productDao = new ProductDAO();
            for (String productId : selectedProductIds) {
                Product product = productDao.getProductById(Integer.parseInt(productId));
                if (product != null) {
                    selectedProducts.add(product);
                }
            }
        }

        // セッションに選択した商品を保存
        HttpSession session = req.getSession();
        session.setAttribute("selectedProducts", selectedProducts);

        // クレジットカード入力ページへリダイレクト
        resp.sendRedirect("/hogosya/credit.jsp");
    }
}
