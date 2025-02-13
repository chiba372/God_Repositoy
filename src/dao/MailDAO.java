package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Student;

public class MailDAO extends DAO {

    // 指定されたIDに基づいて事務員情報を検索するメソッド
    public Student search(String email) throws Exception {
        Student student = null;
        // データベース接続を取得
        Connection con = getConnection();
        // 指定されたIDに基づいて事務員情報を検索するSQL文を準備
        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
        st.setString(1, email);
        // SQL文を実行し、結果セットを取得
        ResultSet rs = st.executeQuery();
        // 結果セットから事務員情報を抽出し、Clerkオブジェクトを作成
        if (rs.next()) {
            student = new Student();
            student.setEmail(rs.getString("EMAIL"));
            student.setName(rs.getString("NAME"));
        }
        // リソースをクローズ
        rs.close();
        st.close();
        con.close();
        return student;
    }

}