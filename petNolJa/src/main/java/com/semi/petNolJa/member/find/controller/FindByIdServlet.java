package com.semi.petNolJa.member.find.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.petNolJa.member.find.model.dto.MemberDTO;
import com.semi.petNolJa.member.find.model.service.FindByIdAndPwdService;

@WebServlet("/member/find/id")
public class FindByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/find/findById.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		member.setMemberName(request.getParameter("memberName"));
		String memberPhone =  request.getParameter("memberPhone");
		member.setMemberPhone(memberPhone.substring(0, 3) + "-" + memberPhone.substring(3, 7) + "-" + memberPhone.substring(7));
		member.setMemberBirth(request.getParameter("memberBirth"));
		
		String memberId = new FindByIdAndPwdService().findById(member);
		
		if(memberId != null) {
			request.setAttribute("memberId", memberId);
			request.getRequestDispatcher("/WEB-INF/views/member/find/successFind.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/member/find/faildFind.jsp").forward(request, response);
		}
	}

}
