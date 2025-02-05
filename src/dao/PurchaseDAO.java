package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PurchaseInfo;
import util.DbUtil;

public class PurchaseDAO extends DAO {
	/**
	 * 購入テーブルに、カートに存在する分だけ、データを登録する
	 *
	 * @param cart
	 *            カート内のアイテムのリスト
	 * @param name
	 *            購入者の氏名
	 * @param address
	 *            購入者の住所
	 * @return すべてが登録できた：true, 1件でも登録できなかった：false
	 * @throws Exception
	 */
//	public boolean insert(List<Item> cart, String name, String address) throws Exception {
//		Connection con = getConnection();
//		// 自動コミットを解除
//		con.setAutoCommit(false);
//
//		// 最初に1回だけプリペアードステートメントをコンパイル
//		PreparedStatement st = con.prepareStatement("insert into purchase values(null,?,?,?,?,?,?,?)");
//		// カートをループ
//		for (Item item : cart) {
//			Product p = item.getProduct();
//			st.setInt(1, p.getId());
//			st.setString(2, p.getName());
//			st.setInt(3, p.getPrice());
//			st.setString(4, p.getImage());
//			st.setInt(5, item.getCount());
//			st.setString(6, name);
//			st.setString(7, address);
//			int line = st.executeUpdate();
//
//			// 登録に失敗した場合
//			if (line != 1) {
//				// ロールバック
//				con.rollback();
//				// 自動コミットを有効化
//				con.setAutoCommit(true);
//				st.close();
//				con.close();
//				return false;
//			}
//		}
//
//		// すべて成功した場合、コミットする
//		con.commit();
//		// 自動コミットを有効化
//		con.setAutoCommit(true);
//		st.close();
//		con.close();
//		return true;
//	}

	// 事務員ページに表示する商品購入リストのメソッド
	public List<PurchaseInfo> getPurchaseList() {
		List<PurchaseInfo> list = new ArrayList<>();
		String sql = "SELECT p.ID AS PRODUCT_ID, p.NAME AS PRODUCT_NAME, s.ID AS STUDENT_ID, s.NAME AS STUDENT_NAME, pu.PRO_QUA, (pu.PRO_QUA * p.PRICE) AS TOTAL " +
					   "FROM PURCHASE pu " +
					   "JOIN PRODUCT p ON pu.PRODUCT_ID = p.ID " +
					   "JOIN STUDENT s ON pu.STUDENT_ID = s.ID " +
					   "ORDER BY s.ID ASC, p.NAME ASC"; // 児童番号 → カタログ名 の順番で昇順でソート

		try (Connection con = DbUtil.getConnection();
			  PreparedStatement pstmt = con.prepareStatement(sql);
			  ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int studentId = rs.getInt("STUDENT_ID");
				String studentName = rs.getString("STUDENT_NAME");
				int proQua = rs.getInt("PRO_QUA");
				int total = rs.getInt("TOTAL");

				list.add(new PurchaseInfo(productId, productName, studentId, studentName, proQua, total));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

}
