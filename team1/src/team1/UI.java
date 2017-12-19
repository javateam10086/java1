package team1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * 入口函数，创建对应的FlowLayoutWindow对象
 * @author ghjhh
 *
 */
public class UI {
	public static void main(String[] args) {
		FlowLayoutWindow window =new FlowLayoutWindow();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
	
}
/**
 * 完成面板设计，创建三个文本框，输入学号，点击按钮查询学科返回对应成绩
 * @author ghjhh
 *
 */
class FlowLayoutWindow extends JFrame{
	FlowLayoutWindow(){
		setLayout(new FlowLayout());	
		Student student = new Student();
		MyFind find = new MyFind();
		JTextField text = new JTextField("学号",10);
		JTextField text1 = new JTextField("学科",10);
		JTextField text2 = new JTextField("成绩",10);
		add(text);
		add(text1);
		add(text2);
		JButton button = new JButton("查询");
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				student.setStudentId(text.getText());
				student.setChoose(text1.getText());
				Student res;
				try {
					if(student.getChoose().equals("数学")){
						 res = find.findMathScore(student);
					}else{
						res = find.findComputerScore(student);
					}
					text2.setText(String.valueOf(res.getGetScore()));;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
     			
			}	
		    });
	}
}
