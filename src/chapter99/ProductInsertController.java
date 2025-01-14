package chapter99;

import java.io.File;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Product;
import dao.ProductDAO;
import tool.CommonServlet;

@WebServlet(urlPatterns = { "/chapter99/product-insert" })
@MultipartConfig() // ファイルを受け取るサーブレットに必須
public class ProductInsertController extends CommonServlet {

	@Override
	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("product-insert.jsp").forward(req, resp);
	}

	@Override
	public void post(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		// 送信された商品名と価格を取得
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));

		// アップロードされたファイルそのものを取得
		// 以後パートと呼ぶ
		Part part = req.getPart("img_file");
		// パートのファイル名を取得
		String originalFileName = part.getSubmittedFileName();
		// ファイル名から拡張子を取得
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));

		// 保存するファイル名を決定（今回は現在日時を経過ミリ秒換算したものとした）
		String savedFileName = Long.toString(new Date().getTime()) + ext;

		// web.xmlからコンテキストルートの物理パスを取得
		// ↑
		// <context-param>
		// <param-name>upload-dir</param-name>
		// <param-value>C:/work/pleiades/workspace/shop_comp/WebContent</param-value>
		// </context-param>
		String uploadDir = getServletContext().getInitParameter("upload-dir");

		// ファイル保存先のフルパスを設定
		String filePath = uploadDir + "/chapter25/image/" + savedFileName;
		File save = new File(filePath);

		// ファイル保存先の物理パスを取得
		String savePath = save.getAbsolutePath();
		System.out.println(savePath);

		// ファイルを保存
		part.write(savePath);

		// 商品をDBに登録
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setImage(savedFileName);
		new ProductDAO().insert(p);

		req.getRequestDispatcher("product-insert-out.jsp").forward(req, resp);

	}

}
