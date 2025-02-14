package bean;

import java.util.Date;

public class Allpost {
    private Date date; // 日付
    private String name; // 件名
    private String content; // 内容

    // Getter と Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
