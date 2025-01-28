package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Health;

/**
 * healthテーブルにアクセスするDAO
 */
public class HealthDAO extends DAO {
    
    /**
     * 健康状態をすべて取得する
     */
    public List<Health> all() throws Exception {
        // 健康状態リスト
        List<Health> list = new ArrayList<Health>();

        // データベース接続
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM health");
        ResultSet rs = st.executeQuery();

        // 結果セットをループしてHealthオブジェクトにセット
        while (rs.next()) {
            Health s = new Health();
            s.setName(rs.getString("name"));
            s.setDate(rs.getDate("date"));
            s.setNormal_Temp(rs.getFloat("normal_Temp"));
            s.setToday_Temp(rs.getFloat("today_temp"));
            s.setExcuse(rs.getBoolean("Excuse"));
            s.setNotes(rs.getString("notes"));
            list.add(s);
        }

        // 健康状態リストを返却
        return list;
    }
    
    /**
     * 特定の日付に関連する健康データを取得する
     */
    public List<Health> getHealthDataByDate(String date) throws Exception {
        // 特定の日付に関連する健康状態リスト
        List<Health> list = new ArrayList<Health>();

        // データベース接続
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM health WHERE date = ?");
        st.setString(1, date);  // SQLのクエリに日付をセット
        ResultSet rs = st.executeQuery();

        // 結果セットをループしてHealthオブジェクトにセット
        while (rs.next()) {
            Health s = new Health();
            s.setName(rs.getString("name"));
            s.setDate(rs.getDate("date"));
            s.setNormal_Temp(rs.getFloat("normal_Temp"));
            s.setToday_Temp(rs.getFloat("today_temp"));
            s.setExcuse(rs.getBoolean("Excuse"));
            s.setNotes(rs.getString("notes"));
            list.add(s);
        }

        // 健康状態リストを返却
        return list;
    }
}
