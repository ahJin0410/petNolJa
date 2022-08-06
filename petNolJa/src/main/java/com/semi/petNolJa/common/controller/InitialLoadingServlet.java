package com.semi.petNolJa.common.controller;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.semi.petNolJa.common.config.ConfigLocation;

@WebServlet(urlPatterns = {}, loadOnStartup = 1)
public class InitialLoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) {
		ConfigLocation.mybatisConfigLocation = config.getServletContext().getInitParameter("mybatis-config-location");
		System.out.println("시작 시 잘 생성 되는지 확인" + ConfigLocation.mybatisConfigLocation);
	}
}
