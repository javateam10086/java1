package ui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import team1.MyInsert;
import team1.Student;

public class InsertBoard {
	/**
	 * 添加数据的界面
	 * @param frame
	 * @throws SQLException
	 */
static void insertBoard(JFrame frame) throws SQLException{
	frame.setVisible(false);
	JFrame frame1 = new JFrame();
	JPanel panel = new JPanel();
	GridLayout gridbag = new GridLayout(20,1);
	GridBagConstraints constraints = new GridBagConstraints();
	panel.setLayout(gridbag);
	constraints.fill = GridBagConstraints.BOTH;
	constraints.weightx = 1.0;
	//gridbag.setConstraints(panel, constraints);
	panel.add(new JLabel("姓名"));
	JTextField text = new JTextField();
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	panel.add(text);
	           
	constraints.gridwidth = GridBagConstraints.REMAINDER; //这是本行的最后一个
	//gridbag.setConstraints(panel,constraints);
	panel.add(new JLabel("学号"));
	panel.add(text1);
	constraints.weightx = 0.0;               //重新开始一行
	//gridbag.setConstraints(panel,constraints);
	panel.add(new JLabel("计算机"));
	panel.add(text2);
	panel.add(new JLabel("数学"));
	panel.add(text3);
	JPanel panel1 = new JPanel();
	JButton button = new JButton("提交");
	JButton button1 = new JButton("返回");
	MyInsert myInsert = new MyInsert();
	/**
	 * 添加提交按钮的响应
	 */
	button.addActionListener(new ActionListener(){

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			try {
   				Student student = new Student();
   				student.setName(text.getText());
   				student.setStudentId(text1.getText());
   				student.setComputerScore(Integer.parseInt(text2.getText()));
   				student.setMathScore(Integer.parseInt(text2.getText()));
   				myInsert.insert(student);
   				FindAllBoard.findAllBoard(frame1);
   			} catch (SQLException e1) {
   				// TODO Auto-generated catch block
   				e1.printStackTrace();
   			}
   		}
       	   
          });
	/**
	 * 添加返回按钮的响应
	 */
	button1.addActionListener(new ActionListener(){

   		@Override
   		public void actionPerformed(ActionEvent e) {
   			// TODO Auto-generated method stub
   			try {
   				
   				FindAllBoard.findAllBoard(frame1);
   			} catch (SQLException e1) {
   				// TODO Auto-generated catch block
   				e1.printStackTrace();
   			}
   		}
       	   
          });
	panel1.add(button);
	panel1.add(button1);
	
	panel.add(panel1);
	frame1.add(panel);
	
	frame1.setSize(600,800);
	frame1.setVisible(true);
}
}
