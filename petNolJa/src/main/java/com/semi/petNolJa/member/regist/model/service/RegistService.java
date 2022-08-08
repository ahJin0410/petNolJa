package com.semi.petNolJa.member.regist.model.service;

import com.semi.petNolJa.member.regist.model.dao.RegistDAO;
import static com.semi.petNolJa.common.mybatis.Template.getSqlSession;

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

}
