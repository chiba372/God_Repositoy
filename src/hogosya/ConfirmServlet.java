package hogosya;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;

@WebServlet("/confirmOrder")
public class ConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Product> selectedProducts = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();

        // 選択された商品IDを取得し、対応する商品情報を取得
        String[] productIds = req.getParameterValues("selectedProducts");
        if (productIds != null) {
            for (String productId : productIds) {
                Product product = productDAO.getProductById(Integer.parseInt(productId));
                if (product != null) {
                    selectedProducts.add(product);
                }
            }
        }

        session.setAttribute("selectedProducts", selectedProducts);

        // クレジットカード情報を取得
        String cardNumber = req.getParameter("cardNumber");
        String expiryMonth = req.getParameter("expiryMonth");
        String expiryYear = req.getParameter("expiryYear");
        String cardName = req.getParameter("cardName");
        String securityCode = req.getParameter("securityCode");

        req.setAttribute("cardNumber", cardNumber);
        req.setAttribute("expiryMonth", expiryMonth);
        req.setAttribute("expiryYear", expiryYear);
        req.setAttribute("cardName", cardName);
        req.setAttribute("securityCode", securityCode);

        // 確認画面に遷移
        RequestDispatcher dispatcher = req.getRequestDispatcher("/hogosya/confirm.jsp");
        dispatcher.forward(req, resp);
    }
}
