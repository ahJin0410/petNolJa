package com.semi.petNolJa.common.login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.petNolJa.common.login.model.dto.AdminDTO;
import com.semi.petNolJa.common.login.model.dto.MemberDTO;
import com.semi.petNolJa.common.login.model.service.LoginService;


@WebServlet("/common/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String ip = getRemoteIP(request);
		
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("id", id);
		loginInfo.put("pwd", pwd);
		loginInfo.put("ip", ip);
		
		AdminDTO loginEmp = null;
		MemberDTO loginMember = null;
		
		if(id.replaceAll("[0-9]", "").equals("")) {
			loginEmp = new LoginService().empLoginCheck(loginInfo);
		} else {
			loginMember = new LoginService().memberLoginCheck(loginInfo);
		}
		
		if(loginEmp != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(6000);
			session.setAttribute("loginEmp", loginEmp);
			session.setAttribute("role", "admin");
			
			response.sendRedirect("../admin/main");
		} else if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(6000);
			session.setAttribute("loginMember", loginMember);
			session.setAttribute("role", "member");
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "입력하신 아이디 또는 비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(request, response);
		}
		
	}
	
	public static String getRemoteIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if(ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
