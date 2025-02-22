package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.StudentJoinClass;

public class StudentJoinClassDAO extends DAO {

	public List<StudentJoinClass> gradeAll(int grade) throws Exception {
		// 学生リスト
		List<StudentJoinClass> list = new ArrayList<StudentJoinClass>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select s.id, s.name, class_no"
				+ " from student s join student_class c on s.id = c.id"
				+ " where  grade = ?");
		st.setInt(1, grade);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			StudentJoinClass s = new StudentJoinClass();
			s.setId(rs.getString("id"));
			s.setName(rs.getString("name"));
			s.setClass_no(rs.getInt("class_no"));
			list.add(s);
		}

		st.close();
		con.close();
		// 学生リストを返却
		return list;
	}

	public List<StudentJoinClass> gradeAllClassNoASC(int grade) throws Exception {
		// 学生リスト
		List<StudentJoinClass> list = new ArrayList<StudentJoinClass>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select s.id, s.name, class_no"
				+ " from student s join student_class c on s.id = c.id"
				+ " where grade = ? and class_no != 0 order by class_no ");
		st.setInt(1, grade);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			StudentJoinClass s = new StudentJoinClass();
			s.setId(rs.getString("id"));
			s.setName(rs.getString("name"));
			s.setClass_no(rs.getInt("class_no"));
			list.add(s);
		}

		st.close();
		con.close();
		// 学生リストを返却
		return list;
	}

	public List<String> classAllNameASC(int grade, int class_no)throws Exception  {
		List<String> list = new ArrayList<String>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select s.id"
				+ " from student s join student_class c on s.id = c.id"
				+ " where grade = ? and class_no = ? order by name");
		st.setInt(1, grade);
		st.setInt(2, class_no);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			list.add(rs.getString("id"));
		}

		st.close();
		con.close();

		return list;
	}

}
