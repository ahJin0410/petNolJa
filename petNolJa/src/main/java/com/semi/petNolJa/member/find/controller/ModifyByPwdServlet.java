package com.semi.petNolJa.member.find.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.petNolJa.member.find.model.dto.MemberDTO;
import com.semi.petNolJa.member.find.model.service.FindByIdAndPwdService;

import net.nurigo.java_sdk.api.Message;

@WebServlet("/member/modify/pwd")
public class ModifyByPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("memberName", request.getParameter("memberName"));
		request.setAttribute("selectMethod", request.getParameter("selectMethod"));
		request.setAttribute("memberPhone", request.getParameter("memberPhone"));
		System.out.println(request.getParameter("selectMethod"));
		System.out.println(request.getParameter("memberPhone"));
		request.getRequestDispatcher("/WEB-INF/views/member/find/successFindByPwd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectMethod = request.getParameter("selectMethod");
		String memberId = request.getParameter("memberId");
		String modifyPwd = randomPwd();
		
		response.setContentType("application/json; charset=UTF-8");
		
		MemberDTO member = new FindByIdAndPwdService().modifyPwdByMemberId(memberId, modifyPwd);
		HashMap<String, String> memberInfo = new HashMap<>();
		String memberPhone = member.getMemberPhone();
		memberInfo.put("memberName", member.getMemberName().replace(member.getMemberName().substring(1, 2), "*"));
		memberInfo.put("memberPhone", memberPhone);
		memberInfo.put("selectMethod", selectMethod);
		memberInfo.put("modifyPwd", modifyPwd);
		memberPhone = memberPhone.substring(0, 3) + memberPhone.substring(3, 8).replaceAll("[0-9]", "*") + memberPhone.substring(8);
		if("memberPhone".equals(selectMethod)) {
			System.out.println(selectMethod + "안오는지?");
			String api_key = "NCSR6UODKPGS5SUG";
			String api_secret = "ZSH7RX88AHGTDM9SMIU3D4EXFPBFUKIF";
			Message sms = new Message(api_key, api_secret);
			
			HashMap<String, String> params = new HashMap<>();
			params.put("to", member.getMemberPhone());
			params.put("from", "010-4212-3846");
			params.put("type", "SMS");
			params.put("text", "[PetNolJa] 회원님의 비밀번호는 " + modifyPwd + " 입니다.");
			params.put("app_version", "test app 1.2");
			
//			try {
//				JSONObject sendObj = (JSONObject) sms.send(params);
//				System.out.println(sendObj);
				PrintWriter out = response.getWriter();
				out.print(new Gson().toJson(memberInfo));
				out.flush();
				out.close();
//			} catch (CoolsmsException e) {
//				e.printStackTrace();
//			}
		} else {
			/* 이메일로 비밀번호 찾기 만들기~! */
			String user = "hyejin_0410@naver.com";
			String password = "test";
			
			Properties prop = new Properties();
			prop.put("mail.smtp.user", user);
			prop.put("mail.smtp.host", "smtp.naver.com");
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(prop, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(member.getMemberEmail()));
				
				message.setSubject("[PetNolJa] 임시 비밀번호를 알려드립니다.");
				message.setText("회원님의 임시 비밀번호를 안내해 드립니다. \n [ " + modifyPwd + "]");
				
				Transport.send(message);
				System.out.println("메일 전송 확인");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(memberInfo));
			out.flush();
			out.close();
		}
		
	}
	
	public static String randomPwd() {
		char pwdCollectionAst[] = new char[] {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '/', '?'};
		char pwdCollectionNum[] = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		char pwdCollectionAll[] = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
											  'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
								              'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
											  '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '/', '?'
											 };
		return getRandPwd(1, pwdCollectionAst) + getRandPwd(6, pwdCollectionAll) + getRandPwd(1, pwdCollectionNum);
	}
	
	public static String getRandPwd(int size, char[] pwdCollection) {
		String randomPwd = "";
		for(int i = 0; i < size; i++) {
			int selectRandomPwd = (int)(Math.random() * (pwdCollection.length));
			randomPwd += pwdCollection[selectRandomPwd];
		}
		return randomPwd;
	}
}
