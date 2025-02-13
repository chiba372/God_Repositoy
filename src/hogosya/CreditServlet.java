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

@WebServlet("/CreditServlet")
public class CreditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String[] productId = req.getParameterValues("productId");

        List<Product> selectedProducts = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();

        if (productId != null) {
            for (String id : productId) {
                Product product = productDAO.getProductById(Integer.parseInt(id));
                if (product != null) {
                    selectedProducts.add(product);
                }
            }
        }

        session.setAttribute("selectedProducts", selectedProducts);
        resp.sendRedirect("/Team-E/hogosya/credit.jsp");
    }
}
