package com.semi.petNolJa.member.find.model.dao;

import com.semi.petNolJa.member.find.model.dto.MemberDTO;

public interface FindByIdAndPwdDAO {

	String findById(MemberDTO member);
	
}
