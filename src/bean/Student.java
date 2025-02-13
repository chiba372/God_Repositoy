package bean;

import java.io.Serializable;

public class Student implements Serializable {
	// ID（主キー）
	private String id;
	// ログイン名
	private String name;
	// 生パスワード
	private String password;
	//mail
	private String email;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
