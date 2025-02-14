//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//import bean.Student;
//
///**
// * 学生テーブルにアクセスするDAO
// * @author s_yajima
// *
// */
//public class StudentDAO2 extends DAO {
//	/**
//	 * 学生をすべて取得する
//	 * @return 学生のリスト
//	 * @throws Exception
//	 */
//	public List<Student> all() throws Exception {
//		// 学生リスト
//		List<Student> list = new ArrayList<Student>();
//
//		Connection con = getConnection();
//		PreparedStatement st = con.prepareStatement("select * from student");
//		ResultSet rs = st.executeQuery();
//
//		while (rs.next()) {
//			Student s = new Student();
//			s.setId(rs.getInt("id"));
//			s.setName(rs.getString("name"));
//			list.add(s);
//		}
//
//		// 学生リストを返却
//		return list;
//	}
//
//	public int insrat(Student student) throws Exception {
//		Connection con = getConnection();
//
//		// データベースを使った処理を記述
//		PreparedStatement st = con.prepareStatement(
//				"insert into student(NAME,GRADE,IMAGE) values(?, ?, ?)");
//		st.setString(1,student.getName());
//
//		int line=st.executeUpdate();
//
//
//		// データベースとの接続を解除（必ず書く！！！！！！！！）
//		st.close();
//		con.close();
//
//		return line;
//	}
//
//}
