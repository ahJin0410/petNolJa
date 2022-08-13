package com.semi.petNolJa.member.find.model.service;

import com.semi.petNolJa.member.find.model.dao.FindByIdAndPwdDAO;
import com.semi.petNolJa.member.find.model.dto.MemberDTO;

import static com.semi.petNolJa.common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class FindByIdAndPwdService {
	private FindByIdAndPwdDAO findByDAO;

	public String findById(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();
		findByDAO = sqlSession.getMapper(FindByIdAndPwdDAO.class);
		
		String memberId = findByDAO.findById(member);
		
		sqlSession.close();
		return memberId;
	}

	public MemberDTO findByPwd(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();
		findByDAO = sqlSession.getMapper(FindByIdAndPwdDAO.class);
		
		member = findByDAO.findByPwd(member);
		
		sqlSession.close();
		return member;
	}

	public MemberDTO modifyPwdByMemberId(String memberId, String modifyPwd) {
		SqlSession sqlSession = getSqlSession();
		findByDAO = sqlSession.getMapper(FindByIdAndPwdDAO.class);
		
		Map<String, String> param = new HashMap<>();
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		param.put("memberId", memberId);
		param.put("memberPwd", pwdEncoder.encode(modifyPwd));
		int result = findByDAO.modifyPwdByMemberId(param);
		
		MemberDTO member = new MemberDTO();
		if(result > 0) {
			member = findByDAO.selectMemberByMemberId(memberId);
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return member;
	}
	
	
}
