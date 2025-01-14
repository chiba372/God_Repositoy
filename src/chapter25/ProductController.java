package chapter25;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/product" })
public class ProductController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		String keyword = req.getParameter("keyword");
		if (keyword == null) {
			keyword = "";
		}

		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.search(keyword);

		session.setAttribute("session_list", list);

		req.setAttribute("keyword", keyword);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
