package com.semi.petNolJa.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.semi.petNolJa.admin.model.dto.EmployeeDTO;

@WebFilter(urlPatterns = {})	// 메뉴 모두 만든 후 urlPattern 작성하기
public class AuthenticationFilter implements Filter {
	
	Map<String, List<String>> permitURIList;
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		System.out.println("AuthenticationFilter intent : " + intent);
		
		/* 권한 확인 후 허용 된 url에만 접근 가능하도록 설정 */
		HttpSession requestSession = hrequest.getSession();
		EmployeeDTO loginMember = (EmployeeDTO) requestSession.getAttribute("loginMember");
		
		boolean isAuthorized = false;
		if(loginMember != null) {
//			boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
//			boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
//			boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
			
			/*  메뉴 모두 만든 후 수정하기 */
			isAuthorized = true;
			chain.doFilter(request, response);
		} else {
			if(permitURIList.get("allPermitLsit").contains(intent)) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("message", "로그인이 필요한 서비스 입니다.");
				request.getRequestDispatcher("/WEB-INF/views/login/memberLogin.jsp").forward(hrequest, response);
			}
		}
	}

	/* 메뉴 모두 만든 후 수정하기 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		allPermitList.add("/member/*");
		allPermitList.add("/admin/*");
		
	}

}
