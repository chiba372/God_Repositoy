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

	public List<String> getAllCatalogNames() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
