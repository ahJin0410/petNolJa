package com.semi.petNolJa.member.find.model.service;

import com.semi.petNolJa.member.find.model.dao.FindByIdAndPwdDAO;
import com.semi.petNolJa.member.find.model.dto.MemberDTO;

import static com.semi.petNolJa.common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

public class FindByIdAndPwdService {
	private FindByIdAndPwdDAO findByDAO;

	public String findById(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();
		findByDAO = sqlSession.getMapper(FindByIdAndPwdDAO.class);
		
		String memberId = findByDAO.findById(member);
		
		sqlSession.close();
		return memberId;
	}
	
	
}
