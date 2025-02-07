package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.StudentJoinClass;

/**
 * 学生テーブルにアクセスするDAO
 * @author s_yajima
 *
 */
public class StudentJoinClassDAO extends DAO {
	/**
	 * 学生をすべて取得する
	 * @return 学生のリスト
	 * @throws Exception
	 */
	public List<StudentJoinClass> all() throws Exception {
		// 学生リスト
		List<StudentJoinClass> list = new ArrayList<StudentJoinClass>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select s.id, s.name, class_no"
				+ " from student s join student_class c on s.id = c.id");
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

	public int insrat(Student student) throws Exception {
		Connection con = getConnection();

		// データベースを使った処理を記述
		PreparedStatement st = con.prepareStatement(
				"insert into student(NAME,GRADE,IMAGE) values(?, ?, ?)");
		st.setString(1,student.getName());

		int line=st.executeUpdate();


		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return line;
	}

}
