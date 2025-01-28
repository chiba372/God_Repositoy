package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Allpost;

/**
 * POSTテーブルにアクセスするDAO
 */
public class AllpostDAO extends DAO {

    /**
     * 全ての投稿を取得する
     */
    public List<Allpost> all() throws Exception {
        List<Allpost> list = new ArrayList<Allpost>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM POST");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Allpost p = new Allpost();
            p.setDate(rs.getDate("DATE"));
            p.setName(rs.getString("NAME"));
            p.setContent(rs.getString("CONTENT"));
            list.add(p);
        }
        return list;
    }

    /**
     * 新しい投稿をデータベースに挿入する
     */
    public void insertPost(Allpost post) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO POST (DATE, NAME, CONTENT) VALUES (?, ?, ?)");
        st.setDate(1, new java.sql.Date(post.getDate().getTime()));
        st.setString(2, post.getName());
        st.setString(3, post.getContent());
        st.executeUpdate();
    }

    /**
     * 特定の件名と日付を持つ投稿を削除する
     */
    public void deletePostByNameAndDate(String name, Date date) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("DELETE FROM POST WHERE NAME = ? AND DATE = ?");
        st.setString(1, name);
        st.setDate(2, new java.sql.Date(date.getTime()));
        st.executeUpdate();
    }
}
