package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��������ȡ
 * ��������
 * �ر�����
 * 
 * ���ݿ�������һ�������ܵ����飬�����ݿ��������ɵ���ģʽ
 * һ�����Ӷ���-----����SQL���
 *  
 * @author admin
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
	 * ���߷�����
	 * @param sql �������sql��䣬insert/update/delete
	 * @param params	���������ֵ
	 */
	public static void executeUpdate(String sql,String[] params){
		Connection conn = getInstance().getConnection();
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);//insert ???
			if(params!=null&&params.length>0){
				for(int i=1;i<=params.length;i++){
					pre.setString(i, params[i-1]);//�����󶨵Ĳ��������Ǵ�1��ʼ�ģ�����������Ǵ�0��ʼ��
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
}
