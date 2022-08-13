package com.semi.petNolJa.member.find.model.dao;

import java.util.Map;

import com.semi.petNolJa.member.find.model.dto.MemberDTO;

public interface FindByIdAndPwdDAO {

	String findById(MemberDTO member);

	MemberDTO findByPwd(MemberDTO member);

	int modifyPwdByMemberId(Map<String, String> param);

	MemberDTO selectMemberByMemberId(String memberId);

	
}
