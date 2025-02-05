package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentClass;

/**
 * student_classテーブルにアクセスするDAO
 */
public class Student_ClassDAO extends DAO {

    /**
     * STUDENT_CLASS の ID と NUMBER を取得
     */
    public List<StudentClass> getStudentClasses() throws Exception {
        List<StudentClass> list = new ArrayList<>();

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT ID, NUMBER FROM STUDENT_CLASS");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            StudentClass sc = new StudentClass();
            sc.setClassId(rs.getInt("ID"));
            sc.setNumber(rs.getInt("NUMBER"));
            list.add(sc);
        }

        return list;
    }
}
