package team1;
/**
 * 创建Student实体类，用于存储传递数据
 * @author ghjhh
 *
 */
public class Student {
	private String name;
	private String studentId;
	private int math_score;
	private int computer_score;
	private String choose; 
	private int getScore;
	
	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getMath_score() {
		return math_score;
	}

	public void setMath_score(int math_score) {
		this.math_score = math_score;
	}

	public int getComputer_score() {
		return computer_score;
	}

	public void setComputer_score(int computer_score) {
		this.computer_score = computer_score;
	}

	public int getGetScore() {
		return getScore;
	}

	public void setGetScore(int getScore) {
		this.getScore = getScore;
	}

	public Student() {
		super();
		// TODO 自动生成的构造函数存根
	}
}
