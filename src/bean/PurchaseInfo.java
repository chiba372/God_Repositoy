package bean;

import java.io.Serializable;

public class PurchaseInfo implements Serializable{
	private int productId;
	private String productName;
	private int studentId;
	private String studentName;
	private int grade;
	private int proQua;
	private int total;

	public PurchaseInfo(int productId, String productName, int studentId, String studentName, int grade, int proQua, int total) {
		this.productId = productId;
		this.productName = productName;
		this.studentId = studentId;
		this.studentName = studentName;
		this.grade = grade;
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
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
