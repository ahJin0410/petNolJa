package com.semi.petNolJa.common.login.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class PwdChangeLogDTO implements Serializable{
	private static final long serialVersionUID = 6749197192695325754L;
	
	private int pwdChangeLogNo;					// 비밀번호 이력 번호
	private java.sql.Date pwdChangeLogDate;		// 비밀번호 변경일
	private String pwdChangeLogIp;				// 비밀번호 변경 아이피
	private char empYn;							// 관리자 여부
	private int empId;							// 관리자 아이디
	private String memberId;					// 회원 아이디
	
	public PwdChangeLogDTO() {
	}

	public PwdChangeLogDTO(int pwdChangeLogNo, Date pwdChangeLogDate, String pwdChangeLogIp, char empYn, int empId,
			String memberId) {
		this.pwdChangeLogNo = pwdChangeLogNo;
		this.pwdChangeLogDate = pwdChangeLogDate;
		this.pwdChangeLogIp = pwdChangeLogIp;
		this.empYn = empYn;
		this.empId = empId;
		this.memberId = memberId;
	}

	public int getPwdChangeLogNo() {
		return pwdChangeLogNo;
	}

	public void setPwdChangeLogNo(int pwdChangeLogNo) {
		this.pwdChangeLogNo = pwdChangeLogNo;
	}

	public java.sql.Date getPwdChangeLogDate() {
		return pwdChangeLogDate;
	}

	public void setPwdChangeLogDate(java.sql.Date pwdChangeLogDate) {
		this.pwdChangeLogDate = pwdChangeLogDate;
	}

	public String getPwdChangeLogIp() {
		return pwdChangeLogIp;
	}

	public void setPwdChangeLogIp(String pwdChangeLogIp) {
		this.pwdChangeLogIp = pwdChangeLogIp;
	}

	public char getEmpYn() {
		return empYn;
	}

	public void setEmpYn(char empYn) {
		this.empYn = empYn;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PwdChangeLogDTO [pwdChangeLogNo=" + pwdChangeLogNo + ", pwdChangeLogDate=" + pwdChangeLogDate
				+ ", pwdChangeLogIp=" + pwdChangeLogIp + ", empYn=" + empYn + ", empId=" + empId + ", memberId="
				+ memberId + "]";
	}
	
}
