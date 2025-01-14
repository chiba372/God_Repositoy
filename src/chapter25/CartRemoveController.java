package chapter25;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/cart-remove" })
public class CartRemoveController extends CommonServlet {

	@Override
	@SuppressWarnings("unchecked")
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		// リクエストパラメータ（クエリストリング）から商品IDを取得
		int id = Integer.parseInt(req.getParameter("id"));

		// セッションからカート情報を取得
		List<Item> cart = (List<Item>) session.getAttribute("session_cart");

		// カート内の全アイテムをループ
		for (Item i : cart) {
			// カート内のアイテムに、削除したい商品が存在した場合
			if (i.getProduct().getId() == id) {
				// カートからアイテム削除
				cart.remove(i);
				break;
			}
		}

		// ショッピングカートページにリダイレクト
		resp.sendRedirect("cart");
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
