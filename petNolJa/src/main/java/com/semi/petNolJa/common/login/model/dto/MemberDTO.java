package com.semi.petNolJa.common.login.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MemberDTO implements Serializable {
	private static final long serialVersionUID = -6353336911493823594L;
	
	private String memeberId;				// 회원 아이디
	private String memberPwd;				// 회원 비밀번호
	private String memberName;				// 회원 이름
	private java.sql.Date memberBirth;		// 회원 생년월일
	private String memberPhone;				// 회원 전화번호
	private String memberEmail;				// 회원 이메일
	private int memberPoint;				// 회원 보유 포인트
	private java.sql.Date memberLeavedate;	// 탈퇴일
	private char memberDropYn;				// 탈퇴 여부
	private int gradeNo;					// 회원 등급
	
	public MemberDTO() {
	}

	public MemberDTO(String memeberId, String memberPwd, String memberName, Date memberBirth, String memberPhone,
			String memberEmail, int memberPoint, Date memberLeavedate, char memberDropYn, int gradeNo) {
		this.memeberId = memeberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberPoint = memberPoint;
		this.memberLeavedate = memberLeavedate;
		this.memberDropYn = memberDropYn;
		this.gradeNo = gradeNo;
	}

	public String getMemeberId() {
		return memeberId;
	}

	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public java.sql.Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(java.sql.Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public java.sql.Date getMemberLeavedate() {
		return memberLeavedate;
	}

	public void setMemberLeavedate(java.sql.Date memberLeavedate) {
		this.memberLeavedate = memberLeavedate;
	}

	public char getMemberDropYn() {
		return memberDropYn;
	}

	public void setMemberDropYn(char memberDropYn) {
		this.memberDropYn = memberDropYn;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MemberDTO [memeberId=" + memeberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberPoint=" + memberPoint + ", memberLeavedate=" + memberLeavedate + ", memberDropYn="
				+ memberDropYn + ", gradeNo=" + gradeNo + "]";
	}

}
