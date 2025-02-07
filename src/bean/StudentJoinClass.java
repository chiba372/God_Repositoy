package bean;

import java.io.Serializable;

public class StudentJoinClass implements Serializable {
	//
	private String id;
	// 名前
	private String name;

	private int grade;
	// クラス
	private int class_no;
	// 出席番号
	private int number;


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public int getClass_no() {
		return class_no;
	}
	public int getNumber() {
		return number;
	}


	public void setId(String string) {
		this.id = string;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
