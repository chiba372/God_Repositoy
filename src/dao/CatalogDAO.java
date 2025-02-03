package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO extends DAO {

    // Catalogテーブルから全ての教材名を取得するメソッド
    public List<String> getAllCatalogNames() throws Exception {
        List<String> catalogNames = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT NAME FROM CATALOG");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            catalogNames.add(rs.getString("NAME"));
        }

        return catalogNames;
    }

    // NAMEに関連するSTUDENT_CLASSとNUMBERを取得するメソッド
    public List<String[]> getClassAndNumberByName(String name) throws Exception {
        List<String[]> classAndNumberList = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT STUDENT_CLASS, NUMBER FROM CATALOG WHERE NAME = ?");
        st.setString(1, name);  // 引数として受け取った教材名をセット
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String[] classAndNumber = new String[2];
            classAndNumber[0] = rs.getString("STUDENT_CLASS");
            classAndNumber[1] = rs.getString("NUMBER");
            classAndNumberList.add(classAndNumber);
        }

        return classAndNumberList;
    }
}
