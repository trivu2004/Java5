package com.example.ASM.Service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    private HttpSession httpSession;

    public Object get(String name, Object defaultValue) {
        Object value = httpSession.getAttribute(name);
        return (value != null) ? value : defaultValue;
    }

    public void set(String name, Object value) {
        httpSession.setAttribute(name, value);
    }
}
