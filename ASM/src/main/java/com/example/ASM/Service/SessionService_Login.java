package com.example.ASM.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
        // Kiểm tra xem có thông tin người dùng đã được lưu trong session không
        return session.getAttribute("user") != null;
    }


}