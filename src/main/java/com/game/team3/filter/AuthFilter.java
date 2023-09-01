package com.game.team3.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;

import com.game.team3.util.JWTToken;
import com.game.team3.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@WebFilter(value = {"/","/views/*","/api/*"})
@Slf4j

public class AuthFilter extends GenericFilterBean {

	@Autowired
	private JWTToken jwtToken;
	@Value("${auth.execlude.urls}")
	private List<String> execludeUrls =new ArrayList<>();
	{
		execludeUrls.add("/views/login");
		execludeUrls.add("/views/join");
		execludeUrls.add("/api/login");
		execludeUrls.add("/api/join");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(request instanceof HttpServletRequest req && response instanceof HttpServletResponse res) {
			String uri =req.getRequestURI();
			if(!execludeUrls.contains(uri)) {
				HttpSession session =req.getSession();
				UserInfoVO user=(UserInfoVO) session.getAttribute("user");
				if(user==null) {
					res.sendRedirect("/views/login");
					return;
				}
			}
		}
	}

}
