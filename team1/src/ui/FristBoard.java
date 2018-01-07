package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FristBoard {
	/**
	 * 主界面，提供单人查找和查找全部两个功能的按钮
	 * @throws SQLException
	 */
	public static void fristBoard()throws SQLException{
		JFrame frame = new JFrame();
	       JPanel panel = new JPanel();
	       frame.add(panel);
	       JButton button = new JButton("查询全部");
	       button.setSize(20,20);
	       /**
	        * 查找全部成绩的按钮响应
	        */
	       button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					FindAllBoard.findAllBoard(frame);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	   
	       });
	       JButton button1 = new JButton("查询单个");
	       button1.setSize(20,20);
	       JTextField text = new JTextField("要查询的学号");
	       /**
	        * 查找单个成绩的按钮响应
	        */
	       button1.addActionListener(new ActionListener(){

	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			// TODO Auto-generated method stub
	   			try {
	   				String studentId = text.getText();
	   				FindOneBoard.findOneBoard(frame,studentId);
	   			} catch (SQLException e1) {
	   				// TODO Auto-generated catch block
	   				e1.printStackTrace();
	   			}
	   		}
	       	   
	          });
	       panel.add(button1);
	       panel.add(text);
	       panel.add(button);
	       
			frame.setSize(600,800);
			frame.setVisible(true);
	}
}
