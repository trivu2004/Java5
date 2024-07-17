package com.example.ASM.Config;

import com.example.ASM.Service.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Đăng ký interceptor và chỉ định các URL mà nó sẽ áp dụng
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/account/**") // Áp dụng cho tất cả các URL bắt đầu bằng /account/
                .excludePathPatterns("/login", "/logout"); // Bỏ qua các URL /login và /logout
    }
}
