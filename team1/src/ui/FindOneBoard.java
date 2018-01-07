package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.MyFind;
import team1.Student;

public class FindOneBoard {
	/**
	 * 查找单个人的成绩
	 * @param frame
	 * @param studentId
	 * @throws SQLException
	 */
	static void findOneBoard(JFrame frame,String studentId) throws SQLException{
		frame.setVisible(false);
		JPanel panel = new JPanel();
		JFrame frame1 = new JFrame();
		MyFind myFind = new MyFind();
		JButton button4 = new JButton("返回");
		button4.setSize(10,10);
		/**
		 * 返回按钮的响应
		 */
		button4.addActionListener(new ActionListener(){

	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			// TODO Auto-generated method stub
	   			try {
	   				
	   				FristBoard.fristBoard();
	   				frame1.setVisible(false);
	   			} catch (SQLException e1) {
	   				// TODO Auto-generated catch block
	   				e1.printStackTrace();
	   			}
	   		}
	       	   
	          });
		
		Student student1 = new Student();
		student1.setStudentId(studentId);
		student1 = myFind.findScore(student1);
		/**
		 * 得到数据，制作表格，展示全部数据
		 */
Vector<Vector<Object>> studentData = new Vector<Vector<Object>>();
		
			Vector<Object> row1 = new Vector<Object>();
			row1.add(1);
			row1.add(student1.getName());
			row1.add(student1.getStudentId());
			row1.add(student1.getComputerScore());
			row1.add(student1.getMathScore());
			
			studentData.add(row1);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("行号");
		columnNames.add("姓名");
		columnNames.add("学号");
		columnNames.add("计算机");
		columnNames.add("数学");
        JTable table = new JTable(studentData,columnNames);
        panel.add(button4);
        frame1.add(panel,BorderLayout.SOUTH);
		JScrollPane scrollpane = new JScrollPane(table);
		frame1.add(scrollpane,BorderLayout.CENTER);
		frame1.setSize(600,800);
		frame1.setVisible(true);
	}
}
