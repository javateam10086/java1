package team1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JDBCUtil;
import util.JDBCUtil.Delete;

public class MyDelete implements Delete{
	/**
	 * 实现delete方法
	 */
	@Override
	public boolean delete(Student student) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * 建立连接
		 */
		Connection conn = JDBCUtil.getInstance().getConnection();
		/**
		 * 编写sql语句
		 */
		String sql = "DELETE FROM scoretable WHERE student_Id = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1,student.getStudentId());
		/**
		 * 执行，得到反馈结果
		 */
		int result = pre.executeUpdate();
		/**
		 * 关闭连接
		 */
		pre.close();
		conn.close();
		return true;
	}

}
