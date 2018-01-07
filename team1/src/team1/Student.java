package team1;
/**
 * 创建Student实体类，用于存储传递数据
 * @author ghjhh
 *
 */
public class Student {
	private String name;
	private String studentId;
	private int mathScore;
	private int computerScore;
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

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getComputerScore() {
		return computerScore;
	}

	public void setComputerScore(int computerScore) {
		this.computerScore = computerScore;
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
