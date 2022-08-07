package com.semi.petNolJa.common.login.model.dao;

import java.util.Map;

import com.semi.petNolJa.common.login.model.dto.AdminDTO;
import com.semi.petNolJa.common.login.model.dto.MemberDTO;

public interface LoginDAO {

	String selectEncryptedEmpPwd(int empId);

	AdminDTO selectLoginEmp(Map<String, String> loginInfo);

	int registAdminLog(Map<String, String> loginInfo);

	String selectEncryptedmemberPwd(String id);

	MemberDTO selectLoginMember(Map<String, String> loginInfo);

	int registMemLoginLog(Map<String, String> loginInfo);

}
