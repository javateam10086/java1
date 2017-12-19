package team1;

import java.sql.SQLException;

public interface Find {
	/**
	 * 传入Student对象,查找该生数学成绩，完成后返回该对象
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	abstract Student findMathScore(Student student)throws SQLException;
	/**
	 * 传入Student对象,查找该生计算机成绩，完成后返回该对象
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	abstract Student findComputerScore(Student student) throws SQLException;
}
