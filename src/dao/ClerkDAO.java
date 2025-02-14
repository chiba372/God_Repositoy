package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;

public class ClerkDAO extends DAO{
	public List<String> getAllClerkNames() {
		List<String> names = new ArrayList<>();
		String sql = "SELECT NAME FROM CLERK";

		try (Connection con = DbUtil.getConnection();
			  PreparedStatement pst = con.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				names.add(rs.getString("NAME"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return names;
	}
}

