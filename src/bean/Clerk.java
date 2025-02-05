package bean;

import java.io.Serializable;

public class Clerk implements Serializable {
	private int id; // ID
	private String name; // 事務員名
	private String password; // セキュリティコード

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}