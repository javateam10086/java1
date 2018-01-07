package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.MyDelete;
import dao.MyFind;
import team1.Student;

public class FindAllBoard {
	/**
	 * 查找全部数据，提供增删功能的按钮
	 * @param frame
	 * @throws SQLException
	 */
	static void findAllBoard(JFrame frame) throws SQLException{
		frame.setVisible(false);
		JFrame frame1 = new JFrame();
		MyFind myFind = new MyFind();
		MyDelete myDelete = new MyDelete();
		JButton button2 = new JButton("增加");
		JButton button3 = new JButton("删除");
		JButton button4 = new JButton("返回");
		JTextField text = new JTextField("要删除的学号");
		button2.setSize(10,10);
		button3.setSize(10,10);
		button4.setSize(10,10);
		/**
		 * 增加数据按钮的响应
		 */
		button2.addActionListener(new ActionListener(){

	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			// TODO Auto-generated method stub
	   			try {
	   				InsertBoard.insertBoard(frame1);
	   				
	   			} catch (SQLException e1) {
	   				// TODO Auto-generated catch block
	   				e1.printStackTrace();
	   			}
	   		}
	       	   
	          });
		/**
		 * 删除数据按钮的响应
		 */
		button3.addActionListener(new ActionListener(){

	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			// TODO Auto-generated method stub
	   			try {
	   				Student student = new Student();
	   				student.setStudentId(text.getText());
	   				myDelete.delete(student);
	   				findAllBoard(frame1);
	   			} catch (SQLException e1) {
	   				// TODO Auto-generated catch block
	   				e1.printStackTrace();
	   			}
	   		}
	       	   
	          });
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
		/**
		 * 得到数据，制作表格，展示全部数据
		 */
		ArrayList<Student> list = myFind.findAll();
       Vector<Vector<Object>> studentData = new Vector<Vector<Object>>();
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("行号");
		columnNames.add("姓名");
		columnNames.add("学号"); 
		columnNames.add("计算机");
		columnNames.add("数学");
		for(int i = 0;i<list.size();i++) {
			Vector<Object> row1 = new Vector<Object>();
			row1.add(i+1);
			row1.add(list.get(i).getName());
			row1.add(list.get(i).getStudentId());
			row1.add(list.get(i).getComputerScore());
			row1.add(list.get(i).getMathScore());
			
			studentData.add(row1);
		}
		/**
		 * 排序的实现
		 */
        TableModel model = new DefaultTableModel(studentData, columnNames);
        JTable table = new JTable(model);
        RowSorter sorter = new TableRowSorter(model);
        table.setRowSorter(sorter);
        JScrollPane pane = new JScrollPane(table);
        frame1.add(pane, BorderLayout.CENTER);
        frame1.setSize(300, 150);
        frame1.setVisible(true);
        JPanel panel = new JPanel();
        panel.add(button2);
        panel.add(button3);
        panel.add(text);
        panel.add(button4);
        frame1.add(panel,BorderLayout.NORTH);
        frame1.setSize(600,800);
		frame1.setVisible(true);
	}
}
