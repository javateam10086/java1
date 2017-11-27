package team1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class MyFind implements Find{

	@Override
	public String findInFile(User user) {
		// TODO 自动生成的方法存根
		ArrayList<User> list = new ArrayList<User>();
			try {
				BufferedReader reader = new BufferedReader(new FileReader("datas.txt"));
				String str;
				while ((str = reader.readLine()) != null) {
					User stu = new User();
					String account = str.split(" ")[0];
					String psw = str.split(" ")[1];
					stu.setAccount(account);
					stu.setPsw(psw);
					list.add(stu);
				}
				for(User user1:list){
					if(user1.getAccount().equals(user.getAccount())){
						if(user1.getPsw().equals(user.getPsw())){
							return "对的";
						}else{
							return "错的";
						}
					}else{
						return "错的";
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return null;
	}
}
