package co.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 전체필드값을 가지는 생성자.
@NoArgsConstructor // 기본생성자.
public class Employee {
	private int empNo; // 사원번호.
	private String empName; // 사원명.
	private String email;
	private String phone;
	private Date hireDate;
	private int salary;
	private String department;

	public String showList() {
		// 사번 이름 연락처 부서 급여
		String result = "%4s %6s %10s %5s %5d\n";
		return result;
	}
}