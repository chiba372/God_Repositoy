package bean;

public class Catalog {
    private int id;
    private String name;
    private int grade;
    private boolean isValid;
    private String image;

    // ゲッター・セッター
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    public boolean getIsValid() { return isValid; }
    public void setIsValid(boolean isValid) { this.isValid = isValid; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
