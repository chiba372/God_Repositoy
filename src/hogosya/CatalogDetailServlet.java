package hogosya;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

@WebServlet("/catalogDetail")
public class CatalogDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String catalogIdStr = req.getParameter("id");
        if (catalogIdStr == null) {
            resp.sendRedirect("catalog");
            return;
        }

        int catalogId = Integer.parseInt(catalogIdStr);
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getProductsByCatalogId(catalogId);

        req.setAttribute("productList", productList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/hogosya/catalogDetail.jsp");
        dispatcher.forward(req, resp);
    }
}
