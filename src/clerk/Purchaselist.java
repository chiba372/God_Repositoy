package clerk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PurchaseInfo;
import dao.PurchaseDAO;

@WebServlet(urlPatterns={"/clerk/purchaseList"})
public class Purchaselist extends HttpServlet {
	private PurchaseDAO purchaseDAO;

	@Override
	public void init() {
		purchaseDAO = new PurchaseDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PurchaseInfo> purchaseList = purchaseDAO.getPurchaseList();
		req.setAttribute("purchaseList", purchaseList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("purchaseList.jsp");
		dispatcher.forward(req, resp);
	}
}
