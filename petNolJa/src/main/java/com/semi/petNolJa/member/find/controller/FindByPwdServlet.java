package com.semi.petNolJa.member.find.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.petNolJa.member.find.model.dto.MemberDTO;
import com.semi.petNolJa.member.find.model.service.FindByIdAndPwdService;

@WebServlet("/member/find/pwd")
public class FindByPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/find/findByPwd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		member.setMemberId(request.getParameter("memberId"));
		String memberPhone =  request.getParameter("memberPhone");
		member.setMemberPhone(memberPhone.substring(0, 3) + "-" + memberPhone.substring(3, 7) + "-" + memberPhone.substring(7));
		member.setMemberBirth(request.getParameter("memberBirth"));
		
		member = new FindByIdAndPwdService().findByPwd(member);
		
		memberPhone = memberPhone.substring(0, 3) + "-" +  memberPhone.substring(3, 7).replaceAll("[0-9]", "*") + "-" +  memberPhone.substring(7);
		String memberEmail = member.getMemberEmail();
		memberEmail = member.getMemberId().substring(0, member.getMemberId().length() - 3) + "***" + memberEmail.substring(memberEmail.indexOf("@"));
		
		if(member.getMemberEmail() != null) {
			request.setAttribute("memberId", member.getMemberId());
			request.setAttribute("memberEmail", memberEmail);
			request.setAttribute("memberPhone", memberPhone);
			request.getRequestDispatcher("/WEB-INF/views/member/find/selectMethod.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "입력된 회원정보가 존재하지 않습니다. 비회원일 경우 회원가입 후 이용해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/member/find/findByPwd.jsp").forward(request, response);
		}
	}

}
