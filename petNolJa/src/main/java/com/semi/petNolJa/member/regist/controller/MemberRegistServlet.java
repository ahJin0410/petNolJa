package com.semi.petNolJa.member.regist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/member/regist/info")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonData = request.getParameter("agreeList");
		JSONObject jsonObj = new JSONObject();
			try {
				jsonObj = (JSONObject) new JSONParser().parse(jsonData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println(jsonObj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
