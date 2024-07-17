package com.example.demo.utlis;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionService {
	@Autowired
	HttpSession session;

	public <T> T get(String name, T defaultValue) {
		T value = (T) session.getAttribute(name);
		return value != null ? value : defaultValue;
	}

	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}

	public void remove(String name) {
		session.removeAttribute(name);
	}
}
