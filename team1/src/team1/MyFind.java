package team1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class MyFind implements Find{
	/**
	 * 用jdbc实现findMathScore方法，得到数学成绩赋给student的getScore属性
	 */
	@Override
	public Student findMathScore(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "SELECT math_score FROM scoretable WHERE student_Id = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,student.getStudentId());
		ResultSet result = pre.executeQuery();
		if(result.next()){
			student.setGetScore(result.getInt("math_score")); 
		}
		pre.close();
		conn.close();
		return student;
	}
	/**
	 * 用jdbc实现findComputerScore方法，得到计算机成绩赋给student的getScore属性
	 */
	@Override
	public Student findComputerScore(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "SELECT computer_score FROM scoretable WHERE student_Id = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,student.getStudentId());
		ResultSet result = pre.executeQuery();
		if(result.next()){
			student.setGetScore(result.getInt("computer_score")); 
		}
		pre.close();
		conn.close();
		return student;
	}
}
