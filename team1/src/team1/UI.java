package team1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UI {
	public static void main(String[] args) {
		FlowLayoutWindow window =new FlowLayoutWindow();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
	
}
class FlowLayoutWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3937967043739601992L;

	FlowLayoutWindow(){
		setLayout(new FlowLayout());	
		User user = new User();
		MyFind find = new MyFind();
		JTextField text = new JTextField("账户",10);
		JTextField text1 = new JTextField("密码",10);
		add(text);
		add(text1);
		JButton button = new JButton("ok");
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				user.setAccount(text.getText());
				user.setPsw(text1.getText());
				String res = find.findInFile(user);
     			System.out.println(res);
			}	
		    });
	}
}
