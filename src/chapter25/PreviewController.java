package chapter25;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.PurchaseDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/preview" })
public class PreviewController extends CommonServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		// ログインしていない場合
		if (session.getAttribute("session_customer") == null) {
			// ログインエラー画面を表示
			req.getRequestDispatcher("preview-error-login.jsp").forward(req, resp);
			return;
		}

		// カート情報を取得
		List<Item> cart = (List<Item>) session.getAttribute("session_cart");
		// カートが存在しない、または、カートの中身が0件の場合
		if (cart == null || cart.size() == 0) {
			// カートエラー画面を表示
			req.getRequestDispatcher("preview-error-cart.jsp").forward(req, resp);
			return;
		}

		req.getRequestDispatcher("purchase-in.jsp").forward(req, resp);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		// 送信された氏名と住所を取得
		String name = req.getParameter("name");
		String address = req.getParameter("address");

		// 氏名が空欄、または住所が空欄の場合
		if (name.isEmpty() || address.isEmpty()) {
			// エラーメッセージを購入確認画面に表示
			req.setAttribute("error", "名前と住所を正しく入力してください。");
			req.getRequestDispatcher("purchase-in.jsp").forward(req, resp);
			return;
		}

		PurchaseDAO dao = new PurchaseDAO();

		// セッションからカート情報を取得
		List<Item> cart = (List<Item>) session.getAttribute("session_cart");
		// カート情報と購入者情報をDBに登録
		boolean isInserted = dao.insert(cart, name, address);

		// カートが存在しない、または登録処理が失敗した場合
		if (cart == null || !isInserted) {
			// 購入エラーページにリダイレクト
			resp.sendRedirect("purchase-error-insert");
			return;
		}

		// カートを除去
		session.removeAttribute("session_cart");

		// 購入完了ページにリダイレクト
		resp.sendRedirect("purchase");
	}

}
