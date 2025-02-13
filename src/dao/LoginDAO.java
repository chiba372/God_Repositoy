package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bean.Student;
import util.DbUtil;

public class LoginDAO extends DAO {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 指定されたIDに基づいて事務員情報を検索するメソッド
    public Student searchByID(String id) throws Exception {
        Student student = null;
        // データベース接続を取得
        Connection con = getConnection();
        // 指定されたIDに基づいて事務員情報を検索するSQL文を準備
        PreparedStatement st = con.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
        st.setString(1, id);
        // SQL文を実行し、結果セットを取得
        ResultSet rs = st.executeQuery();
        // 結果セットから事務員情報を抽出し、Clerkオブジェクトを作成
        if (rs.next()) {
            student = new Student();
            student.setId(rs.getString("ID"));
            student.setPassword(rs.getString("PASSWORD"));
        }
        // リソースをクローズ
        rs.close();
        st.close();
        con.close();
        return student;
    }

    /**
     * 学生IDとパスワードでユーザーを検索（ログイン認証）
     * @param Id 児童ID
     * @param password 平文のパスワード
     * @return 認証成功した場合はHogosyaオブジェクト、失敗時はnull
     * @throws Exception
     */
    public Student search(String id, String password) throws Exception {
        Student hogosya = null;

        // データベース接続
        Connection con = DbUtil.getConnection();

        PreparedStatement st;
        st = con.prepareStatement("SELECT * FROM STUDENT WHERE ID = ? AND PASSWORD = ?");
        st.setString(1, id);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            String storedPassword = rs.getString("PASSWORD"); // ハッシュ化されたパスワード
            hogosya = new Student();
            hogosya.setId(rs.getString("ID"));
            hogosya.setPassword(storedPassword); // ハッシュ化されたパスワードをセット
        }

        // クローズ処理
        rs.close();
        st.close();
        con.close();

        return hogosya;
    }

    /**
     * 新しい保護者アカウントを登録
     * @param studentId 児童番号
     * @param plainPassword 平文のパスワード
     * @return 登録成功した場合1、それ以外は0
     * @throws Exception
     */
//    public int insert(int Id, String plainPassword) throws Exception {
//        String hashedPassword = passwordEncoder.encode(plainPassword); // パスワードをハッシュ化
//
//        Connection con = getConnection();
//        PreparedStatement st = con.prepareStatement("INSERT INTO hogosya (id, password) VALUES (?, ?)");
//        st.setString(1, Id);
//        st.setString(2, hashedPassword);
//        int result = st.executeUpdate();
//
//        // クローズ処理
//        st.close();
//        con.close();
//
//        return result;
//    }
}

