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
				+ " where  = ?");
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
}
