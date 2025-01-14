package chapter25;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter25/cart_add" })
public class CartAddController extends CommonServlet {

	@Override
	@SuppressWarnings("unchecked")
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// カート情報をセッションに保持する
		HttpSession session = req.getSession();

		// リクエストパラメータ（クエリストリング）から商品IDを取得
		int id = Integer.parseInt(req.getParameter("id"));

		// セッションからカート情報を取得
		List<Item> cart = (List<Item>) session.getAttribute("session_cart");
		// カートが空の場合
		if (cart == null) {
			// カートを生成してセッションに保存
			cart = new ArrayList<Item>();
			session.setAttribute("session_cart", cart);
		}

		// カート内の全アイテムをループ
		for (Item i : cart) {
			// カート内のアイテムに、追加したい商品が存在した場合
			if (i.getProduct().getId() == id) {
				// カート内のアイテムの個数を増やす
				i.setCount(i.getCount() + 1);
				// カート画面へリダイレクト
				resp.sendRedirect("cart");
				return;
			}
		}

		// カートにアイテムを新規で追加する
		// session_list...商品を検索した結果のリスト
		List<Product> list = (List<Product>) session.getAttribute("session_list");
		// 検索結果をループ
		for (Product p : list) {
			// 検索結果に、追加したい商品が存在した場合
			if (p.getId() == id) {
				// アイテムをカートに追加
				Item i = new Item();
				i.setProduct(p);
				i.setCount(1);
				cart.add(i);
			}
		}

		// 本当だったら。。。
		// Product p = new ProductDAO().get(id);
		// Item item = new Item();
		// item.setProduct(p);
		// item.setCount(1)
		// cart.add(item);

		// カート画面にリダイレクト
		resp.sendRedirect("cart");
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
