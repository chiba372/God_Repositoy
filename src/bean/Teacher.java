package bean;

import java.io.Serializable;

public class Teacher implements Serializable {
	// ID（主キー）
	private int id;
	// ログイン名
	private String name;
	// 生パスワード
	private String password;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
