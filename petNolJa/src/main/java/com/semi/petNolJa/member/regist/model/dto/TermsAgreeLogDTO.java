package com.semi.petNolJa.member.regist.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class TermsAgreeLogDTO implements Serializable {
	private static final long serialVersionUID = -755281633741338374L;
	
	private int termsNo;
	private String memberId;
	private char agreeYn;
	private java.sql.Date agreeDate;
	
	public TermsAgreeLogDTO() {
	}

	public TermsAgreeLogDTO(int termsNo, String memberId, char agreeYn, Date agreeDate) {
		this.termsNo = termsNo;
		this.memberId = memberId;
		this.agreeYn = agreeYn;
		this.agreeDate = agreeDate;
	}

	public int getTermsNo() {
		return termsNo;
	}

	public void setTermsNo(int termsNo) {
		this.termsNo = termsNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public char getAgreeYn() {
		return agreeYn;
	}

	public void setAgreeYn(char agreeYn) {
		this.agreeYn = agreeYn;
	}

	public java.sql.Date getAgreeDate() {
		return agreeDate;
	}

	public void setAgreeDate(java.sql.Date agreeDate) {
		this.agreeDate = agreeDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TermsAgreeLogDTO [termsNo=" + termsNo + ", memberId=" + memberId + ", agreeYn=" + agreeYn
				+ ", agreeDate=" + agreeDate + "]";
	}
	
}
