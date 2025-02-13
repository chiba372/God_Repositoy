package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Catalog;
import util.DbUtil;

public class CatalogDAO {

    public List<Catalog> getAllCatalogs() throws Exception {
        List<Catalog> catalogList = new ArrayList<>();

        Connection con = DbUtil.getConnection();
        String sql = "SELECT * FROM CATALOG WHERE IS_VALID = 1";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Catalog catalog = new Catalog();
            catalog.setId(rs.getInt("ID"));
            catalog.setName(rs.getString("NAME"));
            catalog.setGrade(rs.getInt("GRADE"));
            catalog.setIsValid(rs.getBoolean("IS_VALID"));
            catalog.setImage(rs.getString("IMAGE"));
            catalogList.add(catalog);
        }

        rs.close();
        st.close();
        con.close();

        return catalogList;
    }

    public Catalog getCatalogById(int id) throws Exception {
        Catalog catalog = null;

        Connection con = DbUtil.getConnection();
        String sql = "SELECT * FROM CATALOG WHERE ID = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            catalog = new Catalog();
            catalog.setId(rs.getInt("ID"));
            catalog.setName(rs.getString("NAME"));
            catalog.setGrade(rs.getInt("GRADE"));
            catalog.setIsValid(rs.getBoolean("IS_VALID"));
            catalog.setImage(rs.getString("IMAGE"));
        }

        rs.close();
        st.close();
        con.close();

        return catalog;
    }
}


//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import bean.Catalog;
//import util.DbUtil;
//
//public class CatalogDAO {
//	 /**
//     * CATALOGテーブルのデータを全件取得する
//     */
//    public List<Catalog> getAllCatalogs() throws Exception {
//        List<Catalog> catalogList = new ArrayList<>();
//
//        // DB接続
//        Connection con = DbUtil.getConnection();
//        String sql = "SELECT * FROM CATALOG"; // 有効なデータのみ取得
//        PreparedStatement st = con.prepareStatement(sql);
//        ResultSet rs = st.executeQuery();
//
//        while (rs.next()) {
//            Catalog catalog = new Catalog();
//            catalog.setId(rs.getInt("ID"));
//            catalog.setName(rs.getString("NAME"));
//            catalog.setGrade(rs.getInt("GRADE"));
//            catalog.setIsValid(rs.getBoolean("IS_VALID"));
//            catalog.setImage(rs.getString("IMAGE"));
//
//            catalogList.add(catalog);
//        }
//
//        rs.close();
//        st.close();
//        con.close();
//
//        return catalogList;
//    }
//
//	public List<Catalog> getCatalogsByGrade(int grade) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//    /**
//     * CATALOG テーブルから NAME（カタログ名）を全件取得
//     */
//    public List<String> getCatalogNames() throws Exception {
//        List<String> catalogNames = new ArrayList<>();
//
//        // H2 データベースに接続
//        Connection con = DbUtil.getConnection();
//        String sql = "SELECT NAME FROM CATALOG WHERE IS_VALID = 1"; // 有効なデータのみ取得
//        PreparedStatement st = con.prepareStatement(sql);
//        ResultSet rs = st.executeQuery();
//
//        while (rs.next()) {
//            String name = rs.getString("NAME");
//            System.out.println("📢 DAO側: 取得したカタログ名 = " + name); // デバッグ
//            catalogNames.add(name);
//        }
//
//        rs.close();
//        st.close();
//        con.close();
//
//        System.out.println("📢 DAO側: catalogNamesリスト = " + catalogNames); // デバッグ
//        return catalogNames;
//    }
//}
