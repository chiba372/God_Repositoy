package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Clerk;
import util.DbUtil;

public class ClerkloginDAO extends DAO{

    // 指定されたIDに基づいて事務員情報を検索するメソッド
    public Clerk searchByID(int id) throws Exception {
        Clerk clerk = null;
        // データベース接続を取得
        Connection con = getConnection();
        // 指定されたIDに基づいて事務員情報を検索するSQL文を準備
        PreparedStatement st = con.prepareStatement("SELECT * FROM CLERK WHERE ID=?");
        st.setInt(1, id);
        // SQL文を実行し、結果セットを取得
        ResultSet rs = st.executeQuery();
        // 結果セットから事務員情報を抽出し、Clerkオブジェクトを作成
        if (rs.next()) {
            clerk = new Clerk();
            clerk.setId(rs.getInt("ID"));
            clerk.setPassword(rs.getString("PASSWORD"));
            clerk.setName(rs.getString("NAME"));
        }
        // リソースをクローズ
        rs.close();
        st.close();
        con.close();
        return clerk;
    }

    // 指定されたIDとパスワードに基づいて認証を行うメソッド
    public Clerk authenticate(int id, String password) throws Exception {
        Clerk clerk = null;
        // データベース接続を取得
        Connection con = DbUtil.getConnection();
        // 指定されたIDとパスワードに基づいて事務員情報を検索するSQL文を準備
        PreparedStatement pst = con.prepareStatement("SELECT * FROM CLERK WHERE ID=? AND PASSWORD=?");
        pst.setInt(1, id);
        pst.setString(2, password);
        // SQL文を実行し、結果セットを取得
        ResultSet rs = pst.executeQuery();
        // 結果セットから事務員情報を抽出し、Clerkオブジェクトを作成
        if (rs.next()) {
            clerk = new Clerk();
            clerk.setId(rs.getInt("ID"));
            clerk.setPassword(rs.getString("PASSWORD"));
            clerk.setName(rs.getString("NAME"));
        }
        // リソースをクローズ
        rs.close();
        pst.close();
        con.close();
        return clerk;
    }

}
