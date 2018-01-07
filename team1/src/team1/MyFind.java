package team1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.JDBCUtil;
import util.JDBCUtil.Find;

public class MyFind implements Find{
	/**
	 * 用jdbc实现findMathScore方法，得到所有人的成绩
	 */
	@Override
	public ArrayList<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "SELECT * from scoretable";
		PreparedStatement pre = conn.prepareStatement(sql);
		ResultSet result = pre.executeQuery();
		ArrayList<Student> list = new ArrayList<Student>();
		Student student;
		while(result.next()){
			student = new Student();
			student.setComputerScore(result.getInt("computer_score"));
			student.setMathScore(result.getInt("math_score"));
			student.setStudentId(result.getString("student_Id"));
			student.setName(result.getString("name"));
			list.add(student);
		}
		pre.close();
		conn.close();
		return list;
	}
	/**
	 * 用jdbc实现findComputerScore方法，得到单个人的成绩
	 */
	@Override
	public Student findScore(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getInstance().getConnection();
		String sql = "SELECT * FROM scoretable WHERE student_Id = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,student.getStudentId());
		ResultSet result = pre.executeQuery();
		if(result.next()){
			student.setComputerScore(result.getInt("computer_score"));
			student.setMathScore(result.getInt("math_score"));
			student.setStudentId(result.getString("student_Id"));
			student.setName(result.getString("name"));
		}
		pre.close();
		conn.close();
		return student;
	}
}
