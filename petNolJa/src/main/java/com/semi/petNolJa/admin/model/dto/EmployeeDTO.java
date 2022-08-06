package com.semi.petNolJa.admin.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = -2261579922632773846L;
	
	private int empId;					// 아이디
	private String empName;				// 비밀번호
	private String empNo;				// 주민등록번호
	private String empEmail;			// 이메일
	private String empPhone;			// 핸드폰번호
	private int salary;					// 급여(연봉)
	private double bonus;				// 보너스율
	private java.sql.Date hiredate;		// 입사일
	private java.sql.Date leavedate;	// 퇴사일
	private char dropYn;				// 퇴사여부
	private int deptCode;				// 부서코드
	private int jobCode;				// 직책코드
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(int empId, String empName, String empNo, String empEmail, String empPhone, int salary,
			double bonus, Date hiredate, Date leavedate, char dropYn, int deptCode, int jobCode) {
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.salary = salary;
		this.bonus = bonus;
		this.hiredate = hiredate;
		this.leavedate = leavedate;
		this.dropYn = dropYn;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public java.sql.Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(java.sql.Date hiredate) {
		this.hiredate = hiredate;
	}

	public java.sql.Date getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(java.sql.Date leavedate) {
		this.leavedate = leavedate;
	}

	public char getDropYn() {
		return dropYn;
	}

	public void setDropYn(char dropYn) {
		this.dropYn = dropYn;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}

	public int getJobCode() {
		return jobCode;
	}

	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", empEmail=" + empEmail
				+ ", empPhone=" + empPhone + ", salary=" + salary + ", bonus=" + bonus + ", hiredate=" + hiredate
				+ ", leavedate=" + leavedate + ", dropYn=" + dropYn + ", deptCode=" + deptCode + ", jobCode=" + jobCode
				+ "]";
	}
}
