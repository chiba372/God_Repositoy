package bean;

import java.util.Date;

public class Health {

    private String name;
    private Date date;
    private float normal_Temp;
    private float today_Temp;
    private boolean excuse;
    private String notes;

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

    // normal_Temp フィールドの値を返すように修正
    public float getNormal_Temp() {
        return normal_Temp;  // 修正: フィールド値を返す
    }

    public void setNormal_Temp(float normal_Temp) {
        this.normal_Temp = normal_Temp;
    }

    public float getToday_Temp() {
        return today_Temp;
    }

    public void setToday_Temp(float today_Temp) {
        this.today_Temp = today_Temp;
    }

    public boolean getExcuse() {
        return excuse;  // 修正: フィールドの値を返すように修正
    }

    public void setExcuse(boolean excuse) {
        this.excuse = excuse;  // 修正: 変数名のキャピタライズを統一
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
