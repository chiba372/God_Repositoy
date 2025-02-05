package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class CustomerDAO extends DAO {

    /**
     * ログイン名とパスワードでDBを検索するメソッド
     *
     * @param id
     * @param password
     * @return 一致するデータが存在する：Teacher、存在しない：null
     * @throws Exception
     */
    public Teacher search(String id, String password) throws Exception {
        Teacher teacher = null;

        Connection con = getConnection();
        // idをString型として検索
        PreparedStatement st;
        st = con.prepareStatement("select * from teacher where id=? and password=?");
        st.setString(1, id);  // idはString型
        st.setString(2, password);  // パスワードもString型
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getString("id"));
            teacher.setName(rs.getString("name"));
            teacher.setPassword(rs.getString("password"));
        }

        st.close();
        con.close();

        return teacher;
    }

    // ユーザーを登録する
    public int insert(String id, String password) throws Exception {

        Connection con = getConnection();

        PreparedStatement st;
        st = con.prepareStatement("insert into teacher values(null, ?, ?)");
        st.setString(1, id);
        st.setString(2, password);
        int line = st.executeUpdate();

        return line;
    }
}
