//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import util.DbUtil;
//
//public class StudentDAO {
//
//    // 学年（GRADE）を取得するメソッド
//    public int getStudentGrade(String id) throws SQLException {
//        int grade = -1; // デフォルト値（データがない場合）
//
//        String sql = "SELECT sc.GRADE FROM STUDENT s " +
//                     "JOIN STUDENT_CLASS sc ON s.ID = sc.ID " +
//                     "WHERE s.ID = ?";
//
//        try (Connection conn = DbUtil.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, id);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                grade = rs.getInt("GRADE"); // GRADE を取得
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw e;
//        }
//        return grade;
//    }
//}
