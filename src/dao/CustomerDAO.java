package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bean.Teacher;

public class CustomerDAO extends DAO {
	/**
	 * ログイン名とパスワードでDBを検索するメソッド
	 *
	 * @param login
	 * @param password
	 * @return 一致するデータが存在する：Customer、存在しない：null
	 * @throws Exception
	 */
	public Teacher search(String name, String password) throws Exception {
		Teacher teacher = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("select * from teacher where name=? and password=?");
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			teacher = new Teacher();
			teacher.setId(rs.getInt("id"));
			teacher.setName(rs.getString("name"));
			teacher.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return teacher;
	}

	/**
	 * ユーザーを登録する
	 *
	 * @param login
	 * @param hashedPassword
	 * @return 成功:1, 失敗:0
	 * @throws Exception
	 */
	public int insert(String name, String hashedPassword) throws Exception {

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("insert into teacher values(null, ?, ?)");
		st.setString(1, name);
		st.setString(2, hashedPassword);
		int line = st.executeUpdate();

		return line;
	}

	/**
	 * ログインIDとパスワードで認証する
	 *
	 * @param login
	 * @param password
	 * @return 認証成功:Customer, 認証失敗:null
	 * @throws Exception
	 */
	public Teacher name(String name, String password) throws Exception {

		Connection con = getConnection();

		// ログイン名をもとにユーザーを検索
		PreparedStatement st;
		st = con.prepareStatement("select * from teacher where name=?");
		st.setString(1, name);
		ResultSet rs = st.executeQuery();

		// ログイン名が一致するユーザーが存在した場合
		if (rs.next()) {
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			// 生パスワードと、DBに保存されたパスワードのハッシュ値を比較
			if (bcpe.matches(password, rs.getString("password"))) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setName(rs.getString("name"));
				return teacher;
			}
		}

		// ログイン名が違う、またはパスワードが違う場合
		return null;
	}
}
