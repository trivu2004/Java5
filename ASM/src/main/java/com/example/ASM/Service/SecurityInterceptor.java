package com.example.ASM.Service;

import com.example.ASM.entity.account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        account loggedInUser = (account) session.getAttribute("user");
        if (loggedInUser == null) {
            // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
            String redirectUrl = ServletUriComponentsBuilder.fromRequest(request).build().toUriString();
            response.sendRedirect(request.getContextPath() + "/login?redirect=" + redirectUrl);
            return false; // Ngăn không cho request tiếp tục đi tới controller
        }
        // Nếu đã đăng nhập, cho phép request tiếp tục đi tới controller
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Thực thi sau khi handler controller đã được chạy và trước khi trả về view cho client
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // Thực thi sau khi response đã được trả về cho client
    }
}
