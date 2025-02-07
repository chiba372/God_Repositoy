package bean;

import java.io.Serializable;

public class Teacher2 implements Serializable {
	// ID（主キー
	private String id;
	// ログイン名
	private String name;
	// パスワード
	private String password;
	// 担当クラス
	private String class_no;
	// 管理権限の有無
	private boolean is_master;


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getClass_no() {
		return class_no;
	}
	public boolean isIs_master() {
		return is_master;
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
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}
	public void setIs_master(boolean is_master) {
		this.is_master = is_master;
	}
}
