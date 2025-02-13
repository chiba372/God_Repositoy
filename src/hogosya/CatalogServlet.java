package hogosya;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Catalog;
import dao.CatalogDAO;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CatalogDAO dao = new CatalogDAO();
        List<Catalog> catalogList = null;

        try {
            catalogList = dao.getAllCatalogs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("catalogList", catalogList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/hogosya/catalog.jsp");
        dispatcher.forward(req, resp);
    }
}
