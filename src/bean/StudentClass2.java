package bean;

public class StudentClass2 {
	//
	private String id;

	private int grade;
	// クラス
	private int class_no;
	// 出席番号
	private int number;


	public String getId() {
		return id;
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


	public void setId(String id) {
		this.id = id;
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