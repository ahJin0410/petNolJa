package com.semi.petNolJa.common.login.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class AdminDTO implements Serializable {
	private static final long serialVersionUID = -2261579922632773846L;
	
	private int empId;					// 아이디
	private String empPwd;				// 비밀번호
	private String empName;				// 이름
	private String empNo;				// 주민등록번호
	private String empEmail;			// 이메일
	private String empPhone;			// 핸드폰번호
	private int empSalary;				// 급여(연봉)
	private double empBonus;			// 보너스율
	private java.sql.Date empHiredate;	// 입사일
	private java.sql.Date empLeavedate;	// 퇴사일
	private char empDropYn;				// 퇴사여부
	private int deptCode;				// 부서코드
	private int jobCode;				// 직책코드
	
	public AdminDTO() {
	}

	public AdminDTO(int empId, String empPwd, String empName, String empNo, String empEmail, String empPhone,
			int empSalary, double empBonus, Date empHiredate, Date empLeavedate, char empDropYn, int deptCode,
			int jobCode) {
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empNo = empNo;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
		this.empBonus = empBonus;
		this.empHiredate = empHiredate;
		this.empLeavedate = empLeavedate;
		this.empDropYn = empDropYn;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
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

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public double getEmpBonus() {
		return empBonus;
	}

	public void setEmpBonus(double empBonus) {
		this.empBonus = empBonus;
	}

	public java.sql.Date getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(java.sql.Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	public java.sql.Date getEmpLeavedate() {
		return empLeavedate;
	}

	public void setEmpLeavedate(java.sql.Date empLeavedate) {
		this.empLeavedate = empLeavedate;
	}

	public char getEmpDropYn() {
		return empDropYn;
	}

	public void setEmpDropYn(char empDropYn) {
		this.empDropYn = empDropYn;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdminDTO [empId=" + empId + ", empPwd=" + empPwd + ", empName=" + empName + ", empNo=" + empNo
				+ ", empEmail=" + empEmail + ", empPhone=" + empPhone + ", empSalary=" + empSalary + ", empBonus="
				+ empBonus + ", empHiredate=" + empHiredate + ", empLeavedate=" + empLeavedate + ", empDropYn="
				+ empDropYn + ", deptCode=" + deptCode + ", jobCode=" + jobCode + "]";
	}
	
}
