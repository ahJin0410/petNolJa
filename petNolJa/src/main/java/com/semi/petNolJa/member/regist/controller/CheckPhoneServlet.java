package com.semi.petNolJa.member.regist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@WebServlet("/member/regist/checkPhone")
public class CheckPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random random = new Random();
		String randomNumber = "";
		
		for(int i = 0; i < 6; i++) {
			String number = Integer.toString(random.nextInt(10));
			randomNumber += number;
		}
		
		String api_key = "NCSR6UODKPGS5SUG";
		String api_secret = "ZSH7RX88AHGTDM9SMIU3D4EXFPBFUKIF";
		Message sms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", request.getParameter("memberPhone"));
		params.put("from", "010-4212-3846");
		params.put("type", "SMS");
		params.put("text", "[PetNolJa] 인증번호: " + randomNumber + "\n인증번호를 입력해 주세요.");
		params.put("app_version", "test app 1.2");
		
//		try {
//			JSONObject sendObj = (JSONObject) sms.send(params);
//			System.out.println(sendObj);
			PrintWriter out = response.getWriter();
			out.print(randomNumber);
			out.flush();
			out.close();
//		} catch (CoolsmsException e) {
//			e.printStackTrace();
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
