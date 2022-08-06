package com.semi.petNolJa.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {
	private String encodingType;

	public void destroy() {}
	
	/* POST타입의 경우 인코딩 설정 필요하기 때문에 필터로 편하게 처리하기 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
			System.out.println("변경된 인코딩 타입: " + request.getCharacterEncoding());
		}
		chain.doFilter(request, response);
	}
	
	/* web.xml에서 설정 한 fiter/init-param Name을 작성하여 Value값 가져오기 */
	public void init(FilterConfig fConfig) throws ServletException {
		encodingType = fConfig.getInitParameter("encoding-type");
	}
}
