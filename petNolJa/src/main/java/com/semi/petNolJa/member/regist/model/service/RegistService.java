package com.semi.petNolJa.member.regist.model.service;

import com.semi.petNolJa.member.regist.model.dao.RegistDAO;
import com.semi.petNolJa.member.regist.model.dto.MemberDTO;
import com.semi.petNolJa.member.regist.model.dto.TermsAgreeLogDTO;

import static com.semi.petNolJa.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class RegistService {
	
	private RegistDAO registDAO;

	public int countByMemberId(String checkId) {
		SqlSession sqlSession = getSqlSession();
		registDAO = sqlSession.getMapper(RegistDAO.class);
		int countUsedId = registDAO.countByMemberId(checkId);
		sqlSession.close();
		return countUsedId;
	}

	public int regisMember(MemberDTO member, List<TermsAgreeLogDTO> agreeList) {
		SqlSession sqlSessio = getSqlSession();
		registDAO = sqlSessio.getMapper(RegistDAO.class);
		
		int result = registDAO.registMember(member);
		
		if(result > 0) {
			result = agreeList.size();
			for(int i = 0; i < agreeList.size(); i++) {
				int regist = registDAO.registTermsAgreeLog(agreeList.get(i));
				result -= regist;
			}
			
			if(result == 0) {
				sqlSessio.commit();
			} else {
				sqlSessio.rollback();
			}
			
		}
		sqlSessio.close();
		return result;
	}

}
