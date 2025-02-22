package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentClass;
import bean.StudentClass2;

/**
 * student_classテーブルにアクセスするDAO
 */
public class Student_ClassDAO2 extends DAO {

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
    // クラスの数を取得
    public int maxClassNo(int grade) throws Exception {
    	int classNo = 0;

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
        		"SELECT MAX(CLASS_NO)AS CLASS_NO  FROM STUDENT_CLASS WHERE GRADE = ?");
		st.setInt(1, grade);

        ResultSet rs = st.executeQuery();

		if (rs.next()) {
			classNo = rs.getInt("CLASS_NO");
		};

		st.close();
		con.close();

        return classNo;
	}

    // 児童を複数編集
    public int inserts(List<StudentClass2> list) throws Exception {
  		Connection con = getConnection();

  		for (StudentClass2 s : list){
  	  		PreparedStatement st = con.prepareStatement(
  	  				"update student_class set class_no = ? where id = ?");

  			st.setInt(1,s.getClass_no());
  			st.setString(2, s.getId());
  			st.executeUpdate();

  	  		st.close();

  		}

  		con.close();
  		return 1;
  	}


	public int setNumber(List<String> list) throws Exception  {
	Connection con = getConnection();
		int number = 1;

		for (String id : list){
			PreparedStatement st = con.prepareStatement(
				"update student_class set number = ? where id = ?");

			st.setInt(1, number);
			st.setString(2, id);
			st.executeUpdate();

			st.close();
			number++;
		}

		con.close();
    	return 1;
	}
	public int delNumber() throws Exception  {
	Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
			"update student_class set number = 0 where class_no = 0");
		st.executeUpdate();

		st.close();
		con.close();
    	return 1;
	}
}
