package com.semi.petNolJa.common.login.model.service;

import static com.semi.petNolJa.common.mybatis.Template.getSqlSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.semi.petNolJa.common.login.model.dao.LoginDAO;
import com.semi.petNolJa.common.login.model.dto.AdminDTO;
import com.semi.petNolJa.common.login.model.dto.MemberDTO;

public class LoginService {
	
	private LoginDAO loginDAO;

	/* 관리자 ID 로그인 */
	public AdminDTO empLoginCheck(Map<String, String> loginInfo) {
		SqlSession sqlSession = getSqlSession();
		loginDAO = sqlSession.getMapper(LoginDAO.class);
		
		int registLogResult = 0;
		AdminDTO loginEmp = null;
		int empId = Integer.valueOf(loginInfo.get("id"));
		String encPwd = loginDAO.selectEncryptedEmpPwd(empId);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(loginInfo.get("pwd"), encPwd)) {
			loginEmp = loginDAO.selectLoginEmp(loginInfo);
			registLogResult = loginDAO.registAdminLog(loginInfo);
		}
		
		if(registLogResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return loginEmp;
	}
	
	/* 회원 ID 로그인 */
	public MemberDTO memberLoginCheck(Map<String, String> loginInfo) {
		SqlSession sqlSession = getSqlSession();
		loginDAO = sqlSession.getMapper(LoginDAO.class);
		
		int registLogResult = 0;
		MemberDTO loginMember = null;
		String encPwd = loginDAO.selectEncryptedmemberPwd(loginInfo.get("id"));
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(loginInfo.get("pwd"), encPwd)) {
			loginMember = loginDAO.selectLoginMember(loginInfo);
			registLogResult = loginDAO.registMemLoginLog(loginInfo);
		}
		if(registLogResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return loginMember;
	}
	
}
