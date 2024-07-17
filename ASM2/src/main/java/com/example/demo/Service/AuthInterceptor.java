package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.model.Account;
import com.example.demo.utlis.SessionService_Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	SessionService_Login session;

	@Override
	public boolean preHandle(HttpServletRequest rq, HttpServletResponse resp, Object handler) throws Exception {
		String uri = rq.getRequestURI();
		Account user = session.get("user");

		String error = "";
		if (user == null) {
			error = "Please login!";
		} else if (!user.isAdmin() && uri.startsWith("/admin")) {
			error = "Access denied!";
		}

		if (error.length() > 0) {
			session.set("security-uri", uri);
			resp.sendRedirect("/account/login?error=" + error);
			return false;
		}
		return true;
	}
}
