package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bean.Customer;

public class CustomerDAO extends DAO {
	/**
	 * ログイン名とパスワードでDBを検索するメソッド
	 *
	 * @param login
	 * @param password
	 * @return 一致するデータが存在する：Customer、存在しない：null
	 * @throws Exception
	 */
	public Customer search(String login, String password) throws Exception {
		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("select * from customer where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();

		return customer;
	}

	/**
	 * ユーザーを登録する
	 *
	 * @param login
	 * @param hashedPassword
	 * @return 成功:1, 失敗:0
	 * @throws Exception
	 */
	public int insert(String login, String hashedPassword) throws Exception {

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement("insert into customer values(null, ?, ?)");
		st.setString(1, login);
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
	public Customer login(String login, String password) throws Exception {

		Connection con = getConnection();

		// ログイン名をもとにユーザーを検索
		PreparedStatement st;
		st = con.prepareStatement("select * from customer where login=?");
		st.setString(1, login);
		ResultSet rs = st.executeQuery();

		// ログイン名が一致するユーザーが存在した場合
		if (rs.next()) {
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			// 生パスワードと、DBに保存されたパスワードのハッシュ値を比較
			if (bcpe.matches(password, rs.getString("password"))) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setLogin(rs.getString("login"));
				return customer;
			}
		}

		// ログイン名が違う、またはパスワードが違う場合
		return null;
	}
}
