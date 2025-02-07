package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Teacher2;

public class TeacherDAO extends DAO {

	public List<Teacher2> all() throws Exception {
		List<Teacher2> list = new ArrayList<Teacher2>();

		// データベースに接続
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from teacher");
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			Teacher2 p = new Teacher2();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			p.setClass_no(rs.getString("class_no"));
			p.setIs_master(rs.getBoolean("is_master"));

			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return list;
	}

	public int updateClassNo(List<Teacher2> list) throws Exception {
		Connection con = getConnection();

		for (Teacher2 teacher : list) {
			PreparedStatement st = con.prepareStatement(
					"update teacher set class_no = ? where id = ?");
			st.setString(1,teacher.getClass_no());
			st.setString(2, teacher.getId());

			int line=st.executeUpdate();

			st.close();
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		con.close();

		return 1;
	}

	public int update(Teacher2 teacher) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"update teacher set name = ?, password = ?, is_master = ? where id = ?");
		st.setString(1, teacher.getName());
		st.setString(2,teacher.getPassword());
		st.setBoolean(3, teacher.isIs_master());
		st.setString(4,teacher.getId());

		int line=st.executeUpdate();

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return line;
	}

	public int insert(Teacher2 teacher) throws Exception {
		Connection con = getConnection();

		// データベースを使った処理を記述
		PreparedStatement st = con.prepareStatement(
				"insert into teacher(id, name, password, is_master) values(?, ?, ?, ?)");
		st.setString(1,teacher.getId());
		st.setString(2, teacher.getName());
		st.setString(3,teacher.getPassword());
		st.setBoolean(4, teacher.isIs_master());

		int line=st.executeUpdate();

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return line;
	}
	public int updateAndInsert(List<Teacher2> list) throws Exception {

		Connection con = getConnection();

		for (Teacher2 teacher : list) {
			PreparedStatement st = con.prepareStatement(
					"select id from teacher where id = ?");
			st.setString(1,teacher.getId());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int a = update(teacher);
			}else {
				int a = insert(teacher);
			}
			st.close();
		}
		// データベースとの接続を解除（必ず書く！！！！！！！！）
		con.close();

		return 1;
	}

}
