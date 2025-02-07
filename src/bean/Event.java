package bean;

import java.io.Serializable;
import java.sql.Date;

public class Event implements Serializable {
    // ID（主キー
    private String id;
    // 日付
    private Date date;
    // ログイン名
    private String name;
    // パスワード
    private String content;
    // 学年
    private int grade;


    public String getId() {
        return id;
    }
    public Date getDate() {
		return date;
	}
    public String getName() {
        return name;
    }
    public String getContent() {
		return content;
	}
    public int getGrade() {
		return grade;
	}


    public void setId(String id) {
        this.id = id;
    }
    public void setDate(Date date) {
		this.date = date;
	}
    public void setName(String name) {
        this.name = name;
    }

	public void setContent(String content) {
		this.content = content;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}



}
