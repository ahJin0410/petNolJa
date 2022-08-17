package com.semi.petNolJa.member.find.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.nbp.ncp.nes.ApiClient;
import com.nbp.ncp.nes.ApiResponse;
import com.nbp.ncp.nes.api.V1Api;
import com.nbp.ncp.nes.auth.PropertiesFileCredentialsProvider;
import com.nbp.ncp.nes.exception.ApiException;
import com.nbp.ncp.nes.exception.SdkException;
import com.nbp.ncp.nes.marshaller.FormMarshaller;
import com.nbp.ncp.nes.marshaller.JsonMarshaller;
import com.nbp.ncp.nes.marshaller.XmlMarshaller;
import com.nbp.ncp.nes.model.EmailSendRequest;
import com.nbp.ncp.nes.model.EmailSendRequestRecipients;
import com.nbp.ncp.nes.model.EmailSendResponse;
import com.semi.petNolJa.member.find.model.dto.MemberDTO;
import com.semi.petNolJa.member.find.model.service.FindByIdAndPwdService;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@WebServlet("/member/modify/pwd")
public class ModifyByPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("memberName", request.getParameter("memberName"));
		request.setAttribute("selectMethod", request.getParameter("selectMethod"));
		request.setAttribute("memberPhone", request.getParameter("memberPhone"));
		request.setAttribute("memberEmail", request.getParameter("memberEmail"));
		request.getRequestDispatcher("/WEB-INF/views/member/find/successFindByPwd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectMethod = request.getParameter("selectMethod");
		String memberId = request.getParameter("memberId");
		String modifyPwd = randomPwd();
		
		response.setContentType("application/json; charset=UTF-8");
		
		MemberDTO member = new FindByIdAndPwdService().modifyPwdByMemberId(memberId, modifyPwd);
		HashMap<String, String> memberInfo = new HashMap<>();
		memberInfo.put("memberName", member.getMemberName().replace(member.getMemberName().substring(1, 2), "*"));
		memberInfo.put("memberPhone", member.getMemberPhone().substring(0, 3) + member.getMemberPhone().substring(3, 8).replaceAll("[0-9]", "*") + member.getMemberPhone().substring(8));
		memberInfo.put("memberEmail", member.getMemberEmail().substring(0, 3) + member.getMemberEmail().substring(3, member.getMemberEmail().indexOf("@")).replaceAll("[a-zA-Z0-9-_.]", "*") + member.getMemberEmail().substring(member.getMemberEmail().indexOf("@")));
		memberInfo.put("selectMethod", selectMethod);
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
//			} catch (CoolsmsException e) {
//				e.printStackTrace();
//			}
		} else {
			
//			ApiClient apiClient = new ApiClient.ApiClientBuilder()
//									  .addMarshaller(JsonMarshaller.getInstance())
//									  .addMarshaller(XmlMarshaller.getInstance())
//									  .addMarshaller(FormMarshaller.getInstance())
//									  .setCredentials(new PropertiesFileCredentialsProvider("C:\\1_NewPetNolJa_20220806ver\\petNolJa\\resources\\lib\\credentials.properties").getCredentials())
//									  .setLogging(true)
//									  .build();
//			V1Api apiInstance = new V1Api(apiClient);
//			
//			List<EmailSendRequestRecipients> esrrList = new ArrayList<EmailSendRequestRecipients>();
//			EmailSendRequestRecipients esrr = new EmailSendRequestRecipients();
//			esrr.setAddress(member.getMemberEmail());
//			esrr.setName(member.getMemberName());
//			esrr.setType("R");
//			esrrList.add(esrr);
//			
//			EmailSendRequest requestBody = new EmailSendRequest();
//			requestBody.setBody(member.getMemberName() + "님의 임시 비밀번호를 안내해 드립니다.\n <h1> [" + modifyPwd + "] </h1>");
//			requestBody.setRecipients(esrrList);
////			requestBody.setTemplateSid(null);
//			requestBody.setSenderAddress("hyejin_0410@naver.com");
//			requestBody.setSenderName("펫놀자[PetNolJa]");
//			requestBody.setTitle("펫놀자 회원님의 임시 비밀번호를 안내해 드립니다.");
//			requestBody.setConfirmAndSend(false);
//			
//			String X_NCP_LANG = "ko-KR";
//			System.out.println(requestBody);
//			
//			try {
//				ApiResponse<EmailSendResponse> result = apiInstance.mailsPost(requestBody, X_NCP_LANG);
//			} catch (ApiException e) {
//				int statusCode = e.getHttpStatusCode();
//				Map<String, List<String>> responseHeaders = e.getHttpHeaders();
//				InputStream byteSteam = e.getByteStream();
//				e.printStackTrace();
//			} catch (SdkException e) {
//				e.printStackTrace();
//			}
		}
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(memberInfo));
		out.flush();
		out.close();
		
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
	
//	public String makeSignature() {
//	    String space = " ";  // 공백
//	    String newLine = "\n";  // 줄바꿈
//	    String method = "POST";  // HTTP 메소드
//	    String url = "/member/modify/pwd";  // 도메인을 제외한 "/" 아래 전체 url (쿼리스트링 포함)
//	    String timestamp = "{timestamp}";  // 현재 타임스탬프 (epoch, millisecond)
//	    String accessKey = "{accessKey}";  // access key id (from portal or sub account)
//	    String secretKey = "{secretKey}";  // secret key (from portal or sub account)
//
//	    String message = new StringBuilder()
//	        .append(method)
//	        .append(space)
//	        .append(url)
//	        .append(newLine)
//	        .append(timestamp)
//	        .append(newLine)
//	        .append(accessKey)
//	        .toString();
//
//	    String encodeBase64String = null;
//	    try {
//	    SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
//	    Mac mac;
//			mac = Mac.getInstance("HmacSHA256");
//	    mac.init(signingKey);
//
//	    byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
//	    encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
//	    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//	    	e.printStackTrace();
//	    } catch (InvalidKeyException e) {
//			e.printStackTrace();
//		}
//	  return encodeBase64String;
//
//	}
	
}