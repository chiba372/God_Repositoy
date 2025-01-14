package chapter99;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Product;
import dao.ProductDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter99/product" })
public class ProductAPI extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// JSONにしたいデータを取得
		List<Product> list = new ProductDAO().all();

		ObjectMapper mapper = new ObjectMapper();
		// JavaオブジェクトからJSONに変換
		String jsonData = mapper.writeValueAsString(list);
		// JSONの出力
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().write(jsonData);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {

	}

}
