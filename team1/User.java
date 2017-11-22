package team1;

public class User {
	private String Account;
	private String psw;
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public User(String account, String psw) {
		super();
		Account = account;
		this.psw = psw;
	}
	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}
}
