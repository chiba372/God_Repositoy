package bean;

import java.io.Serializable;

public class PurchaseInfo implements Serializable{
	private int productId;
	private String productName;
	private String studentId;
	private String studentName;
	private int grade;
	private int classNo;
	private int proQua;
	private int total;


	public PurchaseInfo(int productId, String productName, String studentId, String studentName, int grade, int classNo, int proQua, int total) {
		this.productId = productId;
		this.productName = productName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.grade = grade;
		this.classNo = classNo;
		this.proQua = proQua;
		this.total = total;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStudentId(){
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getProQua() {
		return proQua;
	}
	public void setProQua(int proQua) {
		this.proQua = proQua;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
