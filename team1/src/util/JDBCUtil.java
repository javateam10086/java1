package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import team1.Student;

/**
 * 创建JDBC连接的工具类
 * @author ghjhh
 *
 */
public class JDBCUtil {
	
	private static JDBCUtil jdbcUtil = new JDBCUtil();
	
	private Connection conn = null;
	
	private final String driverClass = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/studentmsg?useUnicode=true&characterEncoding=UTF8&useSSL=true";
	private final String userName = "root";
	private final String password = "w123321";
	private JDBCUtil(){
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JDBCUtil getInstance(){
		return jdbcUtil;
	}
	
	public Connection getConnection(){
		/*if(conn==null){
			try {
				conn = DriverManager.getConnection(url,userName,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(Connection conn){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sql
	 * @param params
	 */
	public static void executeUpdate(String sql,String[] params){
		Connection conn = getInstance().getConnection();
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);//insert ???
			if(params!=null&&params.length>0){
				for(int i=1;i<=params.length;i++){
					pre.setString(i, params[i-1]);//
				}
			}
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * delete功能的抽象接口
	 * @author ghjhh
	 *
	 */
	public interface Delete {
		/**
		 * 按学号删除数据
		 * @throws SQLException
		 */
		abstract boolean delete(Student student)throws SQLException;
	}
	/**
	 * find功能的抽象接口
	 * @author ghjhh
	 *
	 */
	public interface Find {
		/**
		 * 查找所有人成绩，完成后返回ArrayList对象
		 * @param student
		 * @return
		 * @throws SQLException
		 */
		abstract ArrayList<Student> findAll()throws SQLException;
		/**
		 * 传入Student对象,查找该生成绩，完成后返回该对象
		 * @param student
		 * @return
		 * @throws SQLException
		 */
		abstract Student findScore(Student student) throws SQLException;
	}
	/**
	 * insert功能抽象接口
	 * @author ghjhh
	 *
	 */
	public interface Insert {
		/**
		 * 插入一条数据
		 * @return
		 * @throws SQLException
		 */
		abstract boolean insert(Student student)throws SQLException;
	}
}
