package com.semi.petNolJa.member.regist.model.dto;

import java.io.Serializable;

public class TermsDTO implements Serializable {
	private static final long serialVersionUID = -8195995734303069524L;
	
	private int termsNo;
	private String termsName;
	private String termsConditions;
	private char essentialYn;
	
	public TermsDTO() {
	}

	public TermsDTO(int termsNo, String termsName, String termsConditions, char essentialYn) {
		this.termsNo = termsNo;
		this.termsName = termsName;
		this.termsConditions = termsConditions;
		this.essentialYn = essentialYn;
	}

	public int getTermsNo() {
		return termsNo;
	}

	public void setTermsNo(int termsNo) {
		this.termsNo = termsNo;
	}

	public String getTermsName() {
		return termsName;
	}

	public void setTermsName(String termsName) {
		this.termsName = termsName;
	}

	public String getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	public char getEssentialYn() {
		return essentialYn;
	}

	public void setEssentialYn(char essentialYn) {
		this.essentialYn = essentialYn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TermsDTO [termsNo=" + termsNo + ", termsName=" + termsName + ", termsConditions=" + termsConditions
				+ ", essentialYn=" + essentialYn + "]";
	}
	
}
