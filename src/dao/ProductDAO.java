package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import util.DbUtil;

public class ProductDAO {
    // 特定のIDの商品を取得する
    public Product getProductById(int id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    // 選択された商品を購入履歴に保存する
    public void saveOrder(int studentId, List<Product> productList) {
        String sql = "INSERT INTO PURCHASE (STUDENT_ID, PRODUCT_ID, PRO_QUA) VALUES (?, ?, ?)";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Product product : productList) {
                pstmt.setInt(1, studentId);
                pstmt.setInt(2, product.getId());
                pstmt.setInt(3, 1);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // カタログごとの商品を取得する（追加）
    public List<Product> getProductsByCatalogId(int catalogId) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE catalog_id = ?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, catalogId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
}
