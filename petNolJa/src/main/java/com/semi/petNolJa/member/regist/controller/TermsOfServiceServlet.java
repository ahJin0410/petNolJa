package com.semi.petNolJa.member.regist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.petNolJa.member.regist.model.dto.TermsAgreeLogDTO;

@WebServlet("/member/regist/agree")
public class TermsOfServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/regist/termsOfService.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TermsAgreeLogDTO> agreeList = new ArrayList<>();
		for(int i = 1; i <= 7; i++) {
			TermsAgreeLogDTO agree = new TermsAgreeLogDTO();
			if(request.getParameter(i + "") == null) {
				agree.setTermsNo(i);
				agree.setAgreeYn('N');
			} else {
				agree.setTermsNo(i);
				agree.setAgreeYn('Y');
			}
			agreeList.add(agree);
		}
		Gson gson = new Gson();
		request.setAttribute("agreeList", gson.toJson(agreeList));
		request.getRequestDispatcher("/WEB-INF/views/member/regist/registFrom.jsp").forward(request, response);
	}

}
