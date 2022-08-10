package com.semi.petNolJa.member.regist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
				agree.setAgreeYn("N");
			} else {
				agree.setTermsNo(i);
				agree.setAgreeYn("Y");
			}
			agreeList.add(agree);
		}
		
		JSONArray jsonArray = new JSONArray();
		for(TermsAgreeLogDTO agree : agreeList) {
			JSONObject json = new JSONObject();
			json.put("termsNo", agree.getTermsNo());
			json.put("agreeYn", agree.getAgreeYn());
			
			jsonArray.add(json);
		}
		
		request.setAttribute("agreeList",jsonArray.toJSONString());
		request.getRequestDispatcher("/WEB-INF/views/member/regist/registFrom.jsp").forward(request, response);
	}

}
