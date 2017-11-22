package team1;

import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		User user = new User();
		MyFind find = new MyFind();
		System.out.println("请输入账户");
		user.setAccount(in.next());
		System.out.println("请输入密码");
		user.setPsw(in.next());
		String res = find.findInFile(user);
		System.out.println(res);
	}
}
