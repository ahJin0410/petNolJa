package com.semi.petNolJa.member.regist.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 613752631397804182L;
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private java.sql.Date memberBirth;
	private String memberPhone;
	private String memberEmail;
	private int memberPoint;
	private java.sql.Date memberLeavedate;
	private String memberDropYn;
	private int gradeNo;
	
	public MemberDTO() {
	}

	public MemberDTO(String memberId, String memberPwd, String memberName, Date memberBirth, String memberPhone,
			String memberEmail, int memberPoint, Date memberLeavedate, String memberDropYn, int gradeNo) {
		this.memberId = memberId;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getMemberDropYn() {
		return memberDropYn;
	}

	public void setMemberDropYn(String memberDropYn) {
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
		return "MemberDTO [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberPoint=" + memberPoint + ", memberLeavedate=" + memberLeavedate + ", memberDropYn="
				+ memberDropYn + ", gradeNo=" + gradeNo + "]";
	}
	
}
