package com.oracle.hrb.zhzw.intercepter;

import com.oracle.hrb.zhzw.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginIntercepter implements HandlerInterceptor {
    // 放行特定访问路径
    private List<String> paths;

    public LoginIntercepter() {
        paths = new ArrayList<>();
        paths.add("/login.html");
        paths.add("/user/login");
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("登录状态拦截器............................................");
        // 放行登录的路径
        String uri = request.getRequestURI();
        System.out.println(uri);
        for(String path : paths) {
            if(path.equals(uri)) {
                return true;
            }
        }
        // 判断登录状态
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            try {
                response.sendRedirect("/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
