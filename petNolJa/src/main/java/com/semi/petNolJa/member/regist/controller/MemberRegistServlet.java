package com.semi.petNolJa.member.regist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.petNolJa.member.regist.model.dto.MemberDTO;
import com.semi.petNolJa.member.regist.model.dto.TermsAgreeLogDTO;
import com.semi.petNolJa.member.regist.model.service.RegistService;

@WebServlet("/member/regist/info")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/regist/successRegist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		member.setMemberId(request.getParameter("memberId"));
		String memberPwd = request.getParameter("memberPwd");
		member.setMemberPwd(memberPwd);
		member.setMemberName(request.getParameter("memberName"));
		member.setMemberBirth(java.sql.Date.valueOf(request.getParameter("memberBirth")));
		member.setMemberPhone(request.getParameter("memberPhoneFront") + request.getParameter("memberPhone"));
		System.out.println("핸드폰ㅎㅎ" + request.getParameter("memberPhone"));
		member.setMemberEmail(request.getParameter("memberEmail"));
		member.setMemberPoint(1000);
		member.setMemberDropYn("N");
		member.setGradeNo(1);
		
		String memberId = request.getParameter("memberId");
		String termsNo = request.getParameter("termsNo").replace("[", "").replace("]", "");
		String agreeYn = request.getParameter("agreeYn").replace("[", "").replace("]", "").replaceAll("\"", "");

		String[] termsNoList = termsNo.split(",");
		String[] agreeYnList = agreeYn.split(",");
		List<TermsAgreeLogDTO> agreeList = new ArrayList<>();
		for(int i = 0; i < termsNoList.length; i++) {
			TermsAgreeLogDTO agree = new TermsAgreeLogDTO();
			agree.setTermsNo(Integer.valueOf(termsNoList[i]));
			agree.setMemberId(memberId);
			agree.setAgreeYn(agreeYnList[i]);
			agreeList.add(agree);
		}
		
		int result = new RegistService().regisMember(member, agreeList);
		
		if(result == 0) {
			response.sendRedirect(request.getContextPath() + "/member/regist/info");
		} else {
			response.sendRedirect(request.getContextPath() + "/member/faild");
		}
	}

}
