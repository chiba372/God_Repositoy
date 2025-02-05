package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO extends DAO {

    public List<String> getAllCatalogNames() throws Exception {
        List<String> catalogNames = new ArrayList<>();

        // データベース接続
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT NAME FROM CATALOG");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            catalogNames.add(rs.getString("NAME"));
        }

        return catalogNames;
    }
}
