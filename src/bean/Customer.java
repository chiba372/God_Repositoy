package bean;

import java.io.Serializable;

public class Customer implements Serializable {
	// ID（主キー）
	private int id;
	// ログイン名
	private String login;
	// 生パスワード
	private String password;

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
