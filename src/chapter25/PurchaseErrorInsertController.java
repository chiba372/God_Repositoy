package chapter25;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/purchase-error-insert" })
public class PurchaseErrorInsertController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.getRequestDispatcher("purchase-error-insert.jsp").forward(req, resp);

	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}