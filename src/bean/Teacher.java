package bean;

import java.io.Serializable;

public class Teacher implements Serializable {
    // ID（主キー）をString型に変更
    private String id;
    // ログイン名
    private String name;
    // パスワード
    private String password;

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
}
