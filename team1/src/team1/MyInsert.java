package team1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JDBCUtil;
import util.JDBCUtil.Insert;

public class MyInsert implements Insert{
	/**
	 * 实现insert方法
	 */
	@Override
	public boolean insert(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "INSERT INTO scoretable (NAME,student_Id,math_score,computer_score) VALUES (?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,student.getName());
		pre.setString(2,student.getStudentId());
		pre.setInt(3,student.getMathScore());
		pre.setInt(4,student.getComputerScore());
		int result = pre.executeUpdate();
		pre.close();
		conn.close();
		return true;
	}
	
}
