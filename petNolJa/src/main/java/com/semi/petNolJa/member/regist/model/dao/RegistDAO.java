package com.semi.petNolJa.member.regist.model.dao;

import com.semi.petNolJa.member.regist.model.dto.MemberDTO;
import com.semi.petNolJa.member.regist.model.dto.TermsAgreeLogDTO;

public interface RegistDAO {

	int countByMemberId(String checkId);
	
	int registMember(MemberDTO member);

	int registTermsAgreeLog(TermsAgreeLogDTO termsAgreeLogDTO);

}
