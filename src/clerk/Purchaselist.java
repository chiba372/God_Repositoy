package clerk;

import java.io.IOException;
import java.util.ArrayList;
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
		// 学年のパラメータを取得
		String gradeParam = req.getParameter("grade");
		Integer gradeFilter = (gradeParam != null && !gradeParam.isEmpty()) ? Integer.parseInt(gradeParam) : null;

		// クラスのパラメータを取得
		String classNoParam = req.getParameter("classNo");
		Integer classNoFilter = (classNoParam != null && !classNoParam.isEmpty()) ? Integer.parseInt(classNoParam) : null;

		// 購入リストを取得
		List<PurchaseInfo> purchaseList = purchaseDAO.getPurchaseList(gradeFilter, classNoFilter);

		// 件数を取得
		int purchaseCount = purchaseList.size();

		// 学年に対するクラスを取得
		List<Integer> classNumbers = new ArrayList<>();
		if (gradeFilter != null) {
			PurchaseDAO purchaseDAO = new PurchaseDAO();
			classNumbers = purchaseDAO.getClassNumbersByGrade(gradeFilter);
		}

		// JSPへデータを渡す
		req.setAttribute("purchaseList", purchaseList);
		req.setAttribute("selectedGrade", gradeFilter);
		req.setAttribute("selectedClassNo", classNoFilter);
		req.setAttribute("classNumbers", classNumbers);
		req.setAttribute("purchaseCount", purchaseCount);

		RequestDispatcher dispatcher = req.getRequestDispatcher("purchaseList.jsp");
		dispatcher.forward(req, resp);
	}
}
