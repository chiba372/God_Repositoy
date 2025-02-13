package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bean.Event;

public class EventDAO extends DAO {
	//
	//
	// 指定の1か月のイベントを取得
	public List<Integer> oneMonth(int year, int month) throws Exception {
		Date fastMonth =new Date(year-1900, month-1, 1) ;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);

		Date endMonth =new Date(year-1900, month-1, lastDayOfMonth) ;

		List<Integer> list = new ArrayList<Integer>();
		// データベースに接続
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select distinct date from event where date between ? and ? order by date");
        st.setDate(1,  fastMonth);
        st.setDate(2,  endMonth);

		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			Date day = rs.getDate("date") ;
			list.add(day.getDate());
		}
		st.close();
		con.close();

		return list;
	}
	// 指定の一日のイベントを取得
	public List<Event> oneDay(int year, int month, int day) throws Exception {
		Date searchDate =new Date(year-1900, month-1, day) ;

		List<Event> list = new ArrayList<Event>();
		// データベースに接続
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from event where date = ?");
        st.setDate(1,  searchDate);

		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while (rs.next()) {
			Event e = new Event();
			e.setId(rs.getString("id"));
			e.setDate(rs.getDate("date"));
			e.setName(rs.getString("name"));
			e.setContent(rs.getString("content"));
			e.setGrade(rs.getInt("grade"));

			list.add(e);
		}
		st.close();
		con.close();

		return list;
	}

	// イベントを追加
	public int insert(Event event) throws Exception {
		Connection con = getConnection();

		// データベースを使った処理を記述
		PreparedStatement st = con.prepareStatement(
				"insert into event(ID, DATE, NAME, CONTENT) values(?, ?, ?, ?)");
		st.setString(1,event.getId());
		st.setDate(2, event.getDate());
		st.setString(3, event.getName());
		st.setString(4,event.getContent());

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	// イベントを編集
	public int update(Event event) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"update event set name = ?, content = ? where id = ?");
		st.setString(1, event.getName());
		st.setString(2,event.getContent());
		st.setString(3,event.getId());

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

	// 追加か編集かを判断
	public int updateAndInsert(List<Event> list) throws Exception {

		Connection con = getConnection();

		for (Event event : list) {
			PreparedStatement st = con.prepareStatement(
					"select id from event where id = ?");
			st.setString(1,event.getId());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int a = update(event);
			}else {
				int a = insert(event);
			}
			st.close();
		}
		con.close();

		return 1;
	}
}
