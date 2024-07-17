package com.example.demo.utlis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.model.Account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionService_Login {
	@Autowired
	HttpSession session;

	public <T> T get(String name) {
		return (T) session.getAttribute(name);
	}

	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}

	public void remove(String name) {
		session.removeAttribute(name);
	}

	public boolean isUserLoggedIn(HttpSession session) {
		if (session.getAttribute("user") != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Account getUserFromSession() {
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    return (Account) request.getSession().getAttribute("user");
	}

}
